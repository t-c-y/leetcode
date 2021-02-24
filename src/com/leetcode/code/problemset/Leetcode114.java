package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode114 {
    /**
     *
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *  
     * 示例 1：
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     *
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [0]
     * 输出：[0]
     *  
     * 提示：
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/113760294
     *
     */

    public static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        //左右子树拉成平链
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        //把右子树挂在调整的链后边
        TreeNode p = root;
        while(p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5,
                        null,
                        new TreeNode(6)));
        flatten(t);
        System.out.println(t);

    }
}
