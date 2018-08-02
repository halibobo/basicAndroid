package me.dahei.touchtester;

import android.content.Intent;

import me.dahei.basis.AppContext;
import me.dahei.basis.Test;

/**
 * created by yubosu
 * 2018年08月02日上午10:07
 */
public class TouchTester implements Test{

    @Override
    public void doTest() {
        Intent intent = new Intent(AppContext.getInstance(), TouchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        AppContext.getInstance().startActivity(intent);
    }

    @Override
    public String getTestName() {
        return "Touch tester";
    }
}
