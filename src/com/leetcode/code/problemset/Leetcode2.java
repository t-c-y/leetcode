package com.leetcode.code.problemset;


import com.leetcode.code.pojo.ListNode;

public class Leetcode2 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/107899008
     *
     */

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
