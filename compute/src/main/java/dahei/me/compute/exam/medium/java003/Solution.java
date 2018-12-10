package dahei.me.compute.exam.medium.java003;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

/**
 * created by yubosu
 * 2018年12月07日6:18 PM
 */
public class Solution {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){
            return "0";
        }
        long num1 = Math.abs((long)numerator);
        long num2 = Math.abs((long)denominator);
        StringBuffer str = new StringBuffer();
        if (numerator < 0 ^ denominator < 0 ){
            str.append('-');
        }
        long div = num1 / num2;
        long mod = num1 % num2;
        if (mod == 0){
            str.append(div);
            return str.toString();
        }
        Map map = new HashMap<Long,Integer>();
        str.append(div+".");
        map.put(mod,str.length());
        num1 = mod * 10;
        while (mod != 0){
            div = num1 / num2;
            mod = num1 % num2;
            str.append(div);
            if (map.containsKey(mod)){
                str.insert((int)map.get(mod),'(');
                str.append(')');
                return str.toString();
            }
            map.put(mod,str.length());
            num1 = mod * 10;
        }
        return str.toString();
    }

    public static void main(String[] args) {

        System.out.println(fractionToDecimal(1,2));
        System.out.println(fractionToDecimal(10,3));
        System.out.println(fractionToDecimal(1,11));
    }
}
