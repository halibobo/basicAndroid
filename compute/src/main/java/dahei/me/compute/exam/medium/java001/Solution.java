package dahei.me.compute.exam.medium.java001;

import java.util.Arrays;

/**
 * created by yubosu
 * 2018年12月07日3:07 PM
 */
public class Solution {

    public static int threeSumClosest(int[] nums, int target) {
        int sum;
        int len = nums.length;
        if(len<3) throw new NumberFormatException();
        if(len == 3) return nums[0] + nums[1] + nums[2];
        sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len-2; i++) {
            for (int j = i + 1; j < len-1; j++) {
                for (int m = j + 1; m < len; m++) {
                    if(Math.abs(nums[i] + nums[j] + nums[m] -target) < Math.abs(sum -target)){
                        sum = nums[i] + nums[j] + nums[m];
                    }
                }
            }
        }

        return sum;
    }

    private static int threeSumClosest2(int[] nums, int target) {
        int sum;
        int len = nums.length;
        sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len-2; i++) {
            for (int j = i + 1; j < len-1; j++) {
                for (int m = j + 1; m < len; m++) {
                    int s = nums[i] + nums[j] + nums[m];
                    if (s == target || sum == target) {
                        return target;
                    }
                    if(Math.abs(s -target) < Math.abs(sum -target)){
                        sum = s;
                    }
                }
            }
        }

        return sum;
    }

    private static int threeSumClosest3(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 2; i < nums.length; ++i) {
            int start = 0;
            int end = i - 1;
            int des = target - nums[i];
            while (start < end) {
                int pairSum = nums[start] + nums[end];
                int diff = Math.abs(pairSum - des);
                if (diff == 0)
                    return target;
                else {
                    if (diff < min) {
                        val = pairSum + nums[i];
                        min = diff;
                    }
                    if (pairSum > des)
                        --end;
                    else
                        ++start;
                }
            }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 0));
        System.out.println(threeSumClosest3(new int[]{-1, 2, 1, -4}, 0));
    }

}
