package com.leetcode.dynamicProgram.p800.p880.p887;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 *
 * 你将获得K个鸡蛋，并可以使用一栋从1到N共有 N层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层F ，满足0 <= F <= N 任何从高于 F的楼层落下的鸡蛋都会碎，从F楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层X扔下（满足1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 *
 * 思路：
 *      最坏情况下的最少次数
 *
 *      动态规划+dp数组优化
 *      1.状态(当前问题和子问题的变量)
 *          楼层数N，鸡蛋数K
 *          dp(k,n)   二维数组
 *      2.选择(改变状态有哪些选择)
 *          在哪个楼层扔(结果碎了、没碎)
 *      3.状态转移方程
 *          dp(k,n) = max(dp(k-1, 1...i),  //鸡蛋碎了
 *                       dp(k,i+1...n))  //鸡蛋没碎
 *                      +1
 *
 *      4.base case
 *          k=1 return N
 *          n=0 return 0
 *
 *      这题解法有问题，重要的是思想
 *
 */
public class Solution {
    public int superEggDrop(int K, int N) {

        //初始化和base case
        int[][] dp = new int[K+1][N +1];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        //base case i=0,1的行和列
        for (int i = 0; i <= K; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }

        //第2行第2列开始填表推导
        //蛋
        for (int i = 2; i <= K; i++) {
            //层
            for (int j = 2; j <= N; j++) {

                //每一种情况都从第1层开始计算到第j层，然后取最小值
                for (int f = 1; f <= j; f++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][f - 1],  //碎了
                            dp[i][j - f]) + 1);  //没碎
                }

            }
        }

        return dp[K][N];
    }

}
