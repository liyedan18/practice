package dynamicProgram.p007;

import java.util.HashMap;
import java.util.Map;

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
        递归解法——自顶向下
        优化暴力递归中，子问题的重叠计算问题
        使用备忘录
 */
public class Solution2 {

    //备忘录 map<n, 对应的fib(n)>
    private Map<Integer, Integer> map = new HashMap<>();

    //函数定义：返回第n个斐波那契数
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        int val = fib(n - 1) + fib(n - 2);
        val = val % 1000000007;
        map.put(n, val);
        return map.get(n);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        //134903163
        System.out.println(s.fib(45));
    }
}