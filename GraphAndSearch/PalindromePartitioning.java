package Ningbo.GraphAndSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 7/26/16.
 *
 * 思路: DFS
 *
 * 注意点: java subString(start, end) start闭区间,end开区间 "sefaw".subString(0, 1) = "s", "sefaw".subString(0, 5)为自己
 *        所以递归退出条件为pos == s.length() 即最后pos会累加到length()
 *
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> palindromes = new ArrayList<String>();
        dfsHelper(s, 0, palindromes, result);
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void dfsHelper(String s, int pos, ArrayList<String> palindromes, ArrayList<List<String>> result) {
//        if (pos == palindromes.size()) {
//            result.add(palindromes);
        if (pos == s.length()) {
            result.add(new ArrayList<String>(palindromes));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String current = s.substring(pos, i + 1);
            if (!isPalindrome(current)) {
                continue;
            }

            palindromes.add(current);
            dfsHelper(s, i + 1, palindromes, result);
            palindromes.remove(palindromes.size() - 1);
        }
    }
}
