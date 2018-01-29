package Ningbo.DP;

/**
 * Created by zhang on 6/28/16.
 *
 * 答案结构同jump game ii
 * f[0]可以跳到,后面的每个点,在此点前如有一个点可以跳到(A[j] + j >= i),即可以到达
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }

        //定义f[i]为是否能跳到i点
        boolean[] f = new boolean[A.length];
        f[0] = true;
        for (int i = 1; i < A.length; i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {
//                if (f[j] && A[j] + j >= A[i]) {
                if (f[j] && A[j] + j >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[A.length - 1];
    }
}
