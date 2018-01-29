package Ningbo.ArrayAndNumbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhang on 7/10/16.
 * Version 1:自己方法
 * nlogn , n * logn , logn 用binary search来解决
 * 循环, 每到一个数,通过binary search去找最接近target - nums[i]的数,
 * 构造ArrayList需要去掉当前数, 耗费O(n),导致 LTE,同时错误点会误删多个nums[i],导致错误
 *
 * Version 2: two pointers
 *  两根指针从头尾不断向中间逼近
 */
public class TwoSumClosest {
    /**
     *
     * Version 1
     *
     *

    public int twoSumCloset(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> numList = new ArrayList<Integer>();
            //漏下
            boolean isRemovedOnce = false;
            for (int num : nums) {
                if (num == nums[i] && !isRemovedOnce) {
                    isRemovedOnce = true;
                    continue;
                }
                else {
                    numList.add(num);
                }
//                if (num != nums[i]) {
//                    numList.add(num);
//                }
            }
            int closestNum = closestNum(numList, target - nums[i]);
            result = Math.min(result, Math.abs(target - closestNum - nums[i]));
        }
        return result;
    }

    private int closestNum(ArrayList<Integer> nums, int target) {
        int start = 0;
//        int end = nums.size();
        int end = nums.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums.get(start) == target || nums.get(end) == target) {
            return target;
        }
        if (nums.get(start) < target && nums.get(end) > target) {
            return (nums.get(end) - target > target - nums.get(start)) ? nums.get(start) : nums.get(end);
        }
        if (nums.get(start) > target) {
            return nums.get(start);
        }
        if (nums.get(end) < target) {
            return nums.get(end);
        }
        return -1;
    }*/

    //Version 2
    public int twoSumCloset(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return 0;
            }
            if (nums[i] + nums[j] < target) {
                result = Math.min(result, target - nums[i] - nums[j]);
                i++;
            }
            else {
                result = Math.min(result, nums[i] + nums[j] - target);
                j--;
            }
        }
        return result;
    }
}
