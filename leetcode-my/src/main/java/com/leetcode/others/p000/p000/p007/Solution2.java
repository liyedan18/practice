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
 *      一位一位进行计算，数字要得到每一位，就要使用取模%或除法/
 *      当前数字结果cur
 *      下一位要加上的个位next
 *
 *      将x从个位开始遍历
 *
 *      如果cur>max/10,那么一定会超出最大值
 *      如果cur<max/10 && next>7或next<-8，那也会超出最大值
 *
 */
public class Solution2 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int cur = 0;
        int next = 0;
        while (x != 0) {
            next = x % 10;
            x /= 10;
            if (cur > Integer.MAX_VALUE / 10 || cur < Integer.MIN_VALUE / 10) {
                return 0;
            }
            if ((cur == Integer.MAX_VALUE / 10 && next > 7) || (cur == Integer.MIN_VALUE / 10 && next < -8)) {
                return 0;
            }
            cur = cur * 10 + next;
        }
        return cur;
    }
}
