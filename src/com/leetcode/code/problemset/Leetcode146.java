package com.leetcode.code.problemset;

import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存机制
 */
public class Leetcode146 {

    /**
     * 146. LRU 缓存机制
     *
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     *
     * 实现 LRUCache 类：
     *
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；
     * 如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，
     * 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     * 示例：
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lru-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class LRUCache {

        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            // 如果找不到就返回-1
            if (!cache.containsKey(key)) {
                return -1;
            }
            int val = cache.get(key);
            // 把当前key设置到最后（代表最近访问）
            makeRecently(key);
            return val;
        }

        public void put(int key, int value) {
            // 如果原来有，修改数据，并放到最后，代表最近访问
            if (cache.containsKey(key)) {
                cache.put(key, value);
                makeRecently(key);
                return;
            }
            // 如果缓存存满了，删除头部元素（最长时间没访问的）
            if (cache.size() >= this.cap) {
                int oldKey = cache.keySet().iterator().next();
                cache.remove(oldKey);
            }
            // 保存数据
            cache.put(key, value);
        }

        private void makeRecently(int key) {
            // 删除原来的节点，再重新加入
            int val = cache.remove(key);
            cache.put(key, val);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        // 缓存是 {1=1}
        lRUCache.put(1, 1);
        // 缓存是 {1=1, 2=2}
        lRUCache.put(2, 2);
        // 返回 1
        System.out.println("arlRUCache.get(1) = " + lRUCache.get(1));
        // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(3, 3);
        // 返回 -1 (未找到)
        System.out.println("arlRUCache.get(2) = " + lRUCache.get(2));
        // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.put(4, 4);
        // 返回 -1 (未找到)
        System.out.println("arlRUCache.get(1) = " + lRUCache.get(1));
        // 返回 3
        System.out.println("arlRUCache.get(3) = " + lRUCache.get(3));
        // 返回 4
        System.out.println("arlRUCache.get(4) = " + lRUCache.get(4));
    }

}
