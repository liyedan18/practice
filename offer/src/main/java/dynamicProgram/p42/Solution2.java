package dynamicProgram.p42;

import java.util.Arrays;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 * 思路：
 *      动态规划
 *      dp[i]定义：
 *          以i为起始（或者结束）位置的nums数组中，连续子数组的最大和为dp[i]
 *
 *          最终结果需要在dp[0....i]中取最大值
 *
 *      base case
 *          dp[n-1]=nums[n-1]
 *
 *      状态转移方程：
 *          dp[i-1]=max(dp[i],dp[i]+nums[i-1])  //这个状态转移方程不对
 *          对于dp[i-1]，如果dp[i]+nums[i-1]小于nums[i-1]，
 *          那么dp[i-1]就应该重新计算，从nums[i-1]开始自成一派
 *
 *          状态转移方程应该为：
 *              dp[i-1]=max(nums[i-1],dp[i]+nums[i-1])
 *
 *              优化
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        //base case
        dp[length - 1] = nums[length - 1];
        int res = dp[length - 1];
        for (int i = length - 1; i >= 1; i--) {
            dp[i - 1] = Math.max(nums[i - 1], dp[i] + nums[i - 1]);
            res = Math.max(dp[i - 1], res);
        }

        return res;
    }
}