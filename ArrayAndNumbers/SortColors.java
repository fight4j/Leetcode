package Ningbo.ArrayAndNumbers;

/**
 * Created by zhang on 7/11/16.
 *
 * 排序完成后一定是0...01...12....2，所以可以扫描数组，当遇到0时，交换到前部，当遇到2时，交换到后部。
 * 用双指针left, right来记录当前已经就位的0序列和2序列的边界位置
 * current遇到1 则继续前进
 * 0 ... 0 1 ...1 X1 X2 X3 ... XN 2 ... 2
 *         |      |             |
 *         |      |             |
 *         left   current      right
 * 退出条件为current > right
 *
 * 注意点: current从左向右排,遇到0交换后,current保证交换来的是0,current往前走
 *         但遇到2交换后,current不一定往前走,因为换来的数据不能保证,仅仅只让right往前走
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            }
            else if (nums[current] == 1) {
                current++;
            }
            else {
                swap(nums, right, current);
                right--;
            }
        }
    }

    private void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}
