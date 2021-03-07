package com.example.myparsing;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class CustomJsonObjectRequest extends JsonObjectRequest {


    public CustomJsonObjectRequest(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {

        String expire = response.headers.get("expires");
        Log.d("JsonActivity", "expire header: " + expire);
        String date = response.headers.get("Date");
        Log.d("JsonActivity", "date  header: " + date);
        if(expire.length()<3){
            response.headers.put("expires",date);
        }
        Log.d("JsonActivity", "expire header: " + response.headers.get("expires"));
        return super.parseNetworkResponse(response);
    }
}
