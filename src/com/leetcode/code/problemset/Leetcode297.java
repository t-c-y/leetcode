package com.leetcode.code.problemset;

import com.leetcode.code.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode297 {
    /**
     *
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     * 示例 1：
     * 输入：root = [1,2,3,null,null,4,5]
     * 输出：[1,2,3,null,null,4,5]
     *
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     *
     * 示例 4：
     * 输入：root = [1,2]
     * 输出：[1,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：https://blog.csdn.net/tcy1429920627/article/details/114140255
     *
     */

    public final static String SEP = ",";
    public final static String NULL = "#";

    /**===========前序遍历-开始===================================================================*/

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for(String s : data.split(SEP)) {
            list.addLast(s);
        }
        return deserialize(list);
    }

    private static TreeNode deserialize(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String first = list.removeFirst();
        if(first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    /**===========前序遍历-结束===================================================================*/
    /**===========后序遍历-开始===================================================================*/

    // Encodes a tree to a single string.
    public static String serializeLast(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeLast(root, sb);
        return sb.toString();
    }

    private static void serializeLast(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        serializeLast(root.left, sb);
        serializeLast(root.right, sb);
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserializeLast(String data) {
        LinkedList<String> list = new LinkedList<>();
        for(String s : data.split(SEP)) {
            list.addLast(s);
        }
        return deserializeLast(list);
    }

    private static TreeNode deserializeLast(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String first = list.removeLast();
        if(first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.right = deserializeLast(list);
        root.left = deserializeLast(list);
        return root;
    }

    /**===========后序遍历-结束===================================================================*/
    /**===========层次遍历-开始===================================================================*/

    // Encodes a tree to a single string.
    public static String serializeLayer(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode t = q.poll();

            if(t == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(t.val).append(SEP);
            q.offer(t.left);
            q.offer(t.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserializeLayer(String data) {
        if(data==null || data.isEmpty()) return null;
        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i=1; i<nodes.length; ) {
            TreeNode parent = q.poll();
            String left = nodes[i++];
            if(left.equals(NULL)) {
                parent.left = null;
            } else {
                TreeNode l = new TreeNode(Integer.parseInt(left));
                parent.left = l;
                q.offer(l);
            }

            String right = nodes[i++];
            if(right.equals(NULL)) {
                parent.right = null;
            } else {
                TreeNode r = new TreeNode(Integer.parseInt(right));
                q.offer(r);
                parent.right = r;
            }
        }
        return root;
    }

    /**===========层次遍历-结束===================================================================*/


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3, new TreeNode(4), new TreeNode(5)));

        System.out.println(deserialize(serialize(t)));
        System.out.println(deserializeLast(serializeLast(t)));
        System.out.println(deserializeLayer(serializeLayer(t)));

    }
}
