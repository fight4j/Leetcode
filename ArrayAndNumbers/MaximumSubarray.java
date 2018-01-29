package Ningbo.ArrayAndNumbers;

/**
 * Created by zhang on 7/10/16.
 *
 * 求最大值,每次遍历求当前sum的最大值与最小值,答案用最大值-最小值即是最大值
 * 用dp的思维, 最大值初始化时用min_value, 最小值
 *
 * 错误点: min值一直保持更新,答案maxResult需要用当前值减去最小值,否则会出现倒序的错误答案
 *        min值是当前点之前的min值,需初始化为0
 *
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
//        int maxSum = Integer.MIN_VALUE;
        int maxResult = Integer.MIN_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            maxSum = Math.max(maxSum, sum);
//            minSum = Math.min(minSum, sum);
            minSum = Math.min(minSum, sum);
            sum += nums[i];
//            maxResult = Math.max(maxResult, maxResult - minSum);
            maxResult = Math.max(maxResult, sum - minSum);
        }
        return maxResult;
    }
}
