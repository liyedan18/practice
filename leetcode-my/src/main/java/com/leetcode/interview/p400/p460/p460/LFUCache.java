package com.leetcode.interview.p400.p460.p460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU 缓存
 *
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量capacity 初始化对象
 * int get(int key)- 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value)- 如果键已存在，则变更其值；如果键不存在，请插入键值对。
 * 当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，
 * 当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 *
 * 进阶：
 *
 * 你是否可以在O(1)时间复杂度内执行两项操作？
 *
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
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);
 * lFUCache.put(2, 2);
 * lFUCache.get(1);      // 返回 1
 * lFUCache.put(3, 3);   // 去除键 2
 * lFUCache.get(2);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 * lFUCache.put(4, 4);   // 去除键 1
 * lFUCache.get(1);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 * lFUCache.get(4);      // 返回 4
 *
 *
 * 提示：
 *
 * 0 <=capacity, key, value <= 104
 * 最多调用 105 次 get 和 put 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 *
 * 思路：
 *      先确定基本的数据结构，映射关系
 *      频率和key的映射关系，一对多，且key增删查都要O(1)，key还要有时间顺序 -> linkedList + HashSet -> LinkedHashSet
 *
 *      CRUD时各个结构都要同时进行CRUD，不要漏了
 *
 *      画图，一步一步来
 *
 */
public class LFUCache {

    private Map<Integer, Integer> keyToValMap;
    private Map<Integer, Integer> keyToFreqMap;
    //使用频率和key的对应关系，一对多
    private Map<Integer, LinkedHashSet<Integer>> freqToKeyMap;

    private int cap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        keyToValMap = new HashMap<>();
        keyToFreqMap = new HashMap<>();
        freqToKeyMap = new HashMap<>();
    }

    /**
     * 如果键存在于缓存中，则获取键的值，否则返回 -1。
     * 同时freq+1
     */
    public int get(int key) {
        if (!keyToValMap.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);

        return keyToValMap.get(key);
    }

    /**
     * 如果键已存在，则变更其值；如果键不存在，请插入键值对。
     * 当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，
     * 当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
     * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
     */
    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }

        //包括key，直接设置值（这时没有超过最大容量）
        if (keyToValMap.containsKey(key)) {
            increaseFreq(key);
            keyToValMap.put(key, value);
            return;
        }

        //下面是不包括key

        //如果达到或超出最大容量
        if (keyToValMap.size() >= cap) {
            //删除最不经常使用的
            removeMinFreqKey();
        }

        //频率设置为1
        keyToFreqMap.put(key, 1);
        //频率对应的key也放进去,频率为1
        freqToKeyMap.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeyMap.get(1).add(key);
        keyToValMap.put(key, value);

    }

    /**
     * 根据key增加频率
     */
    private void increaseFreq(int key) {
        int oldFreq = keyToFreqMap.get(key);
        //频率+1
        keyToFreqMap.put(key, oldFreq + 1);
        //freq和key的对应关系也修改
        //先删除原来的，再添加到freq+1对应的list
        freqToKeyMap.get(oldFreq).remove(key);
        //如果值空了，就从map中删除key，可以省略
        if (freqToKeyMap.get(oldFreq).isEmpty()) {
            freqToKeyMap.remove(oldFreq);
        }

        //在添加freqToKeyMap之前先初始化
        freqToKeyMap.putIfAbsent(oldFreq + 1, new LinkedHashSet<>());
        freqToKeyMap.get(oldFreq + 1).add(key);
    }

    /**
     * 删除最不经常使用的key
     */
    private void removeMinFreqKey() {
        //先遍历找到freq最小的值
        int minFreq = freqToKeyMap.keySet().stream().min(Integer::compareTo).get();
        //最小freq对应的key
        LinkedHashSet<Integer> minKeyList = freqToKeyMap.get(minFreq);
        //最先插入的就是最久远的
        int minKeyToDelete = minKeyList.iterator().next();
        minKeyList.remove(minKeyToDelete);
        //如果值空了，就从map中删除key，可以省略
        if (minKeyList.isEmpty()) {
            freqToKeyMap.remove(minFreq);
        }
        keyToFreqMap.remove(minKeyToDelete);
        keyToValMap.remove(minKeyToDelete);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */