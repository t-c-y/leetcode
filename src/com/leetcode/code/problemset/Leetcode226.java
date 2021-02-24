package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

public class Leetcode226 {
    /**
     *
     * 翻转一棵二叉树。
     * 示例：
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 备注:
     * 这个问题是受到 Max Howell 的 原问题 启发的 ：
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/113760215
     *
     */

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println(invertTree(t));

    }
}
