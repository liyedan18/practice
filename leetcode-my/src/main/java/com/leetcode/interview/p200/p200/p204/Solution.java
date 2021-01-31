package com.leetcode.interview.p200.p200.p204;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数n的质数的数量。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 *
 * 思路：
 *      质数：
 *          只能被自己和1整除
 *      用递归
 *          base case
 *              0  1  2
 *
 * 这种解法超出时间限制，需要优化
 */
public class Solution {
    /**
     * 返回0-n的质数
     */
    public int countPrimes(int n) {
        return count(n-1);
    }

    private int count(int n){
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int res = 0;
        res = count(n - 1);

        //判断n是否是质数
        if (n % 2 == 0) {
            return res;
        }
        for (int i = 3; i <= n / 2; i += 2) {
            if (n % i == 0) {
                return res;
            }
        }

        res += 1;

        return res;
    }

}
