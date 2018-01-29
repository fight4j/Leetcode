package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/19/16.
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     * 指针往中间丢，如果中间的数比左边小，则左边的小数组递归符合该有peak数组的要求
     * 如果中间比右边小，则右边小数组符合
     * 另外如果比两边都大，则该数符合
     * 最后返回-1则是为了编译通过
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            }
            else if (A[mid] < A[mid + 1]) {
                start = mid;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
