package Ningbo.DP;

/**
 * Created by zhang on 6/28/16.
 * n == 0 答案认为是1
 * 最终结果来看是fib
 *
 * 刚开始忘加n == 1判断这段,n为1时数组越界,低级错误
 * 跳n步为跳n-1步结果(n-1基础上再跳一步) + n - 2步结果(n-2跳到n有2种: 1步1步跳 或者 直接跳2步, 但因1步1步跳这种方案已在n-1步时体现)
 *
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) {
//            return 0;
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }
}
