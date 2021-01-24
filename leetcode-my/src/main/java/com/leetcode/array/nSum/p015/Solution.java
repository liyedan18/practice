package com.leetcode.array.nSum.p015;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 *
 * 思路：
 *      target=0，如果已知a，那么另外两个就是target-a，变成了两数之和。
 *      要保证不能有重复的值-> 在循环中处理
 *
 *      先排序，才能利用双指针技巧，才好跳过重复值
 *      穷举第一个值a，然后根据两数之和得出b,c
 *
 *      也就是：
 *          排序 + 穷举第一个值 + 两数之和 + 去重
 *
 *          0可以抽象出来为target，求sum的方法就可以通用。
 *
 *      时间复杂度：O(N*N) = 排序：O(NlogN) + O(N*N)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null) {
            return res;
        }

        //排序
        Arrays.sort(nums);
        int target = 0;

        //穷举第一个值
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];

            //计算另外两数之和的结果
            List<List<Integer>> singleRes = twoSumBetter(nums, i + 1, sum);

            if (!singleRes.isEmpty()) {
                int a = nums[i];
                singleRes.forEach(list -> list.add(a));
                res.addAll(singleRes);
            }

            //去重，跳过相邻相等的值(这里会增加到相等的最后一个值，还需要一步i++)
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }

        }

        return res;
    }

    /**
     * 求两数之和组合的结果，双指针（左右指针）技巧
     *
     * @param nums   有序（升序）数组
     * @param start  从nums的哪一个位置开始
     * @param target 目标和
     * @return 组成目标和的结果集，可能有多个，但不重复
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();

        for (int i = start, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];

            //找到结果
            if (sum == target) {
                List<Integer> singleRes = new LinkedList<>();
                singleRes.add(nums[i]);
                singleRes.add(nums[j]);
                res.add(singleRes);

                /**
                 * 下面这部分去重可以优化，如twoSumBetter所示
                 */
                //去重，跳过相邻相等的值
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }
                j--;
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                i++;

            } else if (sum > target) {
                //去重，跳过相邻相等的值
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }
                j--;

            } else {
                //去重
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                i++;
            }
        }

        return res;
    }


    /**
     * 求两数之和，双指针（左右指针）技巧
     *
     * @param nums   有序（升序）数组
     * @param start  从nums的哪一个位置开始
     * @param target 目标和
     * @return 组成目标和的结果集，可能有多个，但不重复
     */
    private List<List<Integer>> twoSumBetter(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();

        for (int i = start, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            int left = nums[i];
            int right = nums[j];
            //找到结果
            if (sum == target) {
                List<Integer> singleRes = new LinkedList<>();
                singleRes.add(nums[i]);
                singleRes.add(nums[j]);
                res.add(singleRes);

                //去重，跳过相邻相等的值
                while (i < j && nums[j] == right) {
                    j--;
                }
                while (i < j && nums[i] == left) {
                    i++;
                }

            } else if (sum > target) {
                //去重，跳过相邻相等的值
                while (i < j && nums[j] == right) {
                    j--;
                }
            } else {
                //去重
                while (i < j && nums[i] == left) {
                    i++;
                }
            }
        }

        return res;
    }

}
