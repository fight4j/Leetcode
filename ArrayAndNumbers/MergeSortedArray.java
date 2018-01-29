package Ningbo.ArrayAndNumbers;

/**
 * Created by zhang on 7/9/16.
 * 对应与merge sorted linked list, 从A数组的后面向前排大的
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (A == null || B == null) {
            return;
        }

        int index = m + n - 1;
        while (m > 0 && n > 0) {
//            A[index] = Math.max(A[m - 1], B[n - 1]);
//            index--;
//            m--;
//            n--;
            if (A[m - 1] > B[n - 1]) {
                A[index] = A[m - 1];
                m -= 1;
            }
            else {
                A[index] = B[n - 1];
                n -= 1;
            }
            index -= 1;
        }
        while (n > 0) {
            A[index] =  B[n - 1];
            index -= 1;
            n -= 1;
        }
    }
}
