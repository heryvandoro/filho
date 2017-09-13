package com.filho.filho.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by HeryVandoro on 9/8/2017.
 */

public class JSONParser {
    public static Vector<JSONObject> getArray(JSONObject data, String key){
        JSONArray arr = null;
        Vector<JSONObject> result = new Vector<JSONObject>();
        try {
            arr = data.getJSONArray(key);
            for (int i=0; i<arr.length(); i++)
                result.add(arr.getJSONObject(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static JSONObject getObject(String key){
        JSONObject result = null;
        try{
            result = new JSONObject(key);
        }catch (Exception e){ }
        return result;
    }
}
