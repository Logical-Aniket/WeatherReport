package com.test.aniket.testgsonget.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.test.aniket.testgsonget.dataobject.Forecast;
import com.test.aniket.testgsonget.dataobject.LocationForecast;
import com.test.aniket.testgsonget.dataobject.LocationResponseDataObject;
import com.test.aniket.testgsonget.dataobject.ResponseDataObject;
import com.test.aniket.testgsonget.fragment.DayForecastFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class DailyForecastPageAdapter extends FragmentStatePagerAdapter {

    private int numDays;
    private FragmentManager fm;
    private ResponseDataObject responseDataObject;
    private LocationResponseDataObject locationResponseDataObject;
    private boolean byCityName = true;
    private final static SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MM");

    public DailyForecastPageAdapter(int numDays, FragmentManager fm, ResponseDataObject responseDataObject, boolean byCityName) {
        super(fm);
        this.numDays = numDays;
        this.fm = fm;
        this.byCityName = byCityName;
        this.responseDataObject = responseDataObject;
    }

    public DailyForecastPageAdapter(int numDays, FragmentManager fm, LocationResponseDataObject locationResponseDataObject, boolean byCityName) {
        super(fm);
        this.numDays = numDays;
        this.fm = fm;
        this.byCityName = byCityName;
        this.locationResponseDataObject = locationResponseDataObject;
    }

    // Page title
    @Override
    public CharSequence getPageTitle(int position) {
        // We calculate the next days adding position to the current date
        Date d = new Date();
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        gc.add(GregorianCalendar.DAY_OF_MONTH, position);

        return sdf.format(gc.getTime());
    }

    @Override
    public Fragment getItem(int num) {
        DayForecastFragment f = null;
        if (byCityName){
            Forecast dayForecast = responseDataObject.getForecastList()[num];
            f = new DayForecastFragment();
            f.setByCityName(byCityName);
            f.setForecast(dayForecast);
        }else{
            LocationForecast locationForecast = locationResponseDataObject.getLocationForecastList()[num];
            f = new DayForecastFragment();
            f.setByCityName(byCityName);
            f.setLocationForecast(locationForecast);
        }
        return f;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    /*
     * Number of the days we have the responseDataObject
     */
    @Override
    public int getCount() {
        return numDays;
    }

}