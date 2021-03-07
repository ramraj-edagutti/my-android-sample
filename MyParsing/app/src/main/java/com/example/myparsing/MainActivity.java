package com.example.myparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "GOOGLE_REQUEST";
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //With singleton request pool
        requestQueue = RequestQueueSingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        //Adhoc request
        //requestQueue = Volley.newRequestQueue(this.getApplicationContext());
        StringRequest stringRequest = getStringRequest();

        requestQueue.add(stringRequest);

        //setupRequestQueue();
    }

    private StringRequest getStringRequest() {
        final TextView textView = findViewById(R.id.textView);
        String googleUrl = "https://jsonplaceholder.typicode.com/users";

        return new StringRequest(Request.Method.GET, googleUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, response);
                    textView.setText("Response is: " + response.substring(0, 500));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, "onErrorResponse: " + error.toString());
                }
            });
    }

    private void setupRequestQueue() {
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); //Cap at 1MB
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();
        final TextView textView = findViewById(R.id.textView);

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
                textView.setText("setupRequestQueue: "+ response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "setupRequestQueue: Error processing request");
            }
        });

        requestQueue.add(stringRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll(TAG);
        }
    }
}