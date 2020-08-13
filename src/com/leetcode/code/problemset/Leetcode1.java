package com.leetcode.code.problemset;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {

    /**
     * 29 / 29 个通过测试用例
     * 状态：通过
     * 执行用时：8 ms
     * 内存消耗：39 MB
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, String> numMap = new HashMap<Integer, String>();
        for(int i=0;i<nums.length;i++) {
            if(numMap.containsKey(nums[i])) {
                numMap.put(nums[i], numMap.get(nums[i])+"_"+i);
            } else {
                numMap.put(nums[i], i+"");
            }
        }
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(numMap.containsKey(target-nums[i])) {
                if((target-nums[i]) == nums[i] && !numMap.get(nums[i]).contains("_")) {
                    continue;
                } else if((target-nums[i]) == nums[i] && numMap.get(nums[i]).contains("_")) {
                    String[] is = numMap.get(target-nums[i]).split("_");
                    result[0] = Integer.parseInt(is[0]);
                    result[1] = Integer.parseInt(is[1]);
                    break;
                }
                result[0] = i;
                result[1] = Integer.parseInt(numMap.get(target-nums[i]));
                break;
            }
        }
        return result;
    }

    /**
     * 29 / 29 个通过测试用例
     * 状态：通过
     * 执行用时：3 ms
     * 内存消耗：37.8 MB
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumNew(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            if(numMap.containsKey(target-nums[i])) {
                result[1] = i;
                result[0] = numMap.get(target-nums[i]);
                break;
            } else {
                numMap.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] reult = twoSumNew(nums, target);
//        int[] reult = twoSum(nums, target);
        System.out.println("["+reult[0]+","+reult[1]+"]");
    }
}
