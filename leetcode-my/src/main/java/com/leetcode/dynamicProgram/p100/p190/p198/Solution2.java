package com.leetcode.dynamicProgram.p100.p190.p198;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 *
 * 思路：
 *      最高金额 -> 穷举 -> 动态规划
 *      dp数组或dp函数
 *          数组类型：从头到尾、只包含中间段移动、从尾到头
 *          本题属于从尾到头计算，根据函数签名，可以使用递归的思想
 *
 *      状态：
 *          走到的当前房子
 *      选择：
 *          抢或者不抢
 *      状态转移方程：
 *          dp[start]=x表示给定nums，从start位置开始抢，能拿到的最高金额是x
 *          求：dp(0)
 *          dp() = max(dp(start+1),  //当前不抢
 *                  dp(start+2) + nums[start])  //当前抢
 *      base case
 *          start>=length ,dp()=0
 *
 *      动态规划方法，由底到上
 */
public class Solution2 {
    private Map<Integer, Integer> note = new HashMap<>();

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //+2是为了后面计算dp[i+2]不超出边界
        int[] dp = new int[nums.length + 2];
        Arrays.fill(dp, 0);
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }

        return dp[0];
    }
}
