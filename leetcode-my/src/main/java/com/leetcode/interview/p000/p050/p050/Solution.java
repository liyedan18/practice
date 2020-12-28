package com.leetcode.interview.p000.p050.p050;

/**
 * 50. Pow(x, n)  x的n次方
 *
 * 实现pow(x, n)，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 <x< 100.0
 * n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 *
 * 思路：
 *      递归，时间复杂度O(logn)
 *
 */
public class Solution {
    /**
     * 普通直接计算。要考虑n<0的情况
     * 时间复杂度：O(n)
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double res = 1;
        int positiveN = Math.abs(n);
        for (int i = 0; i < positiveN; i++) {
            res = res * x;
        }
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }

    /**
     * 递归。要考虑n<0的情况
     * 时间复杂度：仍然是O(n)
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double res = 1;
        if (n < 0) {
            res = myPow2(x, n+1)*x;
            res = 1 / res;
        } else {
            res = myPow2(x, n-1)*x;
        }
        return res;
    }

    /**
     * 递归。要考虑n<0的情况
     * 时间复杂度：仍然是O(n)
     */
    public double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double res = 1;
        int positiveN = Math.abs(n);

        // if (n % 2 == 1) {   //如果是正数可以用，
        if (positiveN % 2 != 0) {
            res =  myPow3(x, positiveN / 2) *  myPow3(x, positiveN / 2) * x;
        } else {
            res =  myPow3(x, positiveN / 2) *  myPow3(x, positiveN / 2);
        }

        return n < 0 ? 1 / res : res;
    }

    /**
     * 递归，去除冗余的情况。要考虑n<0的情况
     * 时间复杂度：O(logn)
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double res = 1;
        int positiveN = Math.abs(n);
        double temp = myPow(x, positiveN / 2);

        // if (n % 2 == 1) {   //如果是正数可以用，
        if (positiveN % 2 != 0) {
            res = temp * temp * x;
        } else {
            res = temp * temp;
        }

        return n < 0 ? 1 / res : res;
    }

}
