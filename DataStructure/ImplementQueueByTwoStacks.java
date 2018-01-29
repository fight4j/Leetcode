package Ningbo.DataStructure;

import java.util.Stack;

/**
 * Created by zhang on 7/17/16.
 *
 * 思路 : s1作为源stack, 负责吸收push()进来的元素
 *       s2作为出stack, pop() top()时取s2的元素
 *       s1中的元素倒到s2后,即两次FILO 实现了FIFO
 *
 *       注意点:  只有s2中的元素为空,才向s2中倒s1的元素
 */
public class ImplementQueueByTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByTwoStacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            stack1ToStack2(stack1, stack2);
        }
        return stack2.pop();
    }

    public int top() {
        if (stack2.isEmpty()) {
            stack1ToStack2(stack1, stack2);
        }
        return stack2.peek();
    }

    private void stack1ToStack2(Stack<Integer> s1, Stack<Integer> s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}
