package com.leetcode.backtrack.p000.p040;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 *
 * 思路：
 *      回溯算法
 *      剪枝+判断去重
 *      注意去重方法
 */
public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //回溯算法
        //每个数字只能用一次，则先排序
        res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new LinkedList<>(), 0);
        return res;
    }

    //回溯算法
    private void backTrack(int[] candidates, int target, int curSum, LinkedList<Integer> singleRes, int start) {
        //满足条件或退出条件
        if (target == curSum) {
            //在下面for循环中去重，效率更高。这里不能用containsAll。
            //contains完全相同时，也就是顺序也相同时，才能匹配
            // if (res.contains(singleRes)) {
            //     return;
            // }
            res.add(new LinkedList<>(singleRes));
            return;
        }

        //遍历选择
        for (int i = start; i < candidates.length && (candidates[i] + curSum <= target); i++) {
            //过滤掉重复的元素，注意这里不是i>1,i>1会将其本身也过滤掉
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //做选择
            singleRes.add(candidates[i]);

            backTrack(candidates, target, curSum + candidates[i], singleRes, i + 1);

            //撤销选择
            singleRes.removeLast();
        }
    }
}
