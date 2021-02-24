package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode652 {
    /**
     *
     * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     * 两棵树重复是指它们具有相同的结构以及相同的结点值。
     *
     * 示例 1：
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   2   4
     *        /
     *       4
     * 下面是两个重复的子树：
     *
     *       2
     *      /
     *     4
     * 和
     *
     *     4
     * 因此，你需要以列表的形式返回上述重复子树的根结点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/114004088
     *
     */

    private static HashMap<String, Integer> treeMap = new HashMap<>();
    private static List<TreeNode> nodes = new ArrayList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //初始化清空数组和map
        nodes.clear();
        treeMap.clear();
        //判断重复的子树
        judgeTree(root);
        return nodes;
    }

    private static String judgeTree(TreeNode root) {
        //如果为空，设置#标识
        if(root == null) {
            return "#";
        }

        //递归左子树
        String left = judgeTree(root.left);
        //递归右子树
        String right = judgeTree(root.right);
        //序列化树：方便判断是否有相同的子树
        String tree = left + "," + right + "," + root.val;
        //使用map存储，判断是否重复
        int num = treeMap.getOrDefault(tree, 0);
        //如果为1代表第一次重复，放到数组中返回，起到去重作用
        if(num == 1) {
            nodes.add(root);
        }
        treeMap.put(tree, num+1);
        return tree;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));

        System.out.println(findDuplicateSubtrees(t));

    }
}
