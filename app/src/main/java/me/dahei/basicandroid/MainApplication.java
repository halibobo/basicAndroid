package me.dahei.basicandroid;

import android.app.Application;

import me.dahei.basis.AppContext;

/**
 * created by yubosu
 * 2018年07月31日上午9:58
 */
public class MainApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.init(getApplicationContext());
    }
}
