package com.leetcode.interview.p200.p200.p204;

import java.util.Arrays;

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
 *
 *          判断是否是质数，只需要判断 (2...sqrt(n))就可以了，而不用判断到n/2
 *          因为结果是以sqrt(n)*sqrt(n)对称的，如果(2...sqrt(n))找不到，则(sqrt(n)...n/2)也一定找不到
 *
 *      用自底而上，+备忘录(数组)
 *
 */
public class Solution5 {

    /**
     * 返回0- n-1的质数
     */
    public int countPrimes(int n) {

        boolean[] res = new boolean[n];
        Arrays.fill(res, true);

        //这里i*i与isPrimes中的判断类似，以平方为对称
        for (int i = 2; i * i < n; i++) {
            if (isPrimes(i)) {
                //n是质数，则n的倍数一定不是质数
                for (int j = i * 2; j < n; j += i) {
                    res[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (res[i]) {
                count++;
            }
        }

        return count;

    }

    /**
     * 判断n是否是质数
     */
    private boolean isPrimes(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
