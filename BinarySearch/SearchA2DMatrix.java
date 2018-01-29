package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/17/16.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null ||matrix[0].length == 0) {
            return false;
        }

        int subArrayLength = matrix[0].length;
        int targetArrayIndex = 0;

        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (matrix[start][0] <= target && matrix[start][subArrayLength - 1] >= target) {
            targetArrayIndex = start;
        }
        else if (matrix[end][0] <= target && matrix[end][subArrayLength - 1] >= target) {
            targetArrayIndex = end;
        }
        else {
            return false;
        }

        start = 0;
        end = subArrayLength - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[targetArrayIndex][mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (matrix[targetArrayIndex][start] == target || matrix[targetArrayIndex][end] == target) {
            return true;
        }
        else {
            return false;
        }
    }
}
