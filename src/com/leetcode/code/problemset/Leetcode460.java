package com.leetcode.code.problemset;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU 缓存
 */
public class Leetcode460 {

    /**
     * 460. LFU 缓存
     *
     * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
     *
     * 实现 LFUCache 类：
     *
     * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
     * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
     * void put(int key, int value) - 如果键已存在，则变更其值；
     * 如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，
     * 使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，
     * 应该去除 最久未使用 的键。
     * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。
     * 使用次数会在对应项被移除后置为 0 。
     *
     * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。
     * 使用计数最小的键是最久未使用的键。
     *
     * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。
     * 对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
     *
     * 示例：
     *
     * 输入：
     * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
     * 输出：
     * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
     *
     * 解释：
     * // cnt(x) = 键 x 的使用计数
     * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
     * LFUCache lFUCache = new LFUCache(2);
     * lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
     * lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
     * lFUCache.get(1);      // 返回 1
     *                       // cache=[1,2], cnt(2)=1, cnt(1)=2
     * lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
     *                       // cache=[3,1], cnt(3)=1, cnt(1)=2
     * lFUCache.get(2);      // 返回 -1（未找到）
     * lFUCache.get(3);      // 返回 3
     *                       // cache=[3,1], cnt(3)=2, cnt(1)=2
     * lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
     *                       // cache=[4,3], cnt(4)=1, cnt(3)=2
     * lFUCache.get(1);      // 返回 -1（未找到）
     * lFUCache.get(3);      // 返回 3
     *                       // cache=[3,4], cnt(4)=1, cnt(3)=3
     * lFUCache.get(4);      // 返回 4
     *                       // cache=[3,4], cnt(4)=2, cnt(3)=3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lfu-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    static class LFUCache {
        // 容量大小
        int cap;
        // 最小的频次
        int minFreq;
        // key到val的映射
        HashMap<Integer, Integer> key2Val;
        // key到freq的映射
        HashMap<Integer, Integer> key2Freq;
        // freq到key列表的映射
        HashMap<Integer, LinkedHashSet<Integer>> freq2Keys;

        public LFUCache(int capacity) {
            this.cap = capacity;
            this.minFreq = 0;
            key2Val = new HashMap<>();
            key2Freq = new HashMap<>();
            freq2Keys = new HashMap<>();
        }

        public int get(int key) {
            if (!key2Val.containsKey(key)) {
                return -1;
            }
            // 增加访问频次
            increaseFreq(key);
            return key2Val.get(key);
        }

        public void put(int key, int value) {
            if (this.cap == 0) {
                return;
            }

            // 判断是否包含key，包含直接增加访问频次，更新值
            if (key2Val.containsKey(key)) {
                // 增加访问频次
                increaseFreq(key);
                key2Val.put(key, value);
                return;
            }
            // 不包含，判断是否达到容量，达到容量删除最少频次，最先访问的元素
            if (key2Val.size() >= this.cap) {
                removeMinFreqKey();
            }
            // 保存数据，更新频次
            key2Val.put(key, value);
            // 设置key热度
            key2Freq.put(key, 1);
            freq2Keys.putIfAbsent(1, new LinkedHashSet<>());
            // 热度与key关联
            freq2Keys.get(1).add(key);
            this.minFreq = 1;
        }

        private void increaseFreq(Integer key) {
            int freq =  key2Freq.get(key);
            // 增加热度
            key2Freq.put(key, freq + 1);
            freq2Keys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freq2Keys.get(freq + 1).add(key);
            // 调整热度与key关系的数据
            freq2Keys.get(freq).remove(key);
            if (freq2Keys.get(freq).size() == 0) {
                freq2Keys.remove(freq);
                if (freq == this.minFreq) {
                    this.minFreq++;
                }
            }
        }

        private void removeMinFreqKey() {
            // 查看最小的热度
            // 找到最先访问的key
            int oldKey = freq2Keys.get(this.minFreq).iterator().next();
            // 删除key及val
            key2Val.remove(oldKey);
            key2Freq.remove(oldKey);
            // 删除热度与key的关系
            freq2Keys.get(this.minFreq).remove(oldKey);
            if (freq2Keys.get(this.minFreq).size() == 0) {
                freq2Keys.remove(this.minFreq);
            }
        }
    }

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        // cache=[1,_], cnt(1)=1
        lFUCache.put(1, 1);
        // cache=[2,1], cnt(2)=1, cnt(1)=1
        lFUCache.put(2, 2);
        // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        System.out.println("lFUCache.get(1) = " + lFUCache.get(1));

        // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lFUCache.put(3, 3);
        // 返回 -1（未找到）
        System.out.println("lFUCache.get(2) = " + lFUCache.get(2));
        // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        System.out.println("lFUCache.get(3) = " + lFUCache.get(3));

        // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lFUCache.put(4, 4);
        // 返回 -1（未找到）
        System.out.println("lFUCache.get(1) = " + lFUCache.get(1));
        // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println("lFUCache.get(3) = " + lFUCache.get(3));
        // 返回 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
        System.out.println("lFUCache.get(4) = " + lFUCache.get(4));

    }

}
