package com.test.aniket.testgsonget.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.aniket.testgsonget.R;
import com.test.aniket.testgsonget.dataobject.Forecast;
import com.test.aniket.testgsonget.dataobject.LocationForecast;
import com.test.aniket.testgsonget.util.GlobalConstants;
import com.test.aniket.testgsonget.util.Utility;

import java.io.IOException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayForecastFragment extends Fragment {

    private static final String TAG = DayForecastFragment.class.getSimpleName();
    private View rootView = null;
    TextView tempView;
    TextView descView;
    private ImageView iconWeather;
    private Forecast dayForecast;
    private String params = "";
    private boolean byCityName;
    private LocationForecast locationForecast;
//    private Weather forecast;

    public DayForecastFragment() {
        // Required empty public constructor
    }

    public void setForecast(Forecast dayForecast) {
        this.dayForecast = dayForecast;
    }

    public void setByCityName(boolean byCityName) {
        this.byCityName = byCityName;
    }

    public void setLocationForecast(LocationForecast locationForecast) {
        this.locationForecast = locationForecast;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_day_forecast, container, false);

        tempView = (TextView) rootView.findViewById(R.id.tempForecast);
        descView = (TextView) rootView.findViewById(R.id.skydescForecast);
        iconWeather = (ImageView) rootView.findViewById(R.id.forCondIcon);

        if (byCityName) {
            tempView.setText((int) (dayForecast.getTemp().getMin() - 275.15) + "-"
                    + (int) (dayForecast.getTemp().getMax() - 275.15));
            descView.setText(dayForecast.getWeatherList()[0].getDescription());
            params = dayForecast.getWeatherList()[0].getIcon();
        }else {
            tempView.setText((int) (locationForecast.getMain().getTemp_min() - 275.15) + "-"
                    + (int) (locationForecast.getMain().getTemp_max() - 275.15));
            descView.setText(locationForecast.getWeatherList()[0].getDescription());
            params = locationForecast.getWeatherList()[0].getIcon();
        }

        if (Utility.isNetworkConnected(getContext())) {
            // Now we retrieve the weather icon
            JSONIconWeatherTask task = new JSONIconWeatherTask();
            task.execute(params);
        }

        return rootView;
    }

    private class JSONIconWeatherTask extends AsyncTask<String, Void, Bitmap> {
        String getResponse = null;

        @Override
        protected Bitmap doInBackground(String... params) {

            URL newurl = null;
            Bitmap mIcon_val = null;
            try {
                newurl = new URL(GlobalConstants.URL_IMG + params[0] + ".png");
                mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mIcon_val;
        }

        @Override
        protected void onPostExecute(Bitmap data) {
            super.onPostExecute(data);

            if (data != null) {
                iconWeather.setImageBitmap(data);
            }
        }
    }

}
