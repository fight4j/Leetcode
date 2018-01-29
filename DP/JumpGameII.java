package Ningbo.DP;

/**
 * Created by zhang on 6/28/16.
 *
 *
 * A {2, 3, 1, 1, 4}
 * f {0, 1, 1, 2, 2}
 * break是让尽快从j跳到i的位置,i必然是从前面的某一个位置跳1步过来.问题从后向前看
 *
 * 自己最初的思路,定义f[i][j]从i到j的最短步数不成功.后参考答案而做,需理解
 */
public class JumpGameII {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        //f[i]为从头跳到i点时的步数
        int[] f = new int[A.length];
        f[0] = 0;
        for (int i = 1; i < A.length; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (f[j] != Integer.MAX_VALUE && A[j] + j >= i) {
                    f[i] = f[j] + 1;
                    break;
                }
            }
        }
        return f[A.length - 1];
    }
}
