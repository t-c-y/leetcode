package com.leetcode.code.problemset;


import com.leetcode.code.pojo.UnionFind;

import java.util.Arrays;

public class Leetcode990 {

    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，
     * 每个字符串方程 equations[i] 的长度为 4，
     * 并采用两种不同的形式之一："a==b" 或 "a!=b"。
     * 在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     *
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
     *
     * 示例 1：
     * 输入：["a==b","b!=a"]
     * 输出：false
     * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，
     * 但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
     *
     * 示例 2：
     * 输入：["b==a","a==b"]
     * 输出：true
     * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     *
     * 示例 3：
     * 输入：["a==b","b==c","a==c"]
     * 输出：true
     *
     * 示例 4：
     * 输入：["a==b","b!=c","c==a"]
     * 输出：false
     *
     * 示例 5：
     * 输入：["c==c","b==d","x!=z"]
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    public static boolean equationsPossible(String[] equations) {
        if (equations.length > 0) {
            // 26 个英文字母
            UnionFind uf = new UnionFind(26);
            // 先让相等的字母形成连通分量
            for (String eq : equations) {
                if (eq.charAt(1) == '=') {
                    uf.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
                }
            }
            // 检查不等关系是否打破相等关系的连通性
            for (String eq : equations) {
                if (eq.charAt(1) == '!') {
                    boolean isConnected = uf.connected(
                            eq.charAt(0) - 'a', eq.charAt(3) - 'a');
                    // 如果相等关系成立，就是逻辑冲突
                    if (isConnected) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"a==b","b!=a"};
        System.out.println(Arrays.deepToString(equations)
                + ":" + equationsPossible(equations));
        equations = new String[]{"b==a","a==b"};
        System.out.println(Arrays.deepToString(equations)
                + ":" + equationsPossible(equations));
        equations = new String[]{"a==b","b==c","a==c"};
        System.out.println(Arrays.deepToString(equations)
                + ":" + equationsPossible(equations));
        equations = new String[]{"a==b","b!=c","c==a"};
        System.out.println(Arrays.deepToString(equations)
                + ":" + equationsPossible(equations));
        equations = new String[]{"c==c","b==d","x!=z"};
        System.out.println(Arrays.deepToString(equations)
                + ":" + equationsPossible(equations));
    }
}
