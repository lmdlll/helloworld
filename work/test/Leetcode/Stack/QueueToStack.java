package Leetcode.Stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/** 用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 */

//87ms 用一个队列实现栈
class MyStack {
    //输入队列
    private Queue<Integer> queuepush;

    /** Initialize your data structure here. */
    public MyStack() {
        queuepush = new LinkedList<>();
    }

    /** Push element x onto stack. */
    //入栈这里，每加入一个变量，队列这里的内容循环一次
    public void push(int x) {
        queuepush.add(x);
        for (int i=0; i<queuepush.size()-1; i++){
            queuepush.add(queuepush.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queuepush.poll();
    }

    /** Get the top element. */
    public int top() {
        return queuepush.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queuepush.isEmpty();
    }
}

//用两个队列实现栈
class MyStack2 {

    private Queue<Integer> queueA;
    private Queue<Integer> queueB;

    public MyStack2() {
        queueA = new ArrayDeque<>();
        queueB = new ArrayDeque<>();
    }

    public void push(int x) {
        queueA.add(x);
    }

    //弹出这里，两个队列循环变换一个队列变空，另一个再赋值
    public int pop() {
        if(!queueA.isEmpty()){
            while(queueA.size() > 1){
                queueB.add(queueA.poll());
            }
            return queueA.poll();
        }else if(!queueB.isEmpty()){
            while(queueB.size() > 1){
                queueA.add(queueB.poll());
            }
            return queueB.poll();
        }else{
            return -1;
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if(!queueA.isEmpty()){
            while(queueA.size() > 1){
                queueB.add(queueA.poll());
            }
            int top = queueA.peek();
            queueB.add(queueA.poll());
            return top;
        }else if(!queueB.isEmpty()){
            while(queueB.size() > 1){
                queueA.add(queueB.poll());
            }
            int top = queueB.peek();
            queueA.add(queueB.poll());
            return top;
        }else{
            return -1;
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
    }
}
public class QueueToStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());


    }
}
