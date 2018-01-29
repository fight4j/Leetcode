package Ningbo.DP;

/**
 * Created by zhang on 6/27/16.
 * 先0 1 互转, 0表示路径无法走通
 * 第一行第一列特殊处理,但凡一个为0,后续全为0
 * 最后合并结果时不对obstacle的点做处理
 *
 * 注释错误点:第一行第一列特殊处理时:应判断当前点或当前点前一点为obstacle时才改当前点为obstacle,
 * 而不是错误答案的直接根据前一点
 * 或改为obstacleGrid[0][i] = obstacleGrid[0][i - 1] == 0 ? 0 : obstacle[0][i];
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int length = obstacleGrid.length;
        int subArrayLength = obstacleGrid[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < subArrayLength; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
            }
        }
        //第一行第一列特殊处理
        for (int i = 1; i < length; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i - 1][0] == 0 || obstacleGrid[i][0] == 0) ? 0 : 1;
        }
        for (int i = 1; i < subArrayLength; i++) {
//            obstacleGrid[0][i] = obstacleGrid[0][i - 1] == 0 ? 0 : 1;
            obstacleGrid[0][i] = (obstacleGrid[0][i - 1] == 0 || obstacleGrid[0][i] == 0) ? 0 : 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j= 1; j < subArrayLength; j++) {
                if (obstacleGrid[i][j] == 0) {
                    continue;
                }
                else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[length - 1][subArrayLength - 1];
    }

    public static void main(String[] args) {
        UniquePathsII pathsII = new UniquePathsII();
        int[][] f = {{0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, };
        int result = pathsII.uniquePathsWithObstacles(f);
    }
}
