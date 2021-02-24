package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

public class Leetcode230 {
    /**
     *
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *
     * 示例 1：
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     *
     * 示例 2：
     * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     * 输出：3
     *
     * 提示：
     *
     * 树中的节点数为 n 。
     * 1 <= k <= n <= 104
     * 0 <= Node.val <= 104
     *
     * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/114042181
     *
     */

    public static int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public static int res = 0;
    public static int i = 0;

    public static void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        traverse(root.left, k);
        i++;
        if(i == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5,
                new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
                new TreeNode(6, null, null));

        System.out.println(kthSmallest(t, 3));

    }
}
