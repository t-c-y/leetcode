package com.leetcode.code.problemset;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 */
public class Leetcode739 {
    /**
     * 739. 每日温度
     *
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，
     * 至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
     * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            // 数组长度
            int n = T.length;
            // 返回结果的数组
            int[] res = new int[n];
            if (n == 0) {
                return res;
            }
            // 记录下一个比自己大的数组的下标
            Stack<Integer> s = new Stack<Integer>();
            // 倒叙判断
            for (int i = n - 1; i >= 0; i--) {
                // 循环判断，不比自己大的弹出栈
                while (!s.isEmpty() && T[s.peek()] <= T[i]) {
                    s.pop();
                }
                // 保存下一个比自己大的数组的距离
                res[i] = s.isEmpty() ? 0 : (s.peek() - i);
                // 将下标押入栈
                s.push(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("nums1 = " + Arrays.toString(T));
        System.out.println("nums = " + Arrays.toString(
                solution.dailyTemperatures(T)));

    }


}
