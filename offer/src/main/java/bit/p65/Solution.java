package bit.p65;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 * 提示：
 *
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 *
 * 思路：
 *      用位运算
 *      无进位和sum = a^b
 *      进位carry = a&b<<1
 *      然后sum+carry即可，这又变成了加法运算，可以递归调用add方法
 *
 *      结束符条件：
 *          a==0或者b==0
 *
 *      注意：
 *          位运算一定要加括号
 *
 */
public class Solution {
    public int add(int a, int b) {
        if (b == 0 || a == 0) {
            return a == 0 ? b : a;
        }

        int sum = a ^ b;
        //位运算一定要加括号
        int carry = (a & b) << 1;
        return add(sum, carry);
    }


}