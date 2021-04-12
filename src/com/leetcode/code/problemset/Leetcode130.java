package com.leetcode.code.problemset;


import com.leetcode.code.pojo.UnionFind;

import java.util.Arrays;

public class Leetcode130 {

    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * 示例 1：
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     *
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     *
     * 示例 2：
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surrounded-regions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    private static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 给dummy留一个额外的位置
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;
        // 将首列和末列的O与dummy连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n -1, dummy);
            }
        }
        // 将首行和末行的O与dummy连通
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(i, dummy);
            }
            if (board[m - 1][i] == 'O') {
                uf.union(n * (m - 1) + i, dummy);
            }
        }
        // 建立方向数组，上下左右搜索常用方法
        int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    // 将当前位置的O与上下左右的O连通
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        // 将不和dummy连通的O都替换为X
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(i * n + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                {
                    {'X','X','X','X','O'},
                    {'X','X','X','O','X'},
                    {'O','O','X','O','X'},
                    {'X','O','X','X','X'}
                };
        System.out.println("board1 -> " + Arrays.deepToString(board));
        solve(board);
        System.out.println("board2 -> " + Arrays.deepToString(board));
    }
}
