package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

public class Leetcode538 {
    /**
     *
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * 提醒一下，二叉搜索树满足下列约束条件：
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
     *
     * 示例 1：
     * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     *
     * 示例 2：
     * 输入：root = [0,null,1]
     * 输出：[1,null,1]
     *
     * 示例 3：
     * 输入：root = [1,0,2]
     * 输出：[3,3,2]
     *
     * 示例 4：
     * 输入：root = [3,2,4,1]
     * 输出：[7,9,4,10]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/114042443
     *
     */

    public static TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    static int sum = 0;

    public static void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(2));

        System.out.println(convertBST(t));

    }
}
