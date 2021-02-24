package com.leetcode.code.problemset;

import com.leetcode.code.pojo.Node;
import com.leetcode.code.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode589 {
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     *
     * 例如，给定一个 3叉树 :
     *      1
     *    / | \
     *   3  2  4
     *  /\
     * 5 6
     * 返回其前序遍历: [1,3,5,6,2,4]。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/109510462
     *
     */

    private static List<Integer> res = new ArrayList<>();

    public static List<Integer> preorder(Node root) {
        res.clear();
        helper(root);
        return res;
    }

    public static void helper(Node root){
        if(root == null)
            return ;
        res.add(root.val);
        if(root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                helper(root.children.get(i));
            }
        }
    }

    public static void main(String[] args) {
        List<Node> c = new ArrayList<>();
        List<Node> cc = new ArrayList<>();
        cc.add(new Node(5, new ArrayList<>()));
        cc.add(new Node(6,new ArrayList<>()));
        c.add(new Node(3, cc));
        c.add(new Node(2, new ArrayList<>()));
        c.add(new Node(4, new ArrayList<>()));
        Node n = new Node(1, c);
        System.out.println(preorder(n));
    }
}
