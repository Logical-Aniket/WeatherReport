package com.test.aniket.testgsonget.singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Aniket on 24/Oct/15.
 */
public class VolleyHelper {
    private static VolleyHelper INSTANCE;
    private RequestQueue requestQueue;
    private Context context;

    public VolleyHelper(Context context) {
        this.context = context;
        this.requestQueue = getRequestQueue();
    }

    public static synchronized VolleyHelper getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new VolleyHelper(context);
        }
        return INSTANCE;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public void addToRequestQueue(Request request) {
        getRequestQueue().add(request);
    }


}
