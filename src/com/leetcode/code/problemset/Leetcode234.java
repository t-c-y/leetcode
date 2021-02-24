package com.leetcode.code.problemset;


import com.leetcode.code.pojo.ListNode;

public class Leetcode234 {

    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/113754898
     *
     */

    public static boolean isPalindrome(ListNode head) {
        //快慢指针找到链表中点
        ListNode s = head, f = head;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        if(f != null) {
            s = s.next;
        }
        //反转后半段链表
        ListNode p=head, q=reverse(s);
        //比较两段链表
        while(q!=null) {
            if(p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode h) {
        ListNode p = null, c = h;
        while(c != null) {
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(2);
        l2.next.next.next = new ListNode(1);

        System.out.println("l1:"+l1);
        System.out.println("l1:"+isPalindrome(l1));

        System.out.println("l2:"+l2);
        System.out.println("l2:"+isPalindrome(l2));
    }
}
