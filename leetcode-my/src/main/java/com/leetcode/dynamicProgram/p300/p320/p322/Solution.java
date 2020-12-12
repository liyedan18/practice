package com.leetcode.dynamicProgram.p300.p320.p322;


/**
 322. 零钱兑换

 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 如果没有任何一种硬币组合能组成总金额，返回 -1。

 你可以认为每种硬币的数量是无限的。

 示例 1：

 输入：coins = [1, 2, 5], amount = 11
 输出：3
 解释：11 = 5 + 5 + 1
 示例 2：

 输入：coins = [2], amount = 3
 输出：-1
 示例 3：

 输入：coins = [1], amount = 0
 输出：0
 示例 4：

 输入：coins = [1], amount = 1
 输出：1
 示例 5：

 输入：coins = [1], amount = 2
 输出：2
  

 提示：

 1 <= coins.length <= 12
 1 <= coins[i] <= 231 - 1
 0 <= amount <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/coin-change

 思路：
    最少的硬币个数，动态规划解法
    穷举  --> 递归
    如coins = [1, 2, 5], amount = 11
    最重要的思路是：
        如果知道组成amount=11-2=9的最少的硬币数，那只需要+1（币值为2）就可以了，依次往前推。。。
    递归问题

 问题：
    递归解法可行，但是数据过大，会超出时间限制
    如  coins = [1, 2, 5], amount = 100. 1分钟都算不完
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;   //Integer.MAX
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            //子问题结果<0，则是不能组成总金额，需要跳过
            if (subProblem < 0) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = new int[]{1, 2, 5};
        // int[] coins = new int[]{2};
        System.out.println(s.coinChange(coins, 100));
    }
}
