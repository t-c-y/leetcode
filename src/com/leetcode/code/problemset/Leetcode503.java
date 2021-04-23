package com.leetcode.code.problemset;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 */
public class Leetcode503 {
    /**
     * 503. 下一个更大元素 II
     *
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
     * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
     * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
     * 如果不存在，则输出 -1。
     *
     * 示例 1:
     *
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            // 创建栈
            Stack<Integer> s = new Stack<Integer>();
            // 创建返回结果集
            int n = nums.length;
            int[] res = new int[n];
            if (n == 0) {
                return res;
            }
            // 循环通过单调栈方式，获取下一个比自己大的数
            // 因为是循环数组，将循环的次数扩大2倍，对数组长度取余，达到循环数组的效果
            for (int i = (2 * n - 1); i >=0; i-- ) {
                while (!s.isEmpty() && s.peek() <= nums[i%n]) {
                    s.pop();
                }
                res[i%n] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i%n]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4,1,2};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums = " + Arrays.toString(
                solution.nextGreaterElements(nums1)));
        System.out.println("---------------------------------------");
        nums1 = new int[]{2,4};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums = " + Arrays.toString(
                solution.nextGreaterElements(nums1)));
        System.out.println("---------------------------------------");
        nums1 = new int[]{6,5,4,3,2,1,7};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums = " + Arrays.toString(
                solution.nextGreaterElements(nums1)));
        System.out.println("---------------------------------------");
        nums1 = new int[]{1,2,1};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums = " + Arrays.toString(
                solution.nextGreaterElements(nums1)));
    }

}
