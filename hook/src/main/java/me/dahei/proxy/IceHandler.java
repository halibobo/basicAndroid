package me.dahei.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created by yubosu
 * 2018年09月30日11:05 AM
 */
public class IceHandler implements InvocationHandler {

    private Object object;

    public IceHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        System.out.println("add ice for cake !");
        return result;
    }
}
