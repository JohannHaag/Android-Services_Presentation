package com.dipl.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MainActivity extends Service {
    private IBinder mBinder = new LocalBoundedService();
    Random randomNumber = new Random();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        return true;
    }

    public int genRandomNumber() {
        return randomNumber.nextInt(10000);
    }

    public class LocalBoundedService extends Binder {
        MainActivity getService() {
            return MainActivity.this;
        }
    }
}
