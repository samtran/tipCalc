package com.home.samanthatran.homeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import java.lang.*;
import java.text.DecimalFormat;

import android.R.id;


public class MainActivity extends AppCompatActivity {//implements View.OnClickListener{

    //passing extra variables
    public final static String DisplayTip = "DisplayTip";
    public final static String DisplayTotal = "DisplayTotal";


    public Double cost, percent, tip;
    public int total;
    public RadioButton mom, joe, no;
    public Button calc;
    public EditText bill;
    public TextView tipDisplay, totalDisplay, output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare Radio listeners & bill
        mom = (RadioButton) findViewById(R.id.mom);
        joe = (RadioButton) findViewById(R.id.joe);
        no = (RadioButton) findViewById(R.id.no);
        bill = (EditText) findViewById(R.id.bill);

        //Declare displays for pop up
        tipDisplay = (TextView) findViewById(R.id.tipDisplay);
        totalDisplay = (TextView) findViewById(R.id.totalDisplay);
        output = (TextView) findViewById(R.id.output);

        //Declare calculate button & set listener
        calc = (Button) findViewById(R.id.calculate);
        //calc.setOnClickListener(this);

    }

    //@Override
    public void launchPop(View view){//onClick(View v){
        String temp = bill.getText().toString();
        cost = Double.parseDouble(temp);
        tip = percent * cost;//2.893799999
        String tipString = String.format("%.2f",tip);//"2.89"
        tip = Double.parseDouble(tipString);//#=2.89


        //Rounding to whole number
        double tempTotal = tip + cost;
        total = (int) Math.round(tempTotal);
        tip = total - cost;
        tipString = String.format("%.2f",tip);//"2.89"
        tip = Double.parseDouble(tipString);//#=2.89

        output.setText("Tip: "+ tip.toString()+ "  Total: " + total);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void findPercent(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch(view.getId()) {
            case R.id.mom:
                if(checked)
                    percent = .15;
                    break;
            case R.id.joe:
                if(checked)
                    percent = 0.10;
                    break;
            case R.id.no:
                if(checked)
                    percent = 0.05;
                    break;
        }

    }

}


