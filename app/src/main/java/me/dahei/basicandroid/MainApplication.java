package me.dahei.basicandroid;

import android.app.Application;

import me.dahei.basis.AppContext;
import me.dahei.hook.HookUtil;

/**
 * created by yubosu
 * 2018年07月31日上午9:58
 */
public class MainApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.init(getApplicationContext());
        HookUtil hookUtil = new HookUtil(this);
//        hookUtil.hookAms();
        try {
            hookUtil.attachContext();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
