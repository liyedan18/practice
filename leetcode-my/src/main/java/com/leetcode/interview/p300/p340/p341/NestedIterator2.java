package com.leetcode.interview.p300.p340.p341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用next 直到hasNext 返回 false，next返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用next直到hasNext 返回 false，next返回的元素的顺序应该是: [1,4,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 *
 * 思路：
 *      题意就是遍历NestedInteger，并返回结果
 *      根据NestedInteger的结构，类似是一个N叉树，可以递归遍历
 *      用LinkedList保存遍历结果
 *
 *      前面的做法有个问题：
 *          把所有的数据都遍历出来保存在内存中，如果数据量很大，则会占用大量内存。
 *          并且，有可能只会调用next()方法一次，获取一个数就不用了，造成大量浪费。
 *          那有没有方法获取一个元素，只遍历一个元素呢？
 *
 *      懒加载方法：
 *          获取一个数据才会遍历一个数据，不会一次性把所有数据都遍历出来。
 *          那么就需要在hasNext()方法找到叶子节点即可。
 *          然后next()方法返回叶子节点的值
 *          用LinkedList保存遍历结果（便于增加和删除）
 */
public class NestedIterator2 implements Iterator<Integer> {

    LinkedList<NestedInteger> res;

    public NestedIterator2(List<NestedInteger> nestedList) {

        //因为要删除，所以不能用原来数据的引用
        res = new LinkedList<>(nestedList);
    }


    @Override
    public Integer next() {
        return res.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        //找到叶子节点
        while (!res.isEmpty() && !res.getFirst().isInteger()) {

            // 不能这样直接删除，res的结构类似hashMap，一个节点上有可能挂了个List链表
            // res.removeFirst();

            List<NestedInteger> first = res.removeFirst().getList();
            //保证原来的顺序，从后向前添加
            for (int i = first.size() - 1; i >= 0; i--) {
                res.addFirst(first.get(i));
            }
        }
        return !res.isEmpty();
    }
}
