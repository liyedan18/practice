package dynamicProgram.p007;

import java.util.Arrays;

/**
 剑指 Offer 10- I. 斐波那契数列

 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 示例 1：

 输入：n = 2
 输出：1
 示例 2：

 输入：n = 5
 输出：5
  

 提示：

 0 <= n <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof

    动态规划思想
        自底向上  迭代解法
        使用dp数组保存每个输入n对应的输出结果
 */
public class Solution3 {

    //函数定义：返回第n个斐波那契数
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //状态转移方程
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        //134903163
        System.out.println(s.fib(45));
    }
}