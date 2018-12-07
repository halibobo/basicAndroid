package me.dahei.threadlocal;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.dahei.basis.Test;

/**
 * created by yubosu
 * 2018年11月14日3:55 PM
 */
public class TestThreadLocal implements Test {


    @Override
    public void doTest() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("me.dahei");
                mStringThreadLocal.get();
            }
        };

        t.start();
    }

    @Override
    public String getTestName() {
        return "thread local test";
    }


    public static void main(String[] arg) {
//        new TestThreadLocal().doTest();
        System.out.println(isWeChatPayCode("12345678900000000")+"12345678900000000");
        System.out.println(isWeChatPayCode("22345678900000000"));
        System.out.println(isWeChatPayCode("123456789987654321"));
        System.out.println(isWeChatPayCode("223456789987654321"));
        System.out.println(isWeChatPayCode("13456a00000000"));
        System.out.println(isWeChatPayCode("289830474682077850"));
        System.out.println(isWeChatPayCode("309830474682077850"));
        System.out.println(isWeChatPayCode("319830474682077850"));
        System.out.println(isWeChatPayCode("3019830420773850"));


    }

    public static final String WE_CHAT_PAY_CODE = "^(1[0-5])\\d{16}$";
    public static final String ALI_PAY_CODE = "^(2[5-9]|3[0])\\d{14,22}$";
//    public static final String WE_CHAT_PAY_CODE = "^\\d{18}$";

    public  static boolean isWeChatPayCode(String code) {

//        if (code == null) {
//            return false;
//        }

        Pattern p = Pattern.compile(ALI_PAY_CODE);
        Matcher m = p.matcher(code);
        return m.find();
    }


}
