package com.leetcode.code.problemset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 */
public class Leetcode496 {

    /**
     *
     * 496. 下一个更大元素 I
     *
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     *
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边
     * 的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     *
     *
     * 示例 1:
     *
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
     *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
     *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     *
     * 示例 2:
     *
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
     *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            Map<Integer, Integer> map = new HashMap<>();
            // 单调栈
            Stack<Integer> s = new Stack<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                // 不为空，并且后一个数字比当前数字小
                while (!s.isEmpty() && s.peek() <= nums2[i]) {
                    // 弹出栈；因为当前元素之后的所有元素都没有它大
                    s.pop();
                }
                // 如果栈不为空，栈顶的元素则为下一个最大值
                if (!s.isEmpty()) {
                    // 设置当前元素和下一个最大值的关系
                    map.put(nums2[i], s.peek());
                }
                // 当前元素入栈
                s.push(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                // 查询数组的最大元素，如果找不到设置默认值-1
                res[i] = map.getOrDefault(nums1[i], -1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("nums = " + Arrays.toString(
                solution.nextGreaterElement(nums1, nums2)));
        System.out.println("---------------------------------------");
        nums1 = new int[]{2,4};
        nums2 = new int[]{1,2,3,4};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("nums = " + Arrays.toString(
                solution.nextGreaterElement(nums1, nums2)));
        System.out.println("---------------------------------------");
        nums1 = new int[]{1,3,5,2,4};
        nums2 = new int[]{6,5,4,3,2,1,7};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("nums = " + Arrays.toString(
                solution.nextGreaterElement(nums1, nums2)));

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        System.out.println("s.peek() = " + s.peek());
        s.push(3);
        System.out.println("s.pop() = " + s.pop());

    }

}
