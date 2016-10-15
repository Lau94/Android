package com.example.laurensperemans.activities1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


    private TextView txtStart,txtCreate,txtResume,txtRestart;
    private int onCreateCounter;
    private int onRestartCounter;
    private int onStartCounter;
    private int onResumeCounter;
    private int onPauseCounter;
    private int onStopCounter;
    private int onDestroyCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtStart = (TextView) findViewById(R.id.textView);
        txtCreate = (TextView) findViewById(R.id.textView2);
        txtResume = (TextView) findViewById(R.id.textView3);
        txtRestart = (TextView) findViewById(R.id.textView4);

        Button launchActivityTwoButton = (Button) findViewById(R.id.button);
        launchActivityTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityTwoIntent = new Intent(getApplicationContext(),Activity2.class);
                startActivity(activityTwoIntent);
            }
        });

        if (savedInstanceState != null) {

            onCreateCounter = savedInstanceState.getInt("onCreate");
            onRestartCounter = savedInstanceState.getInt("onRestart");
            onStartCounter = savedInstanceState.getInt("onStart");
            onResumeCounter = savedInstanceState.getInt("onResume");
            onPauseCounter = savedInstanceState.getInt("onPause");
            onStopCounter = savedInstanceState.getInt("onStop");
            onDestroyCounter = savedInstanceState.getInt("onDestroy");

        }

        onCreateCounter++;
        displayCounts();
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
    @Override
    public void onStart() {
        super.onStart();
        onStartCounter++;
        displayCounts();

    }

    @Override
    public void onResume() {
        super.onResume();
        onResumeCounter++;
        displayCounts();

    }

    @Override
    public void onPause() {
        super.onPause();
        onPauseCounter++;
        displayCounts();
    }

    @Override
    public void onStop() {
        super.onStop();
        onStopCounter++;
        displayCounts();

    }

    @Override
    public void onRestart() {
        super.onRestart();
        onRestartCounter++;
        displayCounts();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        onDestroyCounter++;
        displayCounts();

    }
@Override
public void onSaveInstanceState(Bundle savedInstanceState){
    savedInstanceState.putInt("onCreate",onCreateCounter);
    savedInstanceState.putInt("onStart",onStartCounter);
    savedInstanceState.putInt("onResume", onResumeCounter);
    savedInstanceState.putInt("onRestart", onRestartCounter);
    savedInstanceState.putInt("onPause", onPauseCounter);
    savedInstanceState.putInt("onStop", onStopCounter);
    savedInstanceState.putInt("onDestroy", onDestroyCounter);
    super.onSaveInstanceState(savedInstanceState);
}


public void displayCounts(){

    txtCreate.setText("onCreate Calls:" + onCreateCounter);
    txtStart.setText("onStart Calls:" + onStartCounter);
    txtResume.setText("onResume Calls:" + onResumeCounter);
    txtRestart.setText("onRestart Calls:" + onRestartCounter);
}
}
