package Ningbo.ArrayAndNumbers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 7/11/16.
 * 求子数组之和最接近0, 先遍历一遍求出nums[0] ~ nums[i]的和,对该数组排序后
 * 再对该数组遍历,答案必然在前后两个数之间,遍历求出最小者,但因答案要求index,该数组需同时保留index
 * 需用复合数据结构保留index信息
 *
 * 此解法可以看作 Subarray Sum 的普通解法
 *
 * 例: [-3, 1, 1, -3, 5]
 * Pair数组为 {-3, 0} {-2, 1} {-1, 2} {-4, 3} {1, 4}
 * Pair排序后 {-4, 3} {-3, 0} {-2, 1} {-1, 2} {0, -1}(dummy)  {1, 4}
 * 答案为     [1, 3] [1, 1] [2, 2] [0, 4] [0, 2]
 * 但Pair数组需要加一个 dummy 即{0, -1}, dummy与周围两个比即不遗漏单个节点的情况,比较巧妙
 *
 * 求index时可能会出现index倒序, startIndex = Math.min(pairs[i - 1].index, pairs[i].index) + 1
 *
 * O(n) 为两趟O(n)的遍历和排序的O(nlogn), 即结果为O(nlogn)
 * 空间为O(n)
 */

class Pair {
    int sum;
    int index;
    Pair(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}

public class SubarraySumClosest {
    public int[] subarraySumClosest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Pair[] pairs = new Pair[nums.length + 1];
        pairs[0] = new Pair(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            pairs[i + 1] = new Pair(sum, i);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });

        int minDiff = Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 1; i < pairs.length; i++) {
            if (Math.abs(pairs[i].sum - pairs[i - 1].sum) < minDiff) {
                minDiff = Math.abs(pairs[i].sum - pairs[i - 1].sum);
                startIndex = Math.min(pairs[i - 1].index, pairs[i].index) + 1;
                endIndex = Math.max(pairs[i - 1].index, pairs[i].index);
            }
        }

        int[] result = new int[2];
        result[0] = startIndex;
        result[1] = endIndex;
        return result;
    }
}
