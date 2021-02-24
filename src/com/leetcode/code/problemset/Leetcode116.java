package com.leetcode.code.problemset;

import com.leetcode.code.pojo.Node;
import com.leetcode.code.pojo.Node1;

public class Leetcode116 {
    /**
     *
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * 进阶：
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *
     * 示例：
     * 输入：root = [1,2,3,4,5,6,7]
     * 输出：[1,#,2,3,#,4,5,6,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
     *
     * 提示：
     * 树中节点的数量少于 4096
     * -1000 <= node.val <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/113760407
     *
     */

    public static Node1 connect(Node1 root) {
        if(root != null) {
            connectTwoNode(root.left, root.right);
        }
        return root;
    }

    public static void connectTwoNode(Node1 left, Node1 right) {
        if(left == null || right == null) {
            return;
        }

        left.next = right;
        //连接相同父节点的左右节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        //连接跨父节点的两个节点
        connectTwoNode(left.right, right.left);
    }

    public static void main(String[] args) {
        Node1 n = new Node1(1,
                new Node1(2, new Node1(4), new Node1(5), null),
                new Node1(3, new Node1(6), new Node1(7), null), null);
        connect(n);
        
    }
}
