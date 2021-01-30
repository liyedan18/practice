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
 */
public class NestedIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        //保存遍历的结果
        List<Integer> res = new LinkedList<>();

        for (NestedInteger nest : nestedList) {
            traverse(nest, res);
        }

        this.iterator = res.iterator();
    }

    /**
     * N叉树遍历
     */
    private void traverse(NestedInteger nestedInteger, List<Integer> res) {
        //base case
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
            return;
        }
        for (NestedInteger nest : nestedInteger.getList()) {
            traverse(nest, res);
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
