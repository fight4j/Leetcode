package Ningbo.ArrayAndNumbers;

/**
 * Created by zhang on 7/12/16.
 * 思路与quick sort的 基于Pivot进行分区的部分一模一样,
 * 将小于k的数据swap到前面去,并用targetIndexForPivot标记第一个>=k的数据
 *
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
//            return -1;
            return 0;
        }

        int targetIndexForPivot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                swap(nums, i, targetIndexForPivot);
                targetIndexForPivot++;
            }
        }
        return targetIndexForPivot;
    }

    private void swap(int[] nums, int indexA, int indexB) {
        int tmp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = tmp;
    }
}
