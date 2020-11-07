package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

public class Leetcode98 {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例 2:
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static boolean isValidBST(TreeNode root) {
        return (
                (root == null || root.val == null) ||
                        ((root.left == null || root.left.val == null || root.val > root.left.val)
                                && (root.right == null || root.right.val == null || root.val < root.right.val))
        ) && isValidBST(root.left) && isValidBST(root.right);
//        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer l, Integer h) {
        if(root == null) {
            return true;
        }
        int val = root.val;
        if(l != null && val <= l) {
            return false;
        }
        if(h != null && val >= h) {
            return false;
        }
        if(!helper(root.left, l, val)) {
            return false;
        }
        if(!helper(root.right, val, h)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        System.out.println(isValidBST(t1));
        boolean b = 1==2 || new TreeNode().left.val == 1;
        System.out.println(b);
    }
}
