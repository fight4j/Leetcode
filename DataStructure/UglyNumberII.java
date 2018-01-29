package Ningbo.DataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhang on 7/19/16.
 *
 * 1 * 2, uglys[1] * 2, uglys[2] * 2 ..
 * 1 * 3, uglys[1] * 3, uglys[2] * 3 ..
 * 1 * 5, uglys[1] * 5, uglys[2] * 5 ..
 *
 * 思路: ugly数都由前一个数* 2 * 3 * 5而来, 类似merge listed Arrays, 每次取以上三个数组小者出列
 *
 * 注意点: 小者出来后即成为数组的下一个值, 需3个index记录三个数组的index值, 一旦ugly为其中某个或某几个值,
 *          当前数组index前移(都要前移, 排除重复数情况)
 *
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] uglys = new int[n];
        int indexOf2 = 0, indexOf3 = 0, indexOf5 = 0;
        uglys[0] = 1;
        int i = 1;
        while (i < n) {
            int ugly = Math.min(Math.min(uglys[indexOf2] * 2, uglys[indexOf3] * 3), uglys[indexOf5] * 5);
            if (ugly == uglys[indexOf2] * 2) {
                indexOf2++;
            }
            if (ugly == uglys[indexOf3] * 3) {
                indexOf3++;
            }
            if (ugly == uglys[indexOf5] * 5) {
                indexOf5++;
            }

            //遗漏
            uglys[i] = ugly;
            i++;
        }
        return uglys[n - 1];
    }
    /*
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n <= 6) {
            return 6;
        }

        PriorityQueue<Integer> factors = new PriorityQueue<Integer>(4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        factors.add(1);
        factors.add(2);
        factors.add(3);
        factors.add(5);

        for (int i = n; i >= 2; i--) {
            if (n % i == 0 && !factors.contains(n / i)) {

            }
        }
    }

    private boolean isUglyNumber(int m) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int[] factors = {2, 3, 5};
        for (int i = 2; i <= m; i++) {
           if (m % i == 0 && )
        }
    }*/
}
