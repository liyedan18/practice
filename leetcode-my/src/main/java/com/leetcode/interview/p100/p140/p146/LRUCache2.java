package com.leetcode.interview.p100.p140.p146;

import java.util.HashMap;
import java.util.Map;

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
 *      查找和插入都是O(1)时间复杂度，哈希表+双链表
 *      自己实现一个linkedhashmap: 双链表+hashMap
 *          先设计双链表的Node -> 然后设计双链表的增删改查 DoubleLinkedList
 *          再结合Map存储key和Node
 *      这里以尾结点为最近使用，头结点是最久未使用。
 */
public class LRUCache2 {
    private int cap = 0;
    // key-int, val-(key,val)
    private Map<Integer, Node> map;
    private DoubleLinkedList linkedList;

    public LRUCache2(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        linkedList = new DoubleLinkedList();
    }

    /**
     * 存在时，还要把key提到结尾
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //变成最近使用的节点
        makeEnd(key);
        return map.get(key).val;
    }

    /**
     * 如果存在key，则替换value(先删除，再添加到结尾)，并把key提到结尾
     * 如果不存在，则直接添加到结尾
     * cap++;
     *      如果超过了cap，则需要删除最久未使用的
     */
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            linkedList.remove(oldNode);
        }
        map.put(key, newNode);
        linkedList.addLast(newNode);

        //变成最近使用的节点
        makeEnd(key);

        //超过容量
        if (linkedList.size() > cap) {
            //获取第一个节点
            Node firstNode = linkedList.removeFirst();
            map.remove(firstNode.key);
        }

    }

    /**
     * 把节点提到结尾，变为最近使用的节点
     *      ——先删除原节点，然后再重新添加到结尾
     */
    private void makeEnd(int key) {
        Node node = map.get(key);
        linkedList.remove(node);
        linkedList.addLast(node);
    }
}

/**
 * 双链表
 */
class DoubleLinkedList {

    //头尾节点
    private Node head, tail;
    private int size = 0;

    DoubleLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        size = 0;
    }

    public void addLast(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * 删除任意一个节点
     */
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeFirst() {
        //空链表
        if (head.next == tail) {
            return null;
        }
        Node firstNode = head.next;
        remove(head.next);
        return firstNode;
    }

    public int size() {
        return this.size;
    }
}

/**
 * 链表节点
 */
class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}