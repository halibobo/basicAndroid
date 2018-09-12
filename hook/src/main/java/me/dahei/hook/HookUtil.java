package me.dahei.hook;

import android.app.Instrumentation;
import android.content.Context;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created by yubosu
 * 2018年08月06日下午3:58
 */
public class HookUtil {

    private Class<?> proxyActivity;
    private Context context;

    public HookUtil(Class<?> proxyActivity, Context context) {
        this.proxyActivity = proxyActivity;
        this.context = context;
    }

    public HookUtil(Context context) {
        this.context = context;
    }

    public void hookAms() {
        try {
            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
            Field declaredField = activityManagerNativeClass.getDeclaredField("gDefault");
            declaredField.setAccessible(true);
            Object defaultValue = declaredField.get(null);

            Class<?> singletonClass = Class.forName("android.util.Singleton");
//            Class<?> singletonClass = Class.forName("javax.inject");
            Field mInstanceField = singletonClass.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);

            Object iActivityManagerObject = mInstanceField.get(declaredField);

            Class<?> iActivityManagerIntercept = Class.forName("android.app.IActivityManager");
            AmsInvocationHandler amsInvocationHandler = new AmsInvocationHandler(iActivityManagerObject);
            Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    new Class<?>[]{iActivityManagerIntercept}, amsInvocationHandler);

            mInstanceField.set(defaultValue, proxy);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public void attachContext() throws Exception{
        // 先获取到当前的ActivityThread对象
        Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");
        Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
        currentActivityThreadMethod.setAccessible(true);
        Object currentActivityThread = currentActivityThreadMethod.invoke(null);

        // 拿到原始的 mInstrumentation字段
        Field mInstrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
        mInstrumentationField.setAccessible(true);
        Instrumentation mInstrumentation = (Instrumentation) mInstrumentationField.get(currentActivityThread);

        // 创建代理对象
        Instrumentation evilInstrumentation = new EvilInstrumentation(mInstrumentation);

        // 偷梁换柱
        mInstrumentationField.set(currentActivityThread, evilInstrumentation);
    }
}
