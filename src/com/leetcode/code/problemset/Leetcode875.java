package com.leetcode.code.problemset;

import java.util.Arrays;

/**
 * 875. 爱吃香蕉的珂珂
 * @author tongchengyu
 */
public class Leetcode875 {

    /**
     *
     * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
     * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
     * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     *
     * 示例1：
     * 输入: piles = [3,6,7,11], H = 8
     * 输出: 4
     *
     * 示例2：
     * 输入: piles = [30,11,23,4,20], H = 5
     * 输出: 30
     *
     * 示例3：
     * 输入: piles = [30,11,23,4,20], H = 6
     * 输出: 23
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class Solution {

        public int minEatingSpeed(int[] piles, int h) {
            // 对速度进行二分：最小速度为1，最大速度为堆中最多的香蕉数量
            int left = 1, right = maxSpeed(piles) + 1;
            int mid;
            while (left < right) {
                mid = left + (right - left)/2;
                if (canFinish(piles, mid, h)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canFinish(int[] piles, int speed, int h) {
            int timeAll = 0;
            for (int pile : piles) {
                timeAll += timeOne(pile, speed);
            }
            return timeAll <= h;
        }

        private int timeOne(int pilesNum, int speed) {
            return (pilesNum / speed) + (pilesNum % speed == 0 ? 0 : 1);
        }

        private int maxSpeed(int[] piles) {
            int maxSpeed = piles[0];
            for (int pile : piles) {
                if (pile > maxSpeed) {
                    maxSpeed = pile;
                }
            }
            return maxSpeed;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {3,6,7,11};
        int H = 8;
        System.out.println("piles = " + Arrays.toString(piles));
        System.out.println("H = " + H);
        System.out.println("result = " + solution.minEatingSpeed(piles, H));
        piles = new int[]{30,11,23,4,20};
        H = 5;
        System.out.println("piles = " + Arrays.toString(piles));
        System.out.println("H = " + H);
        System.out.println("result = " + solution.minEatingSpeed(piles, H));
        piles = new int[]{30,11,23,4,20};
        H = 6;
        System.out.println("piles = " + Arrays.toString(piles));
        System.out.println("H = " + H);
        System.out.println("result = " + solution.minEatingSpeed(piles, H));
    }

}
