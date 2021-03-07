package com.example.myparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class JsonActivity extends AppCompatActivity {

    //private TextView textName;
    private TextView textNameValue;
    //private TextView textEmail;
    private TextView textEmailValue;
    //private TextView textUsername;
    private TextView textUsernameValue;
    //private TextView textPhone;
    private TextView textPhoneValue;
    //private TextView textWebsite;
    private TextView textWebsiteValue;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        textNameValue = findViewById(R.id.textNameValue);
        textEmailValue = findViewById(R.id.textEmailValue);
        textUsernameValue = findViewById(R.id.textUsernameValue);
        textPhoneValue = findViewById(R.id.textPhoneValue);
        textWebsiteValue = findViewById(R.id.textWebsiteValue);

        requestQueue = RequestQueueSingleton.getInstance(this.getApplicationContext()).getRequestQueue();


        JsonObjectRequest jsonObjectRequest = getJsonObjectRequest();
        requestQueue.add(jsonObjectRequest);

    }

    private JsonObjectRequest getJsonObjectRequest() {
        String url = "https://jsonplaceholder.typicode.com/users/1";

        JsonObjectRequest jsonObjectRequest = new CustomJsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("JsonActivity", "onResponse: " +response.toString());
                        try {
                            textNameValue.setText(response.getString("name"));
                            textEmailValue.setText(response.getString("email"));
                            textUsernameValue.setText(response.getString("username"));
                            textPhoneValue.setText(response.getString("phone"));
                            textWebsiteValue.setText(response.getString("website"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("JsonActivity", "onErrorResponse: " +error.toString());
                    }
                });

        return jsonObjectRequest;
    }


}