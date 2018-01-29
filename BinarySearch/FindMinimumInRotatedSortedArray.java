package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/18/16.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }

        int start = 0;
        int end = num.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[start] < num[mid] && num[mid] < num[end]) {
                return num[start];
            }
            else if (num[start] < num[mid] && num[mid] > num[end]) {
                start = mid;
            }
            else if (num[end] > num[mid] && num[mid] < num[end]) {
                end = mid;
            }
        }

        return Math.min(num[start], num[end]);
    }
}
