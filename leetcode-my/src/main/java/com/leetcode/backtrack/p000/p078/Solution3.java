package com.leetcode.backtrack.p000.p078;

import java.util.ArrayList;
import java.util.Arrays;
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
 *      直接求解：
 *      nums=[],res =[]
 *      nums=[1], res = [],[1]
 *      nums=[1,2], res = [],[1],[2],[1,2]
 *      也就是结果每次都是在上一个结果值再增加一个最新的nums[last]
 *
 *      递归解法
 *
 *      sub(1,2,3) = sub(1,2) + sub(1,2)的每个结果.add(3)
 *
 *      暂时有问题
 */
public class Solution3 {

    private int index = 0;

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        //先添加空集合
        if (nums == null || nums.length == 0 || index >= nums.length) {
            return res;
        }
        index++;

        List<List<Integer>> resLast = subsets(nums);

        int i = resLast.size();
        for (int j = 0; j < i; j++) {
            List<Integer> list = new ArrayList<>(resLast.get(j));
            list.add(nums[nums.length - 1 - index]);
            res.add(list);
        }

        return res;
    }

    private List<List<Integer>> subsetsHelper(int[] nums, int endIndex) {
        List<List<Integer>> res = new LinkedList<>();
        //先添加空集合
        if (nums == null){
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }

}
