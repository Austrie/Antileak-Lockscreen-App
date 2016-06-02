package com.antileak.antileak.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.antileak.antileak.Lockscreen;
import com.antileak.antileak.Services.LockscreenService;

public class LockscreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Check if screen is off/on, and if activated, start lockscreen
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)
                || intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            startLockScreen(context);
        }
        //Check if booted, if so start service for service to decide to activate screen
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            startLockscreenService(context);
            startLockScreen(context);
        }



        //Verify if lockscreen should be enable or disabled
        //ToDO: Place this around "startLockscreen(context);
        /*Bundle bundle = intent.getExtras();
        int state = bundle.getInt("State");
        if (state == 1) {
        }else {
                }*/
        }

    //Start lockscreen method
    private void startLockScreen(Context context) {
        Intent startLockscreen = new Intent(context, Lockscreen.class);
        startLockscreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startLockscreen);
    }

    //Start lockscreen service method
    private void startLockscreenService(Context context) {
        Intent startLockscreenService = new Intent(context, LockscreenService.class);
        startLockscreenService.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startLockscreenService);
    }
}
