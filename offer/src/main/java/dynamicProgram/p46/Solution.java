package dynamicProgram.p46;

import java.util.Arrays;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 *
 * 思路：
 *      动态规划
 *      与斐波那契数列和青蛙跳台阶一样，同属于“处理最后一步”问题
 *
 *      dp[i]定义：
 *          0.。。i长度的数字（字符串）一共有dp[i]种翻译方式
 *
 *      针对数字，如果最后两个数字小于26，那么有
 *          dp[i]=dp[i-1]+dp[i-2]
 *      如果最后两数字大于等于26，那么有
 *          dp[i]=dp[i-2]
 *
 *      这里有个细节问题：
 *          最后两个数字是：00 01 02 03...09是不能翻译的，因此要跳过
 *          也就是最后两个数字 10<=ij<=25
 *
 *      base case
 *          dp[0]=1
 *          dp[1]=1
 */
public class Solution {
    public int translateNum(int num) {
        //这里直接用String也可以，str.charAt(index);
        char[] c = String.valueOf(num).toCharArray();
        int[] dp = new int[c.length + 1];
        Arrays.fill(dp, 0);
        //base case
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < c.length; i++) {
            //最后两个数字小于等于25,可以分为2种方式
            //这样其实是区间[10,15][20,25]
            // if(c[i-1]>='1'&&c[i-1]<='2'&&c[i]<='5'){
            if (c[i - 1] == '1' || (c[i - 1] == '2' && c[i] <= '5')) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }

        return dp[c.length];
    }

}