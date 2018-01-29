package Ningbo.DP;

/**
 * Created by zhang on 6/29/16.
 *
 * 0629:S字符串内可以跳跃,所以自己的思路f[i][j], S的前i个,T的前j个行不通
 * f[i] S的前i个匹配T也行不通
 *
 * 0630:上一天的思路其实是对的
 * S[i] == T[j] ----> dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
 * S[i] != T[j] ----> dp[i][j] = dp[i-1][j]
 *
 * 例子   S = 'rabbbit'    T = 'rabit'
 *         r a b i t
 *      1
 *   r     1 0 0 0 0
 *   a     1 1
 *   b     1 1 1
 *   b     1 1 2 0
 *   b     1 1 3 0 0
 *   i     1 1 3 3 0
 *   t     1 1 3 3 3
 *
 *  从上面图形化二维数组可以清晰上面递推关系
 *
 *  代码写的时候具体还是按照edit distance之类的模板来,初始化dp[i][0] & dp[0][i]
 *  循环从1开始
 *
 *  错误点:初始化时误将dp[0][0]重置成了0,导致答案错误
 */
public class DistinctSubsequence {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int length1 = S.length();
        int length2 = T.length();
        if (length1 < length2) {
            return 0;
        }
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1 + 1; i++) {
            dp[i][0] = 1;
        }
//        for (int i = 0; i < length2 + 1; i++) {
        for (int i = 1; i < length2 + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String S = "b";
        String T = "b";
        DistinctSubsequence testCase = new DistinctSubsequence();
        int result = testCase.numDistinct(S, T);
    }
}
