package Ningbo.DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhang on 7/14/16.
 * 思路1: 暴力算法 k趟冒泡排序 O(nk)
 *
 * 参考答案: MaxHeap,即最大值优先的priorityQueue,构造时间O(n),
 * poll出来O(logn),所以最终是O(n + klogn)
 */
public class TopKLargestNumbers {
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return new int[0];
        }

        //comparator默认顺序排序,即如果o1 < o2,返回负数,即return o1 - o2
        //此处实现Max heap,即最大值优先的优先队列,返回o2 - o1
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(nums.length, comparator);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
