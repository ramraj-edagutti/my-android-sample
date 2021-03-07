package com.example.mymakeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /*private Button makeRain;
    private Button showTag;*/

    private int moneyCounter = 0;
    private TextView moneyText;

    //private Button saySomething;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyText = findViewById(R.id.money_text);

       /* makeRain = findViewById(R.id.button_make_rain);
        showTag = findViewById(R.id.button_show_tag);*/

        /*makeRain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MAKERAIN", "onClick: Make It Rain");
            }
        });*/

        /*saySomething = findViewById(R.id.button_say_something);
        saySomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Said Something huh!", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    public void showTag(View v) {
        Log.d("MMR-SHOWTAG", "showTag: Show Money");
    }
    
    public void makeRain(View v) {
        Log.d("MMR-MAKERAIN", "makeRain: Make It Rain");

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        moneyCounter += 1000;
        moneyText.setText(numberFormat.format(moneyCounter));

        switch (moneyCounter) {
            case 5000:
                moneyText.setTextColor(Color.BLUE);
                break;
            case 10000:
                moneyText.setTextColor(Color.CYAN);
                break;
            case 15000:
                moneyText.setTextColor(Color.BLACK);
                break;
            case 20000:
                moneyText.setTextColor(Color.DKGRAY);
                break;
            case 25000:
                moneyText.setTextColor(Color.GRAY);
                break;
            case 30000:
                moneyText.setTextColor(Color.GREEN);
                break;
            case 35000:
                moneyText.setTextColor(Color.MAGENTA);
                break;
            case 40000:
                moneyText.setTextColor(Color.YELLOW);
                break;
            case 50000:
                moneyText.setTextColor(Color.LTGRAY);
                break;
            default:
                moneyText.setTextColor(Color.WHITE);
        }
    }
}