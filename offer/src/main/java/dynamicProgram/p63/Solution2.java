package dynamicProgram.p63;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 10^5
 *
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 *
 * 思路：
 *      动态规划
 *          属于状态类问题
 *      dp[i][j]定义：
 *          j=1或j=0,表示第i+1天，持有股票或者没有持有股票时，最大利润
 *          求的就是dp[n-1][0]
 *      状态：
 *          两个：天数i,持有1或者不持有股票0
 *      状态转移方程：
 *          dp[i][0]=max(dp[i-1][0], dp[i-1][1]+prices[i])
 *              也就是第i天没持有股票=
 *                  max(第i-1天没有持有股票，第i-1天持有股票然后卖了)
 *
 *          dp[i][1]=max(dp[i-1][1], dp[i-1][0] -prices[i])  //这里不对，
 *          //只能买一次，则买了后，今天的钱就是-prices[i],不会带上dp[i-1][0]
 *          dp[i][1]=max(dp[i-1][1], -prices[i])
 *              也就是第i天持有股票=
 *                  max(第i-1天持有股票，第i-1天没持有股票然后买了)
 *      base case：
 *          dp[0][0]=0;
 *          dp[0][1]=0-prices[0]
 *
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        //base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}