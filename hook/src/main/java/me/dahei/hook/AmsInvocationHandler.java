package me.dahei.hook;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created by yubosu
 * 2018年08月06日下午4:06
 */
public class AmsInvocationHandler implements InvocationHandler {

    private Object iActivityManagerObject;

    public AmsInvocationHandler(Object iActivityManagerObject) {
        this.iActivityManagerObject = iActivityManagerObject;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Log.i("HookUtil", method.getName());
        //我要在这里搞点事情
        if ("startActivity".contains(method.getName())) {
            Log.e("HookUtil","Activity已经开始启动");
            Log.e("HookUtil","小弟到此一游！！！");
        }
        return method.invoke(iActivityManagerObject, objects);
    }


}
