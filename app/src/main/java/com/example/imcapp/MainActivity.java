package com.example.imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        img  =(ImageView) findViewById(R.id.img);

    }

    public void calculateBMI(View v){

        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();


        if (heightStr !=null && !"".equals(heightStr) && weightStr !=null &&!"".equals(weightStr))
        {
            float heightValue = Float.parseFloat(heightStr)/100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi =weightValue/(heightValue*heightValue);

            displayBMI(bmi);
        }

    }
    private void displayBMI(float bmi)
    {
        String bmilabel ="";


        if (Float.compare(bmi,15f) <= 0)
        {
            img.setImageResource(R.drawable.verryskinny);

            bmilabel= getString(R.string.very_severly_under_weight);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.verryskinny);


        }else if (Float.compare(bmi,15f)>0 && Float.compare(bmi,16f )<=0) {
            bmilabel=getString(R.string.severly_under_weight);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.skinny);
        }
        else if (Float.compare(bmi,16f)>0 && Float.compare(bmi,18.5f )<=0) {
            bmilabel=getString(R.string.under_weight);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.skinny);
        }
        else if (Float.compare(bmi,18.5f)>0 && Float.compare(bmi,25f )<=0) {
            bmilabel=getString(R.string.normal);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.normal);
        }
        else if (Float.compare(bmi,25f)>0 && Float.compare(bmi,30f )<=0) {
            bmilabel=getString(R.string.over_weight);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.fat);
        }
        else if (Float.compare(bmi,30f)>0 && Float.compare(bmi,35f )<=0) {
            bmilabel=getString(R.string.obese_class_1);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.od1);
        }
        else if (Float.compare(bmi,35f)>0 && Float.compare(bmi,40f )<=0) {
            bmilabel=getString(R.string.obese_class_2);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.od2);
        }
        else {
            bmilabel=getString(R.string.obese_class_3);
            //img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.od3);
        }



        bmilabel = bmilabel+"\n\n";
        result.setText(bmilabel);
    }


}
