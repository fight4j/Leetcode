package Ningbo.DP;

/**
 * Created by zhang on 7/2/16.
 *
 * 此题为跑oj时测试出来:
 * i, j所在相等时, dp[i][j]不一定由矩阵左边或上边而来:反例:be 和 aee在 第二个e相交时,不能累加1,而是由左上角的答案+1累计而来
 *        不相等时,dp[i][j]不会丢失上一步的结果,由上边或左边的较大者累计而来
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String A, String B) {
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

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                dp[i][j] = 0;
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
