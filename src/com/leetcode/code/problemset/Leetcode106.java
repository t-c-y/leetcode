package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode106 {
    /**
     *
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/113889213
     *
     */

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return build(postorder,0, postorder.length,
                inorder,0, inorder.length, map);
    }

    public static TreeNode build(int[] postorder,
                                 int pl,
                                 int ph,
                                 int[] inorder,
                                 int il,
                                 int ih,
                                 Map<Integer, Integer> map) {
        if(pl >= ph) {
            return null;
        }
        int rootVal = postorder[ph-1];
        int rootIndex = map.get(rootVal);
        int rightLength = ih-rootIndex-1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(postorder, pl, ph-rightLength-1, inorder, il, rootIndex,map);
        root.right = build(postorder, ph-rightLength-1,ph-1,inorder,rootIndex+1,ih,map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));

    }
}
