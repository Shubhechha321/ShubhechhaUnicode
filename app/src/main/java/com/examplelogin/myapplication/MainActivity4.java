package com.examplelogin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.examplelogin.myapplication.Retrofit.ApiClient;
import com.examplelogin.myapplication.Retrofit.ApiInterface;
import com.examplelogin.myapplication.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity4 extends AppCompatActivity {
    ImageView search;
    TextView tempText,descText,humidityText;
    EditText textField;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        search=findViewById(R.id.search);
        tempText=findViewById(R.id.tempText);
        descText=findViewById(R.id.descText);
        humidityText=findViewById(R.id.humidityText);
        textField=findViewById(R.id.textField);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWeatherData(textField.getText().toString().trim());
            }
        });
    }
    private void getWeatherData(String name){
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
       // Call<Example> call=apiInterface.getWeatherData(name);
        Call<Example> call=apiInterface.getWeatherData(name);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                tempText.setText("Temperature" + " " + response.body().getMain().getTemp());
                descText.setText("Feels Like" + " " + response.body().getMain().getFeels_like());
                humidityText.setText("Humidity" + " " + response.body().getMain().getHumidity());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}