package com.ak11.masterusingpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ak11.masterusingpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    TextView txtNumber1, txtNumber2, txtNumber3;
    Typeface font1,font2,font3;

    String txtViewSize1, txtViewSize2, txtViewSize3;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        txtNumber1 = binding.txtTextNumber1;
        txtNumber2 = binding.txtTextNumber2;
        txtNumber3 = binding.txtTextNumber3;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, PreferencesActivity.class);
                 startActivity(intent) ;

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}