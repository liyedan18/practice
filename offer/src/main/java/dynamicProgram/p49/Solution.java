package dynamicProgram.p49;

/**
 * 剑指 Offer 49. 丑数
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 *
 * 思路：
 *      核心：任何一个丑数都可以由前面的丑数通过*2、*3、*5得到
 *      动态规划
 *      dp[i]定义：
 *          表示第i+1个丑数
 *      dp[i]=min(dp[two],dp[three],dp[five])
 *      base case
 *          dp[0]=1
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        //base case
        dp[0] = 1;

        //每一个丑数都要*2、*3、*5,且不能遗漏
        //定义*2、*3、*5的丑数的索引
        int two = 0;
        int three = 0;
        int five = 0;

        for (int i = 1; i < n; i++) {
            int twoRes = dp[two] * 2;
            int threeRes = dp[three] * 3;
            int fiveRes = dp[five] * 5;
            dp[i] = Math.min(twoRes, Math.min(threeRes, fiveRes));

            //找到对应的丑数，则索引+1
            if (dp[i] == twoRes) {
                two++;
            }
            if (dp[i] == threeRes) {
                three++;
            }
            if (dp[i] == fiveRes) {
                five++;
            }
        }

        return dp[n - 1];
    }
}