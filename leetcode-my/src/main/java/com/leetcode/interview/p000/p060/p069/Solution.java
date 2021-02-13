package com.leetcode.interview.p000.p060.p069;

/**
 * 69. x 的平方根
 *
 * 实现int sqrt(int x)函数。
 *
 * 计算并返回x的平方根，其中x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *     由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 *
 * 思路：
 *      标准二分搜索
 *      判断nums[mid]==target时，要改成nums[mid]*nums[mid]==target
 *
 *      超时了
 *      这样有问题，相乘会超出范围，导致product结果不对
 *      long product = mid * mid;
 *      应该改成
 *          long product = (long) mid * mid;
 *
 */
public class Solution {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //这样有问题，相乘会超出范围，导致product结果不对
            long product = mid * mid;
            if (product == x) {
                res = mid;
                return res;
            } else if (product > x) {
                right = mid - 1;
            } else if (product < x) {
                res = mid;
                left = mid + 1;
            }
        }

        return res;
    }

}
