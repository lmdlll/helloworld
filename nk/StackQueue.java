package Nvk;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 */

public class StackQueue {
    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //这是最开始写的，发现有问题，
    // 当在弹出时如果再次插入一个数，会出错
    public int pop2() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
