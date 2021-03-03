package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

public class Leetcode222 {
    /**
     *
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     *
     * 示例 1：
     * 输入：root = [1,2,3,4,5,6]
     * 输出：6
     *
     * 示例 2：
     * 输入：root = []
     * 输出：0
     *
     * 示例 3：
     * 输入：root = [1]
     * 输出：1
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/114291685
     *
     */


    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        //计算左子树深度
        while(l != null) {
            l = l.left;
            hl++;
        }
        //计算右子树深度
        while(r != null) {
            r = r.right;
            hr++;
        }
        //如果左右深度一致，代表是完全二叉树
        if(hl == hr) {
            return (int)Math.pow(2, hl)-1;
        }
        //普通二叉树节点计算方式
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));

        System.out.println(countNodes(t));

    }
}
