package Ningbo.DP;

/**
 * Created by zhang on 7/2/16.
 *
 * A: abcd   B: cbce
 *     c b c e
 *   0 0 0 0 0
 * a 0 0 0 0 0
 * b 0 0 1 1 1
 * c 0 1 1 2 2
 * d 0 1 1 2 2
 * 刚开始按照这个简单case进行了作图推断
 *
 * 后来 A: "www.lintcode.com code"; B: "www.ninechapter.com code";
 * 错误点: 一旦有在lcs断开后且后面还有更长的lcs时,前面的值会被累加,错误
 * 所以修复dp[i][j]为到i, j时从上一个0点,即断开点开始的最大lcs长度,
 * 一旦i != j, 进行重置为0, 而i == j则开始根据i-1 , j-1进行累加,并设置最大值进行不断比较
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }

        int length1 = A.length();
        int length2 = B.length();
        if (length1 == 0 || length2 == 0) {
            return 0;
        }

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1 + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < length2 + 1; i++) {
            dp[0][i] = 0;
        }

//        for (int i = 1; i < length1 + 1; i++) {
//            for (int j = 1; j < length2 + 1; j++) {
//                dp[i][j] = 0;
//                if (A.charAt(i - 1) == B.charAt(j - 1)) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
//                }
//                else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
        int max = 0;
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                dp[i][j] = 0;
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
