package com.ak11.masterusingpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

        font1 = Typeface.createFromAsset(getAssets(),"fonts/Chunkfive.otf");
        font2 = Typeface.createFromAsset(getAssets(), "fonts/Cooljazz.ttf");
        font3 = Typeface.createFromAsset(getAssets(), "fonts/Wonderbar Demo.otf");

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


    }

    public void specifyFont1(){
        boolean font1Text1Value;
        boolean font2Text1Value;
        boolean font3Text1Value;

        font1Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT1",false);
        font2Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT1",false);
        font3Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT1",false);

        if(font1Text1Value){
            txtNumber1.setTypeface(font1);
        }else if (font2Text1Value){
            txtNumber1.setTypeface(font2);
        }else if(font3Text1Value){
            txtNumber1.setTypeface(font3);
        }
    }
    public void specifyFont2(){
        boolean font1Text1Value;
        boolean font2Text1Value;
        boolean font3Text1Value;

        font1Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT2",false);
        font2Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT2",false);
        font3Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT2",false);

        if(font1Text1Value){
            txtNumber2.setTypeface(font1);
        }else if (font2Text1Value){
            txtNumber2.setTypeface(font2);
        }else if(font3Text1Value){
            txtNumber2.setTypeface(font3);
        }
    }

    public void specifyFont3(){
        boolean font1Text1Value;
        boolean font2Text1Value;
        boolean font3Text1Value;

        font1Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER1_TEXT3",false);
        font2Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER2_TEXT3",false);
        font3Text1Value = sharedPreferences.getBoolean("CHECKBOX_FONT_NUMBER3_TEXT3",false);

        if(font1Text1Value){
            txtNumber3.setTypeface(font1);
        }else if (font2Text1Value){
            txtNumber3.setTypeface(font2);
        }else if(font3Text1Value){
            txtNumber3.setTypeface(font3);
        }
    }

    public void specifyFontSize(){

        txtViewSize1 = sharedPreferences.getString("FONT_SIZE_TEXT1","20");
        txtViewSize2 = sharedPreferences.getString("FONT_SIZE_TEXT2","20");
        txtViewSize3 = sharedPreferences.getString("FONT_SIZE_TEXT3","20");

        txtNumber1.setTextSize(Float.parseFloat(txtViewSize1));
        txtNumber2.setTextSize(Float.parseFloat(txtViewSize2));
        txtNumber3.setTextSize(Float.parseFloat(txtViewSize3));


    }

    @Override
    protected void onResume() {
        super.onResume();
        specifyFont1();
        specifyFont2();
        specifyFont3();
        specifyFontSize();
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