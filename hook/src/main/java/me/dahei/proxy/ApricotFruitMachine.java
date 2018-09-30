package me.dahei.proxy;

/**
 * created by yubosu
 * 2018年09月30日11:01 AM
 */
public class ApricotFruitMachine implements CakeMachine {

    private CakeMachine cakeMachine;


    public ApricotFruitMachine(CakeMachine fruitCakeMachine) {
        this.cakeMachine = fruitCakeMachine;
    }

    @Override
    public void makeCake() {
        this.cakeMachine.makeCake();
        System.out.println("add apricot for cake !");
    }
}
