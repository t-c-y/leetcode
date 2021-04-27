package com.leetcode.code.problemset;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 */
public class Leetcode232 {

    /**
     *
     *
     */

    static class MyQueue {

        private Stack<Integer> s1, s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            // 先调整栈中的数据
            peek();
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s2.isEmpty() && s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        // queue is: [1]
        myQueue.push(1);
        // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(2);
        // return 1
        System.out.println("myQueue.peek() = " + myQueue.peek());
        // return 1, queue is [2]
        System.out.println("myQueue.pop() = " + myQueue.pop());
        // return false
        System.out.println("myQueue.empty() = " + myQueue.empty());
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
