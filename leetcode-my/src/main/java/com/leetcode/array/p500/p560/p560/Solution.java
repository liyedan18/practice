package com.leetcode.array.p500.p560.p560;

/**
 * 560. 和为K的子数组
 *
 * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数k的范围是[-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 *
 *
 * 思路：
 *      把所有的子数组和sum[i...j]都算出来，然后找和为k的有几个。
 *          问题是：每次去计算sum[i...j]时，都会去遍历一遍，再求和，
 *          也就是两层for循环，再加一层遍历（还是一层for循环），复杂度O(N*N*N)怎么优化？
 *
 *      空间换时间：
 *          数组前缀和技巧。用另外的数组，将sum[0..i]都计算出来并存储。
 *          sum[i...j] = sum[0...j] - sum[0...i]
 *          那么复杂度可以降到O(N*N)
 *
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {

        //存储前缀和
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        //计算前缀和
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        //遍历求所有的子数组的和
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                //sum[i...j]
                if (preSum[j + 1] - preSum[i] == k) {
                    res++;
                }
            }
        }

        return res;
    }

}
