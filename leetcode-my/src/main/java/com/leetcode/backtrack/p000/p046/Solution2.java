package com.leetcode.backtrack.p000.p046;

import java.util.LinkedList;
import java.util.List;

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
public class Solution2 {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        backTrack(nums, new LinkedList<>());
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums  选择
     * @param track 单次已经选择的路径
     */
    private void backTrack(int[] nums, LinkedList<Integer> track) {
        //结束条件，到达叶子结点
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }

        //遍历选择
        for (int i = 0; i < nums.length; i++) {
            //去除重复选择
            if (track.contains(nums[i])) {
                continue;
            }

            //做选择
            track.add(nums[i]);

            backTrack(nums, track);

            //撤销选择
            track.removeLast();
        }
    }
}
