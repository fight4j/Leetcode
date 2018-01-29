package Ningbo.DP;

/**
 * Created by zhang on 6/28/16.
 * 刚开始错误思路参照了jump game,j从后往前找,找到了比f[i]小的则加1
 * 过不了的case: 100 98 99 2 3, 在3这个地方会出错
 *
 * 这里f(i)的含义其实不是最后的结果,而是i点前有几个比i小的点,最后还是要用max记录lis真正的值
 * max为所有i点及i点前的最大值
 *
 */
public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
//            for (int j = i - 1; j >= 0; j--) {
//                if (f[j] <= f[i]) {
//                    f[i] = f[j] + 1;
//                    break;
//                }
//            }
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {9, 3, 6, 2, 7};
        LongestIncreasingSubsequence case1 = new LongestIncreasingSubsequence();
        case1.longestIncreasingSubsequence(nums);
    }
}
