package com.leetcode.backtrack.p000.p047;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 47. 全排列 II

 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 示例 1：

 输入：nums = [1,1,2]
 输出：
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 示例 2：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  

 提示：

 1 <= nums.length <= 8
 -10 <= nums[i] <= 10

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations-ii

 思路：
        回溯算法+交换法
 */
public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }

        backTrack(0, nums);
        return res;
    }

    private void backTrack(int start, int[] nums) {
        //结束条件
        if (start == nums.length - 1) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        //start表示当前是第几层（第几个位置）
        //i表示当前层还有哪些选择
        //避免当前位置有重复元素
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            //做选择
            swap(nums, i, start);

            backTrack(start + 1, nums);

            //撤销选择
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permuteUnique(new int[]{1, 1, 2}));
    }
}
