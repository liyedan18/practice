package dynamicProgram.p10;

import java.util.Arrays;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * 思路：
 *      动态规划
 *      dp[i]定义：
 *          表示第i级台阶有多少跳法
 *      dp[i]=Max(dp[i-1]+1,dp[i-2]+2)   //这个状态转移方程不对
 *
 *      一次只能跳1级或者2级台阶，当最后一步时，只有两种选择，
 *          跳1级：dp[i-1]
 *          跳2级:dp[i-2]
 *          总的跳法就是两种加起来，那么状态转移方程是：
 *              dp[i]=dp[i-1]+dp[i-2]
 *
 *      base case:
 *          dp[0]=1
 *          dp[1]=1
 *          dp[2]=2
 *
 */
public class Solution {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        //初始化
        Arrays.fill(dp, 1);
        //base case
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }
}