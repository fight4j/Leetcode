package Ningbo.ArrayAndNumbers;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by zhang on 7/9/16.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        /**
         *
         * 暴力算法
         *

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            int[] result = new int[0];
            return result;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (!result.contains(nums1[i])) {
                        result.add(nums1[i]);
                    }
                }
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;*/

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            int[] result = new int[0];
            return result;
        }
        HashSet<Integer> nums1Hash = new HashSet<Integer>();
        HashSet<Integer> resultHash = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
//            nums1Hash.add(i);
            nums1Hash.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (nums1Hash.contains(nums2[j]) && !resultHash.contains(nums2[j])) {
                resultHash.add(nums2[j]);
            }
        }

        int[] result = new int[resultHash.size()];
        int index = 0;
        for (Integer num : resultHash) {
            result[index++] = num;
        }
        return result;
    }
}
