package com.leetcode.dynamicProgram.p300.p320.p322;


import java.util.Arrays;

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
     穷举  --> 递归   寻找到能够靠近base case的规律或方式
     如coins = [1, 2, 5], amount = 11
     最重要的思路是：
        如果知道组成amount=11-2=9的最少的硬币数，那只需要+1（币值为2）就可以了，依次往前推。。。
     递归问题

     优化重叠计算子问题，带备忘录的递归，
     由底到上的解法——动态规划解法
        1、base case
        2、状态：amount,相当于问题的变量
        3、选择：硬币的面值
        4、dp函数、table
            dp函数：输入钱数amount，返回组成钱数最少需要的硬币个数
            dp table：数组(或Map)，输入钱数i，返回组成钱数最少需要的硬币个数dp[i]

         状态转移方程
         dp[i] = 1+dp[lastAmount];
            重要:*****寻找到能够靠近base case的规律或方式

     类似斐波那契数列解法  https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 */

public class Solution3 {
    public int coinChange(int[] coins, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        //dp table, 大小是amount+1，因为还要存储0
        int[] dp = new int[amount + 1];
        //初始化table为Integer.MAX，但是只需要比amount大即可
        // （因为最少硬币个数不可能比amount大），后面需要比较并取最小值
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        //计算所有钱数
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //钱数
                int lastAmount = i - coin;
                if (lastAmount < 0) {
                    continue;
                }

                dp[i] = Math.min(dp[i], 1 + dp[lastAmount]);
            }
        }

        //注意最后不是直接返回dp[amount]
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int[] coins = new int[]{1, 2, 5};
        // int[] coins = new int[]{2};
        // int[] coins = new int[]{186,419,83,408};
        // int[] coins = new int[]{186,419,83,408};
        System.out.println(s.coinChange(coins, 11));
    }
}
