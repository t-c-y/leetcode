package com.leetcode.code.problemset;


import com.leetcode.code.pojo.ListNode;

public class Leetcode2 {

    /**
     * public class ListNode {
     *      int val;
     *      ListNode next;
     *      ListNode(int x) { val = x; }
     *  }
     *
     * 1563 / 1563 个通过测试用例
     * 状态：通过
     * 执行用时：2 ms
     * 内存消耗：43.6 MB
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i1, i2, bi=0, sum=0;
        ListNode rl = new ListNode(0);
        ListNode rnow = rl;
        boolean sig = true;
        while(true) {
            if(l1 != null) {
                i1 = l1.val;
            } else {
                i1 = 0;
            }
            if(l2 != null) {
                i2 = l2.val;
            } else {
                i2 = 0;
            }
            sum = bi + i1 + i2;
            if(sig) {
                sig = false;
                rnow.val = sum % 10;
            } else {
                rnow.next = new ListNode(sum % 10);
                rnow = rnow.next;
            }
            bi = sum / 10;
            sum = 0;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            if(l1 == null && l2 == null) {
                if(bi != 0) {
                    rnow.next = new ListNode(bi);
                }
                break;
            }
        }
        return rl;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("l1:"+l1);
        System.out.println("l2:"+l2);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("result:"+result);
    }
}
