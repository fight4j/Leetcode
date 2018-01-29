package Ningbo.DP;

import java.util.Set;

/**
 * Created by zhang on 7/1/16.
 *
 * String: lintcode     set {"lint", "code"}
 *
 *
 *  0 1 2 3 4 5 6 7 8
 *    l i n t c o d e
 *  t f f f t f f f t
 *
 *  思路:dp(i)为前i个字符串是否可被break
 *  dp(i)=true 如果前面某一点为dp(j)为true,且j-i的字符串在dict中,j倒序往前走
 *  访问到i时, 访问到的字符是chatAt(i - 1), 例如i=3,j=2时,subString(j, i)时是n,这一点经常比较别扭,多画图
 *
 *  错误点:1. s.length()==0 dict.size==0的情况下,答案为true,后将这个归并到后面的解中,即dp[0]=true
 *        2. substring(j, i)
 *        3. 原写法LTE,加入对最长word_length的对比
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
//        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
//            return false;
//        }
        if (s == null || dict == null) {
            return false;
        }
        int maxWordLength = 0;
        for (String word : dict) {
            maxWordLength = Math.max(word.length(), maxWordLength);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i] = false;
            for (int j = i - 1; j >= 0; j--) {
//                String subString = s.substring(j + 1, i);

                //optimize
                if (i - j > maxWordLength) {
                    break;
                }

                String subString = s.substring(j, i);
                if (dp[j] && dict.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
