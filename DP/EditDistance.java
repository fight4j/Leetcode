package Ningbo.DP;

/**
 * Created by zhang on 6/29/16.
 *
 * 技巧: 初始化一个int[length1 + 1][length2 + 1] : A的前i个 变到B的前j个的最小步骤
 * 可以看出一个不断计算二维数组每一个元素的过程,通常先初始第一行和第一列
 *
 * example:     cool   =====>    hot
 * after init:
 *             (0)   (1) (2) (3)
 *                 x  x  x  x
 *             (1) x  x  x  x
 *             (2) x  x  x  x
 *             (3) x  x  x  x
 *             (4) x  x  x  x
 * 状态转移: f(1, 1) = A(1) == B(1) ? 1 : 0
 *          f(2, 1) (co====>h, o != h) = Min(
 *                                          f(1, 1)+1 c======>  h  & 去o
 *                                          f(2, 0)+1 co======> '' & 加h
 *                                          f(1, 0)+1 c=======> '' & 去o
 *                                       )
 *
 *          f(2, 2) (co====>ho, o == o) 同理分析
 *
 * 注释点为两处错误点,注意!!
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }

        int length1 = word1.length();
        int length2 = word2.length();

        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        if (length1 == 0 || length2 == 0) {
            return length1 == 0 ? length2 : length1;
        }

        //init
        int[][] f = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1 + 1; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i < length2 + 1; i++) {
            f[0][i] = i;
        }
        //transform
        for (int i = 1; i < length1 + 1; i++) {
            for (int j= 1; j < length2 + 1; j++) {
//                if (word1.charAt(i) == word2.charAt(j)) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = minFromThree(f[i - 1][j - 1], f[i - 1][j] + 1, f[i][j - 1] + 1);
                }
                else {
                    f[i][j] = minFromThree(f[i - 1][j - 1] + 1, f[i - 1][j] + 1, f[i][j - 1] + 1);
                }
            }
        }
        //result
//        return f[length1 - 1][length2 - 1];
        return f[length1][length2];
    }

    private int minFromThree(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }
}
