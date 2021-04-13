package com.leetcode.others.p000.p000.p007;

/**
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 * 思路：
 *      这是第一版，这种解法真是太low了
 *
 *      记录数字的正负。
 *      将数字转换为字符串，然后反转。
 *      根据数字的长度判断
 *      超过最大值就返回0。
 *
 */
public class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        //<0,设置为true
        boolean flag = false;
        if (x < 0) {
            flag = true;
        }

        x = Math.abs(x);
        String max = String.valueOf(Integer.MAX_VALUE);
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String xstr = sb.reverse().toString();

        //长度小于最大值长度
        if (xstr.length() < max.length()) {
            if (flag == false) {
                return Integer.parseInt(xstr);
            } else {
                return -Integer.parseInt(xstr);
            }
        }
        //长度等于最大值长度
        if (flag == false) {
            //正数
            if (xstr.compareTo(max) > 0) {
                return 0;
            } else {
                return Integer.parseInt(xstr);
            }
        } else {
            //负数
            String min = new StringBuilder(max).replace(max.length() - 1, max.length(), "8").toString();
            if (xstr.compareTo(min) > 0) {
                return 0;
            } else {
                return -Integer.parseInt(xstr);
            }
        }

    }
}
