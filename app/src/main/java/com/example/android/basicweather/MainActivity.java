package com.example.android.basicweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements WeatherAdpater.OnWeatherCheckChangedListener {

    private RecyclerView mWeatherListRecyclerView;
    private WeatherAdpater mWeatherAdpater;
    private Toast mT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> dayWeather = new ArrayList<>();
        dayWeather.add("Monday Jan 27th Rainy 12C");
        dayWeather.add("Tuesday Jan 28th Rainy 12C");
        dayWeather.add("Wednesday Jan 29th Rainy 10C");
        dayWeather.add("Thursday Jan 30th Cloudy 15C");
        dayWeather.add("Friday Jan 31st Cloudy and Windy 10C");
        dayWeather.add("Saturday Feb 1st Rainy adn Windy 5C ");
        dayWeather.add("Sunday Feb 2nd Cloudy and Windy 7C");
        dayWeather.add("Monday Feb 3rd Rainy 12C");
        dayWeather.add("Tuesday Feb 4th Cloudy and Windy 9C");
        dayWeather.add("Wednesday Feb 5th Windy 5C");
        dayWeather.add("Thursday Feb 6th Sunny 12C");
        dayWeather.add("Friday Feb 7th Rainy and Cold 5C");

        mT = null;


        mWeatherListRecyclerView = findViewById(R.id.rv_weather);

        mWeatherListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mWeatherListRecyclerView.setHasFixedSize(true);
        mWeatherAdpater = new WeatherAdpater(this,dayWeather);
        mWeatherAdpater.setClickListener(this);
        mWeatherListRecyclerView.setAdapter(mWeatherAdpater);

    }
    @Override
    public void onWeatherCheckedChanged(View v, int pos){
        String detailsWeather [] = new String[]{
                "High will be 15C and low will be 10C.Bring rain jacket!",
                "High will be 13C and low will be 10C.Bring rain jacket!",
                "High will be 11C and low will be 7C.Bring rain jacket!",
                "High will be 16C and low will be 13C.40% Chance raining at noon",
                "High will be 12C and low will be 9C.Wear something warm!",
                "High will be 7C and low will be 3C.Bring rain jacket and extra layer!",
                "High will be 10C and low will be 5C.30% Chance will rain through out the day",
                "High will be 13C and low will be 10C. It is pouring outside, bring rain jacket",
                "High will be 10C and low will be 8C. No sun all day and 20% chance of rain",
                "High will be 6C and low will be 4C. Bring extra layer, it  is very windy outside.",
                "High will be 13C and low will be 10C. Not too cold and it is nice outside.",
                "High will be 7C and low will be 3C. It is pouring and cold.Bring a rain jacket"};


        Toast.makeText(this ,detailsWeather[pos] ,Toast.LENGTH_SHORT).show();
    }
}
