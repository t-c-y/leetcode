package com.leetcode.code.pojo;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String s = "("+val;
        ListNode sN = next;
        while(next != null) {
            s+=" -> ";
            s+=next.val;
            next = next.next;
        }
        s+=")";
        next = sN;
        return s;
    }
}
