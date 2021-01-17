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
 *      直接求解：
 *      nums=[],res =[]
 *      nums=[1], res = [],[1]
 *      nums=[1,2], res = [],[1],[2],[1,2]
 *      也就是结果每次都是在上一个结果值再增加一个最新的nums[last]
 */
public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        //先添加空集合
        res.add(new LinkedList<>());

        for (int num : nums) {
            //在之前的每个结果上都加上num
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> singleRes = new LinkedList<>(res.get(i));
                //每个结果上都加上num
                singleRes.add(num);
                //将拼接后的结果加到最终结果中
                res.add(singleRes);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }

}
