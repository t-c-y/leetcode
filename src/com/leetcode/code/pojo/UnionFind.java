package com.leetcode.code.pojo;

/**
 * Union-Find 并查集算法
 * @author tongchengyu
 */
public class UnionFind {
    /**
     * 连通分量个数
     */
    private int count;
    /**
     * 存储一个棵树
     */
    private int[] parent;
    /**
     * 记录树的重量
     */
    private int[] size;

    /**
     * 构造函数
     * @param n
     */
    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 连通两个元素
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // 小树接到大树下，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 判断两个元素是否连通
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 查找元素的根结点
     * @param x
     * @return
     */
    public int find(int x) {
        while (parent[x] != x) {
            // 进行路经压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 连通分量个数
     * @return
     */
    public int count() {
        return count;
    }
    
}
