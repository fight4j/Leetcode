package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/20/16.
 *
 * 没想到太好的一次解决的办法,通过两次二分,一次尽可能target往前找第一个,一次尽可能start往后找第二个
 * 小小的优化也无非在第一次找到target的时候做标记,使得第二个循环从那个位置开始
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};

        if (A == null || A.length == 0) {
            return result;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (A[start] == target) {
            result[0] = start;
        }
        else if (A[end] == target) {
            result[0] = end;
        }
        else {
            return result;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[end] == target) {
            result[1] = end;
        }
        else if (A[start] == target) {
            result[1] = start;
        }

        return result;
    }
}
