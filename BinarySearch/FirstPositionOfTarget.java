package Ningbo.BinarySearch;

/**
 * Created by zhang on 6/17/16.
 *
 * 找fisrt position,通过对比nums[mid] >= target尽量将end指针往前移
 */
public class FirstPositionOfTarget {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        else if (nums[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
}
