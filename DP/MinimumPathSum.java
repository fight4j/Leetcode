package Ningbo.DP;

/**
 * Created by zhang on 6/28/16.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int length = grid.length;
        int subArrayLength = grid[0].length;

        if (grid == null || length == 0 || subArrayLength == 0) {
            return 0;
        }

        for (int i = 1; i < length; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < subArrayLength; i++) {
            grid[0][i] = grid[0][i - 1]  + grid[0][i];
        }

        for (int i = 1; i < length; i++) {
            for (int j= 1; j < subArrayLength; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[length - 1][subArrayLength - 1];
    }
}
