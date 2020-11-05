package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode144 {
    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * 示例 1：
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     *
     *
     * 输入：root = [1,2]
     * 输出：[1,2]
     * 示例 5：
     *
     *
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private static List<Integer> res = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        res.clear();
        preorder(root);
        return res;
    }

    public static void preorder(TreeNode root) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(preorderTraversal(t));

        System.out.println(preorderTraversal(null));
        TreeNode t2 = new TreeNode(1);
        System.out.println(preorderTraversal(t2));
        TreeNode t3 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(preorderTraversal(t3));
        TreeNode t4 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(preorderTraversal(t4));
    }
}
