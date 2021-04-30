package com.leetcode.code.problemset;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 */
public class Leetcode225 {

    /**
     * 225. 用队列实现栈
     *
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，
     * 并支持普通队列的全部四种操作（push、top、pop 和 empty）。
     *
     * 实现 MyStack 类：
     *
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     *  
     *
     * 注意：
     *
     * 你只能使用队列的基本操作 —— 也就是 
     * push to back、peek/pop from front、size 和 is empty 这些操作。
     *
     * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）
     * 来模拟一个队列 , 只要是标准的队列操作即可。
     *  
     *
     * 示例：
     *
     * 输入：
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 2, 2, false]
     *
     * 解释：
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // 返回 2
     * myStack.pop(); // 返回 2
     * myStack.empty(); // 返回 False
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class MyStack {

        Queue<Integer> q;
        int topElem = 0;

        /** Initialize your data structure here. */
        public MyStack() {
            q = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.offer(x);
            topElem = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int size = q.size();
            while(size > 2) {
                q.offer(q.poll());
                size--;
            }
            topElem = q.peek();
            q.offer(q.poll());
            return q.poll();
        }

        /** Get the top element. */
        public int top() {
            return topElem;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        // 返回 2
        System.out.println("myStack.top() = " + myStack.top());
        // 返回 2
        System.out.println("myStack.pop() = " + myStack.pop());
        // 返回 False
        System.out.println("myStack.empty() = " + myStack.empty());
    }

}
