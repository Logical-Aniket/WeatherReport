package com.test.aniket.testgsonget.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class Utility {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null;
    }

    /**
     * @param response
     * @return
     */
    public static JsonObject convertToJsonObjectOfGSON(JSONObject response) {
        JsonParser jsonParser = new JsonParser();
        JsonObject gsonObject = (JsonObject) jsonParser.parse(response.toString());
        return gsonObject;
    }
}
