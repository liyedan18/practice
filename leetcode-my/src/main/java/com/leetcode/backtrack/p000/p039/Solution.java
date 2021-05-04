package com.leetcode.backtrack.p000.p039;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 *
 * 思路：
 *      一开始没有形成任何思路
 *      随后看了题解，发现可以用回溯算法解决
 *      但是完成的题解在 剪枝和去重 这两方面做的不好
 */
public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //回溯算法
        res = new LinkedList<>();
        backTrack(new LinkedList<>(), 0, candidates, target);

        //去重并返回
        return res.stream().distinct().collect(Collectors.toList());
    }

    private void backTrack(List<Integer> singleRes, int curSum, int[] candidates, int target) {
        //结束条件
        if (curSum == target) {
            //排序，方便最后结果的去重
            res.add(singleRes.stream().sorted().collect(Collectors.toList()));
            return;
        }
        if (curSum > target) {
            return;
        }

        //遍历选择
        for (int i = 0; i < candidates.length; i++) {
            //做选择
            singleRes.add(candidates[i]);
            curSum += candidates[i];

            backTrack(singleRes, curSum, candidates, target);

            //撤销选择
            singleRes.remove(singleRes.size() - 1);
            curSum -= candidates[i];
        }
    }
}
