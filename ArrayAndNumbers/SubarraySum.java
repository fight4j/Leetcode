package Ningbo.ArrayAndNumbers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhang on 7/9/16.
 * 暴力算法:
 *      错误点: 如果nums[i]单独一个数满足,也返回,不一定是两个数以上的和
 *
 * Version 2 Hashmap
 *      用hashmap保存(sum, i)键值对 初始化为(0, -1)
 *      只需循环一次 若某一次sum值与上一次相同, 则意味着从上次sum开始到这个sum间的subarray和为0,
 *      很巧妙,不管是单独的一个数0,还是第一个数为0,都可以统一解决
 *
 *      感觉这种算法与dp很像, dp[i]表示前i个数的和,再循环i前的数,若dp[i] == dp[j], 则(j, i - 1)为答案
 *
 * Version 3: DP
 *      验证了上面的想法是对的,dp可以做,只是会LTE,dp时间复杂度跟暴力一样, O(N^2)
 *      但dp的错误点: 循环时for (int i = 1; i < nums.length + 1; i++) 即从dp结果集出发,
 *                  而不是(int i = 0; i < nums.length;)那样从nums[i]的角度出发,结果集为(j-1+1, i-1)
 *
 *
 */
public class SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        /**
         * Solution 1: 暴力算法
         *
         *
         *

        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(i);
                result.add(i);
//                result.add(0);
//                result.add(0);
                return result;
            }
            int sum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0 - nums[i]) {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return new ArrayList<Integer>();*/

        //Version 2 : hashmap
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            map.put(sum, i);
        }
        return new ArrayList<Integer>();

        /**
         * DP
         *

        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
            for (int j = 0; j < i; j++) {
//                if (dp[j] == dp[i]) {
                if (dp[j] == dp[i]) {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(j);
                    result.add(i - 1);
                    return result;
                }
            }
        }
        return new ArrayList<Integer>();*/
    }
}
