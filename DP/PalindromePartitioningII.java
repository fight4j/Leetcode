package Ningbo.DP;

/**
 * Created by zhang on 7/1/16.
 *
 * 1. palindromeMatrix判断字符串s[i] - s[j]是否palindrome
 *    i从后往前走,j从i往后走, 如果isisPalindrome[i + 1][j - 1]为回文,则isPalindrome[i][j]取决于i和j所在是否相同
 * 2. minCut主函数, j到i-1为回文,则dp[i] = Math.min(dp[i], dp[j] + 1)
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] palin = palindromeMatrix(s);
        int length = s.length();
        int[] dp = new int[length + 1];

        for (int i = 0; i < length + 1; i++) {
            dp[i] = i - 1;
        }

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (palin[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[length];
    }

    //palindrome[i][j] 为字符串s[i] - s[j]是否palindrome
    public boolean[][] palindromeMatrix(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (i == j || i + 1 == j) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        PalindromePartitioningII testCase = new PalindromePartitioningII();
        String s1 = "s";
        String s2 = "ss";
        String s3 = "ssa";
        String s4 = "sas";
        String s5 = "sa";
        boolean[][] res1 = testCase.palindromeMatrix(s1);
        boolean[][] res2 = testCase.palindromeMatrix(s2);
        boolean[][] res3 = testCase.palindromeMatrix(s3);
        boolean[][] res4 = testCase.palindromeMatrix(s4);
        boolean[][] res5 = testCase.palindromeMatrix(s5);

    }
}
