package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/20/16.
 * case 1: 左半部分数组为升序数组,若target落在A[start]和A[mid]间,则end指针前移,反之start后移
 * case 2: 右半部分为升序数组,同理判断
 *
 *
 * rotated数组只须将A[start]和A[mid]对比,即可知道哪半部分是顺序,也就是pivot的对应另一半半部分
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[start] <= A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }
        else if (A[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
}
