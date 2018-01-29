package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/17/16.
 *
 * Key point 1: 粗心落下了这个判断case
 * 最后判断用if else if else的判断会更好
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (A[start] > target) {
            return start;
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        if (A[end] < target) {
            return end + 1;
        }
        //Key point 1
        if (A[start] < target && A[end] > target) {
            return end;
        }

        return -1;
    }
}
