package me.dahei.aidltest;

import android.content.Intent;

import me.dahei.basis.AppContext;
import me.dahei.basis.Test;

/**
 * created by yubosu
 * 2018年07月31日下午3:29
 */
public class AidlTester implements Test {

    @Override
    public void doTest() {
        Intent intent = new Intent(AppContext.getInstance(), TesterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        AppContext.getInstance().startActivity(intent);
    }

    @Override
    public String getTestName() {
        return "Aidl test";
    }
}
