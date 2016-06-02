package com.antileak.antileak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.antileak.antileak.Services.LockscreenService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String BROADCAST = "com.antileak.antileak.android.action.broadcast";
    ToggleButton activateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        activateButton = (ToggleButton) findViewById(R.id.activateButton);
        activateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == activateButton) {
            activationSwitch();
        }
    }

    public void activationSwitch() {
        if (activateButton.isChecked()) {
            Intent serviceIntent = new Intent(MainActivity.this, LockscreenService.class);
            startService(serviceIntent);
        } else {
            Intent serviceIntent = new Intent(MainActivity.this, LockscreenService.class);
            stopService(serviceIntent);
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();

    }
}
