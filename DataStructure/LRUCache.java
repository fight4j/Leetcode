package Ningbo.DataStructure;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by zhang on 7/20/16.
 *
 * 思路: 用stack来记录最近使用的key, 当hashMap满时,剔除栈底的元素
 *
 *      错误点: 刚开始get()没有更新key在stack中的位置, get()也算使用一次,也需要更新位置,
 *      即将key放在stack 顶部,而原来stack上面的元素相对位置不变
 *
 */
public class LRUCache {
    private HashMap<Integer, Integer> cacheMap;
    private Stack<Integer> cacheStack;
    private Stack<Integer> bacStack;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<Integer, Integer>(capacity);
        cacheStack = new Stack<Integer>();
        bacStack = new Stack<Integer>();
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            updateKeyPosition(key);
            return cacheMap.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            updateKeyPosition(key);
        } else {
            if (cacheMap.size() == capacity) {
//                cacheMap.remove(cacheStack.pop());
                while (!cacheStack.isEmpty()) {
                    bacStack.push(cacheStack.pop());
                }
                int removedKey = bacStack.pop();
                while (!bacStack.isEmpty()) {
                    cacheStack.push(bacStack.pop());
                }
                //遗漏
                cacheMap.remove(removedKey);
            }
            cacheMap.put(key, value);
            cacheStack.push(key);
        }
    }

    private void updateKeyPosition(int key) {
        //update position of key in cacheStack
        while (cacheStack.peek() != key) {
            bacStack.push(cacheStack.pop());
        }
        cacheStack.pop();
        while (!bacStack.isEmpty()) {
            cacheStack.push(bacStack.pop());
        }
        cacheStack.push(key);
    }
}
