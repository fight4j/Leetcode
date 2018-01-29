package Ningbo.DP;

/**
 * Created by zhang on 7/3/16.
 *
 * S1: aabcc    S2: dbbca     S3: aadbbcbcac
 *     d b b c a
 *   t f f f f f
 * a t f f f f f
 * a t t t t t f
 * b f
 * c f
 * c f
 *
 * 为t的条件: 数组左边或上面已经有一个t的情况下,当前s1 或 s2的值(对应的,左边为t则取s2, 上面为t取s1)与s3的i + j的值相等
 *
 * 错误点: 又在s1.charAt(i - 1)上写错!
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();

        if (length1 + length2 != length3) {
            return false;
        }

        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        for (int i = 1; i < length1 + 1; i++) {
//            dp[i][0] = (s1.charAt(i) == s3.charAt(i)) && dp[i - 1][0];
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0];
        }
        for (int i = 1; i < length2 + 1; i++) {
//            dp[0][i] = (s2.charAt(i) == s3.charAt(i)) && dp[0][i - 1];
            dp[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && dp[0][i - 1];
        }

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
//                boolean case1 = dp[i][j - 1] && s2.charAt(j) == s3.charAt(i + j);
//                boolean case2 = dp[i - 1][j] && s1.charAt(i) == s3.charAt(i + j);
                boolean case1 = (s2.charAt(j - 1) == s3.charAt(i + j - 1)) && dp[i][j - 1];
                boolean case2 = (s1.charAt(i - 1) == s3.charAt(i + j - 1)) && dp[i - 1][j];
                dp[i][j] = case1 || case2;
            }
        }
        return dp[length1][length2];
    }
}
