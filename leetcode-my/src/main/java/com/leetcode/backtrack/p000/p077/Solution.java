package com.leetcode.backtrack.p000.p077;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 *
 * 思路：
 *      画图，看出是N叉树的遍历
 *      属于回溯问题
 *      要避免重复，判断何时是叶子结点。也就是单次结果（路径）长度==2时
 */
public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }

        backTrack(n, k, new LinkedList<>(), 1);
        return res;
    }

    /**
     * 回溯算法框架
     * @param n n
     * @param k k
     * @param path 已经做得选择，即路径
     * @param start 选择的开始位置
     */
    private void backTrack(int n, int k, LinkedList<Integer> path, int start) {
        //符合条件，添加到结果
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        //遍历选择
        for (int i = start; i <= n; i++) {
            //做选择
            path.add(i);

            backTrack(n, k, path, i + 1);

            //撤销选择
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4,2));
    }
}
