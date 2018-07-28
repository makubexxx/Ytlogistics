package com.example.yt.ytlogistics;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by chebole on 2018/7/28.
 */

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }

}
