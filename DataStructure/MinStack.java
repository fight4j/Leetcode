package Ningbo.DataStructure;

import java.util.Stack;

/**
 * Created by zhang on 7/17/16.
 *
 * 思路 :  正常往stack里面压入时,需判断当前值是否小于minStack的peek()值,如果小于等于 则压入minStack
 *        同理,如果pop()时, 如果pop()值== minStack() 的top值,则两边都移出
 *
 *        注意点: push时要对minStack判断,为空则直接压入
 *
 *        错误点: pop()时不是判断== 而是判断equals
 *
 *
 *        或者使用简单粗暴每次push时都push,但minStack.push(Math.Min(element, minStack.peek()))
 *        pop时两边一起pop, 即保持两个stack永远保持一致的大小,
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        }
        else {
            if (number <= minStack.peek()) {
                minStack.push(number);
            }
        }
    }

    public int pop() {
//        if (stack.peek() == minStack.peek()) {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
