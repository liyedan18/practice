package com.leetcode.interview.p100.p140.p146;

import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 *
 * 示例：
 *
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
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 * 思路：
 *      查找和插入都是O(1)时间复杂度，哈希表+双链表：LinkedHashMap
 *      这里以尾结点为最近使用，头结点是最久未使用。
 */
public class LRUCache {
    private int cap = 0;
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    /**
     * 存在时，还要把key提到结尾
     */
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }

        makeEnd(key);
        return map.get(key);
    }

    /**
     * 如果存在key，则替换value，并把key提到结尾
     * 如果不存在，则直接添加到结尾
     * cap++;
     *      如果超过了cap，则需要删除最久未使用的
     */
    public void put(int key, int value) {
        if (map.containsKey(key)){
            int oldVal = map.get(key);
            map.remove(key);
            map.put(key, value);
        } else {
            map.put(key, value);
        }

        //删除头结点
        if (map.size()>cap){
            Integer firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }
    }

    /**
     * 把节点提到结尾，变为最近使用的节点
     *      ——先删除原节点，然后再重新添加到结尾
     */
    private void makeEnd(int key){
        int val = map.get(key);
        map.remove(key);
        //LinkedHashMap会直接添加到链表结尾
        map.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */