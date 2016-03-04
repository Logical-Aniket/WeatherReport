package com.test.aniket.testgsonget.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.test.aniket.testgsonget.R;
import com.test.aniket.testgsonget.adapter.DailyForecastPageAdapter;
import com.test.aniket.testgsonget.dataobject.Forecast;
import com.test.aniket.testgsonget.dataobject.LocationForecast;
import com.test.aniket.testgsonget.dataobject.LocationResponseDataObject;
import com.test.aniket.testgsonget.dataobject.ResponseDataObject;
import com.test.aniket.testgsonget.request.GsonJsonObjectRequest;
import com.test.aniket.testgsonget.service.GpsTracker;
import com.test.aniket.testgsonget.singleton.VolleyHelper;
import com.test.aniket.testgsonget.util.GlobalConstants;
import com.test.aniket.testgsonget.util.Utility;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Context mContext = null;
    private String params = "";

    private TextView cityText;
    private TextView condDescr;
    private TextView temp;
    private TextView unitTemp;

    private ImageView imgView;

    private static String forecastDaysNum = "14";
    private ViewPager pager;

    private Location currentLocation = null;
    private String url = "";

    private ProgressDialog pDialog = null;
    private GpsTracker gpsTracker = null;

    private boolean byCityName = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContext = this;

        bindViews();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewDialog();
            }
        });

    }

    private void bindViews() {
        cityText = (TextView) findViewById(R.id.cityText);
        temp = (TextView) findViewById(R.id.temp);
        unitTemp = (TextView) findViewById(R.id.unittemp);
        unitTemp.setText("°C");
        condDescr = (TextView) findViewById(R.id.skydesc);

        pager = (ViewPager) findViewById(R.id.pager);
        imgView = (ImageView) findViewById(R.id.condIcon);
    }

    private void createNewDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        new AlertDialog.Builder(mContext, R.style.MyCustomDialogTheme);
        final EditText edittext = new EditText(MainActivity.this);
        edittext.setInputType(InputType.TYPE_CLASS_TEXT);
        edittext.setImeOptions(EditorInfo.IME_ACTION_DONE);
        alert.setMessage("Enter Name of The City!");
        alert.setTitle("Weather");

        alert.setView(edittext);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String city = edittext.getText().toString();
                if (city.isEmpty())
                    Toast.makeText(mContext,
                            "Please Enter Appropriate City!", Toast.LENGTH_SHORT).show();
                else {
                    if (Utility.isNetworkConnected(mContext)) {

                        showProgressDialog();

                        byCityName = true;
                        url = GlobalConstants.URL_TEST;
                        params = "q=" + city + "&cnt=14&appid=44db6a862fba0b067b1930da0d769e98";
                        // By Volley
                        GsonJsonObjectRequest gsonJsonObjectRequest = volleyWithGSON();
                        VolleyHelper.getInstance(mContext).addToRequestQueue(gsonJsonObjectRequest);
                    }
                }
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // what ever you want to do with No option.
            }
        });

        alert.show();
    }

    private void showProgressDialog() {
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.show();
    }

    private GsonJsonObjectRequest volleyWithGSON() {
        GsonJsonObjectRequest gsonJsonObjectRequest = new GsonJsonObjectRequest(Request.Method.GET, url + params, createJson(), new Response.Listener<JSONObject>() {
            /**
             * Called when a response is received.
             *
             * @param response
             */
            @Override
            public void onResponse(JSONObject response) {

                Log.e(TAG, "Server response: " + String.valueOf(response));

                JsonObject responseJsonObject = Utility.convertToJsonObjectOfGSON(response);

                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                Gson gson = gsonBuilder.create();

                DailyForecastPageAdapter adapter = null;
                pager.setAdapter(null);

                if (byCityName) {
                    //convert the json string back to object
                    ResponseDataObject obj = gson.fromJson(responseJsonObject, ResponseDataObject.class);
                    Log.e(TAG, "Server Response: " + obj.toString());

                    Forecast[] forecasts = obj.getForecastList();
                    Log.e(TAG, "Server Response: " + forecasts[0].toString());

                    setInformation(obj);
                    adapter = new DailyForecastPageAdapter(Integer.parseInt(forecastDaysNum), getSupportFragmentManager(), obj, byCityName);
                } else {
                    //convert the json string back to object
                    LocationResponseDataObject obj = gson.fromJson(responseJsonObject, LocationResponseDataObject.class);
                    Log.e(TAG, "Server Response: " + obj.toString());

                    LocationForecast[] locationForecasts = obj.getLocationForecastList();
                    Log.e(TAG, "Server Response: " + locationForecasts[0].toString());

                    setInformation(obj);
                    adapter = new DailyForecastPageAdapter(Integer.parseInt(forecastDaysNum), getSupportFragmentManager(), obj, byCityName);
                }

                pager.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                if (pDialog.isShowing())
                    pDialog.hide();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (pDialog.isShowing())
                    pDialog.hide();
//                if (error != null) Log.e(TAG, error.getMessage());
            }
        });

        return gsonJsonObjectRequest;
    }

    private void setInformation(LocationResponseDataObject obj) {
        cityText.setText(obj.getLocationForecastList()[0].getName());
        temp.setText("" + Math.round((obj.getLocationForecastList()[0].getMain().getTemp() - 275.15)));
//        condDescr.setText(obj.getLocationForecastList()[0].getWeatherList()[0].getMain() + "(" + obj.getForecastList()[0].getWeatherList()[0].getDescription() + ")");
    }

    private void setInformation(ResponseDataObject obj) {
        cityText.setText(obj.getCity().getName() + "," + obj.getCity().getCountry());
        temp.setText("" + Math.round((obj.getForecastList()[0].getTemp().getDay() - 275.15)));
        condDescr.setText(obj.getForecastList()[0].getWeatherList()[0].getMain() + "(" + obj.getForecastList()[0].getWeatherList()[0].getDescription() + ")");
    }

    private String createJson() {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_by_location) {
            byCityName = false;
            usingService();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void usingService() {
        gpsTracker = new GpsTracker(MainActivity.this);
        currentLocation = gpsTracker.getLocation();

        if (gpsTracker.canGetLocation()) {
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();

            String lat = "";
            String lon = "";

            lat = String.valueOf(latitude);
            lon = String.valueOf(longitude);
            if (lat.isEmpty() || lon.isEmpty())
                Toast.makeText(MainActivity.this, "Check GPS Settings!", Toast.LENGTH_LONG).show();
            else {
                showProgressDialog();

                url = GlobalConstants.URL_LOC;
                params = "lat=" + lat + "&lon=" + lon + "&cnt=14&appid=44db6a862fba0b067b1930da0d769e98";
                // By Volley
                GsonJsonObjectRequest gsonJsonObjectRequest = volleyWithGSON();
                VolleyHelper.getInstance(mContext).addToRequestQueue(gsonJsonObjectRequest);
            }

        } else {
            Toast.makeText(MainActivity.this, "Check Network/GPS Settings!", Toast.LENGTH_LONG).show();
        }
    }
}
