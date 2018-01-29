package Ningbo.DataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhang on 7/16/16.
 *
 * Solution: PriorityQueue保存每一列的值,取小者出列
 *
 * 错误点: 1. Typo: heap add element而不是值
 *        2. 增加每行元素第一个元素时需要增加非空判断
 */

class Element {
    public int row;
    public int col;
    public int val;
    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class MergeKSortedArrays {
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new ArrayList<Integer>();
        }

        Comparator<Element> elementComparator = new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        };

        int resultSize = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

        PriorityQueue heap = new PriorityQueue(arrays.length, elementComparator);
        for (int i = 0; i < arrays.length; i++) {
//            heap.add(arrays[i][0]);
            //漏下判断
            if (arrays[i].length > 0) {
                Element element = new Element(i, 0, arrays[i][0]);
                heap.add(element);
                resultSize += arrays[i].length;
            }
        }

        while (!heap.isEmpty()) {
            Element minElement = (Element)heap.poll();
            result.add(minElement.val);
            if (minElement.col < arrays[minElement.row].length - 1) {
                Element next = new Element(minElement.row, minElement.col + 1, arrays[minElement.row][minElement.col + 1]);
                heap.add(next);
            }
        }
        return result;
    }
}
