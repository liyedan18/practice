package com.leetcode.backtrack.p000.p078;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * 思路：
 *      同全排列问题类似
 *      用回溯算法,(属于DFS，深度优先遍历)
 *      需要一个start参数来控制选择，防止重复
 */
public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        if (nums == null) {
            return res;
        }

        LinkedList<Integer> track = new LinkedList<>();
        backTrack(track, nums, 0);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param track 路径（单次结果）
     * @param nums  所有选择
     */
    private void backTrack(LinkedList<Integer> track, int[] nums, int start) {
        //符合条件，加入结果
        res.add(new LinkedList<>(track));
        // res.add(track);  //这样会有问题，track会为空

        //遍历选择
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);

            backTrack(track, nums, i + 1);
            // backTrack(track, nums, start + 1);   //不是start+1

            //撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }

}
