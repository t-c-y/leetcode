package com.leetcode.code.problemset;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 */
public class Leetcode295 {
    /**
     *
     * 295. 数据流的中位数
     *
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     * 例如，
     * [2,3,4] 的中位数是 3
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     *
     * 示例：
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class MedianFinder {

        private PriorityQueue<Integer> large;
        private PriorityQueue<Integer> small;

        /** initialize your data structure here. */
        public MedianFinder() {
            // 小顶堆
            large = new PriorityQueue<>();
            // 大顶堆
            small = new PriorityQueue<>((a, b)->{
                return b-a;
            });
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            } else if (small.size() < large.size()) {
                return large.peek();
            } else {
                return (small.peek() + large.peek()) / 2.0;
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double param_2 = obj.findMedian();
        System.out.println("param_2 = " + param_2);
        obj.addNum(3);
        param_2 = obj.findMedian();
        System.out.println("param_2 = " + param_2);
    }

}
