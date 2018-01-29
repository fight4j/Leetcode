package Ningbo.ArrayAndNumbers;

/**
 * Created by zhang on 7/12/16.
 *
 * 思路: merge 两个array后取中位数
 * 最后答案取决于len是奇数/偶数   偶数例: len = 4 (0, 1, 2, 3) 返回1, 2的平均值
 *                             奇数:  len = 3              返回index1
 *  时间\空间 复杂度均为 O(M )
 *
 *
 *  错误点: 1. typo错误 ---> mergedArray[len % 2]
 *         2. 返回double, 要除以2.0 否则数据类型不会转化
 *         3. 粗心写错奇数情况下的index
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return -1.0;
        }

        int lengthA = A.length;
        int lengthB = B.length;
        int len = lengthA + lengthB;
        int[] mergedArray = new int[len];

        int indexA = 0;
        int indexB = 0;
        int indexMergedArray = 0;
        while (indexA < lengthA && indexB < lengthB) {
            if (A[indexA] <= B[indexB]) {
                mergedArray[indexMergedArray] = A[indexA];
                indexA++;
            }
            else {
                mergedArray[indexMergedArray] = B[indexB];
                indexB++;
            }
            indexMergedArray++;
        }
        while (indexA < lengthA) {
            mergedArray[indexMergedArray] = A[indexA];
            indexA++;
            indexMergedArray++;
        }
        while (indexB < lengthB) {
            mergedArray[indexMergedArray] = B[indexB];
            indexB++;
            indexMergedArray++;
        }

        if (len % 2 == 0) {
//            return (mergedArray[len % 2] + mergedArray[len % 2 - 1]) / 2;
//            return (mergedArray[len / 2] + mergedArray[len / 2 - 1]) / 2;
            return (mergedArray[len / 2] + mergedArray[len / 2 - 1]) / 2.0;
        }
        else {
//            return mergedArray[(len + 1) / 2];
            return mergedArray[(len - 1) / 2];
        }
    }
}
