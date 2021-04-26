package com.leetcode.code.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 * @author tcy
 */
public class Leetcode239 {

    /**
     * 239. 滑动窗口最大值
     *
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     *
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     *
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     *
     * 示例 3：
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     *
     * 示例 4：
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     *
     * 示例 5：
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class Solution {

        class MonotonicQueue {
            LinkedList<Integer> q = new LinkedList<>();

            public void push(int n) {
                // 将比自己小的全部移除
                while (!q.isEmpty() && q.getLast() < n) {
                    q.pollLast();
                }
                // 将自己放入队列
                q.addLast(n);
            }

            // 队列中第一个元素就是最大值
            public int max() {
                return q.getFirst();
            }

            // 删除元素
            public void pop(int n) {
                if (n == max()) {
                    q.pollFirst();
                }
            }

        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> res = new ArrayList<>();
            MonotonicQueue win = new MonotonicQueue();
            for (int i = 0; i < nums.length; i++) {
                if (i < k-1) {
                    // 先填满窗口的前 k - 1
                    win.push(nums[i]);
                } else {
                    // 窗口向前滑动，加入新数字
                    win.push(nums[i]);
                    // 记录当前窗口的最大值
                    res.add(win.max());
                    // 移除最先进入窗口的元素
                    win.pop(nums[i-k+1]);
                }
            }
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("res = " +
                Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

}
