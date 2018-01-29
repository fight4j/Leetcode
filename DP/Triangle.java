package Ningbo.DP;

/**
 * Created by zhang on 6/28/16.
 * 定义f[x][y]为(x, y)到最后一行的minimum path sum.
 *
 * triangle只有一层直接返回结果,2层以后从最后一层开始向上倒推结果
 * example
 *       -1
 *      2  3
 *     1 -1 -3
 *
 * f(2, 0) = 1
 * f(2, 1) = -1         f(1, 0) = 1
 * f(2, 2) = -3   --->  f(1, 1) = 0  --->   f(0, 0) = -1
 *
 * 注意错误答案中的细节!
 */

public class Triangle {
    public int minimumTotal(int[][] triangle) {
        int height = triangle.length;
        if (triangle == null || height == 0) {
            return 0;
        }

        if (height == 1) {
            return triangle[0][0];
        }

        int[][] result = new int[height][height];
        //initial
        for (int i = 0; i < height; i++) {
            result[height - 1][i] = triangle[height - 1][i];
        }
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
//                result[i][j] = Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j];
                result[i][j] = Math.min(result[i + 1][j], result[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return result[0][0];
    }

    public static void main(String[] args) {
        Triangle angle = new Triangle();
//        int[][] f = {{-1}, {2, 3}, {1, -1, -3}};
        int[][] f = {{1}, {2, 3}};
        int result = angle.minimumTotal(f);
    }
}
