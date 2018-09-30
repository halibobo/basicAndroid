package me.dahei.proxy;

import java.lang.reflect.Proxy;

/**
 * created by yubosu
 * 2018年09月30日10:58 AM
 */
public class CakeShop {

    public static void main(String[] arg) {
        new BreadCakeMachine().makeCake();
        new ChocolateCakeMachine().makeCake();
        new CurrantCakeMachine().makeCake();
        new FruitCakeMachine().makeCake();

//        new ApricotFruitMachine(new FruitCakeMachine()).makeCake();
//        new ApricotFruitMachine(new BreadCakeMachine()).makeCake();

        FruitCakeMachine fruitCakeMachine = new FruitCakeMachine();
        IceHandler iceHandler = new IceHandler(fruitCakeMachine);

        CakeMachine cakeMachine = (CakeMachine) Proxy.newProxyInstance(
                fruitCakeMachine.getClass().getClassLoader(),
                fruitCakeMachine.getClass().getInterfaces(),
                iceHandler);
        cakeMachine.makeCake();
    }
}
