package com.leetcode.code.problemset;

import com.leetcode.code.pojo.ListNode;

public class Leetcode92 {
    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/112396205
     *
     */

    /**
     * 反转从位置 m 到 n 的链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }

    public static ListNode node;

    public static ListNode reverseN(ListNode head, int n) {
        if(n == 1) {
            node = head.next;
            return head;
        }
        ListNode lastNode = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = node;
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))));
        System.out.println("m = 2, n = 4, [" + reverseBetween(l, 2, 4) + "]");
    }
}
