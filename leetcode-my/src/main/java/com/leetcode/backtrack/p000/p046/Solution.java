package com.leetcode.backtrack.p000.p046;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 46. 全排列

 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations

 同手写结果一样，单纯的穷举法：
    属于回溯问题，利用回溯框架（N叉树的遍历）
    1.路径
    2.选择
    3.(单次循环)结束条件
        遍历完成就结束，也就是路径满了，选择为空了。
 */
public class Solution {

    List<List<Integer>> res;
    //保存已经做过的选择，用Set<Integer>更好
    Map<Integer, Integer> map;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        LinkedList<Integer> singleResult = new LinkedList<>();
        map = new HashMap<>(nums.length);
        backtrack(nums, singleResult);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[]{1,2,3}));
    }

    /**
     * 回溯算法框架——N叉树遍历
     *
     * @param nums         选择
     * @param singleResult 路径
     */
    private void backtrack(int[] nums, LinkedList<Integer> singleResult) {
        //结束条件
        if (singleResult.size() == nums.length) {
            res.add(new LinkedList<>(singleResult));
            return;
        }

        //循环遍历选择
        for (int numRemain : nums) {
            //去除已经做过的选择
            if (map.containsKey(numRemain)) {
                continue;
            }

            //做选择(添加到路径中),同时将已做的选择移除
            singleResult.addLast(numRemain);
            map.put(numRemain, 0);

            backtrack(nums, singleResult);

            //撤销选择(从路径中删除),同时恢复已做的选择
            singleResult.removeLast();
            map.remove(numRemain);
        }
    }
}
