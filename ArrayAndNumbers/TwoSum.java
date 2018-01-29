package Ningbo.ArrayAndNumbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhang on 7/12/16.
 *
 * 错误点: indexOf对于数据重复的情况会返回相同的值,如 {0, 1, 2, 0} ,target=0, 答案会错误为[1,1]
 *        所以还是再次应用左右指针的技巧,从两边往中间走,找index,目标数重复的情况下保证index不会重复
 *        但还是会出现错位的问题,不符合答案,还是要用min, max保证
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        //补充,需要用数组记录原数组index和值
//        ArrayList<Integer> copyNumbers = new ArrayList<Integer>();
//        for (int i = 0; i < numbers.length; i++) {
//            copyNumbers.add(numbers[i]);
//        }
        int[] copyNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copyNumbers[i] = numbers[i];
        }

        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            }
            else if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        int[] result = new int[2];
//        result[0] = left + 1;
//        result[1] = right + 1;

//        result[0] = copyNumbers.indexOf(numbers[left]) + 1;
//        result[1] = copyNumbers.indexOf(numbers[right]) + 1;

//        result[0] = Math.min(copyNumbers.indexOf(numbers[left]), copyNumbers.indexOf(numbers[right])) + 1;
//        result[1] = Math.max(copyNumbers.indexOf(numbers[left]), copyNumbers.indexOf(numbers[right])) + 1;
        int targetLeft = 0;
        int targetRight = copyNumbers.length - 1;
        while (copyNumbers[targetLeft] != numbers[left]) {
            targetLeft++;
        }
        while (copyNumbers[targetRight] != numbers[right]) {
            targetRight--;
        }
//        result[0] = targetLeft + 1;
//        result[1] = targetRight + 1;
        result[0] = Math.min(targetLeft, targetRight) + 1;
        result[1] = Math.max(targetLeft, targetRight) + 1;
        return result;
    }
}
