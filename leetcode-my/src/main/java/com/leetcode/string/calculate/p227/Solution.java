package com.leetcode.string.calculate.p227;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 227. 基本计算器 II
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 *
 * 示例1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 *
 *
 * 思路：
 *      复杂的问题一步一步拆解，先从最简单的情况做起。
 *      如同做试卷的压轴题一样，能写出最简单的情况也有分数。
 *
 *      1.如果只有数字字符串，要把字符串解析成数字和字符
 *          用循环，一个一个字符解析
 *      2.最简单的情况，只有"+""-"，如何计算
 *          用栈，将符号和数字一起存到栈中
 *          遇到一个符号，则把之前的数字和符号入栈
 *              加减完成后，考虑* 和 /的情况
 *                  乘除会把当前的num和栈顶的元素结合起来运算，运算的结果再入栈
 *      3.空格字符如何过滤
 *          循环中忽略字符
 *
 *       5.在处理过程中，发现将字符串转换为LinkedList方便处理
 *
 *      相关问题——224
 */
public class Solution {
    public int calculate(String s) {

        //先转换为List
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.trim().toCharArray()) {
            list.add(c);
        }

        return helper(list);
    }

    private int helper(LinkedList<Character> list) {
        //解析后的数字
        int num = 0;
        //记录符号位，初始设置为+
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        while (!list.isEmpty()) {
            char c = list.removeFirst();
            //1.解析为数字
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            //不是数字，也不是空格，或者到达最后一位
            if ((!Character.isDigit(c) && c != ' ') || list.isEmpty()) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        num *= stack.pop();
                        stack.push(num);
                        break;
                    case '/':
                        int temp = stack.pop();
                        num = temp / num;
                        stack.push(num);
                        break;
                }

                num = 0;
                sign = c;
            }

        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculate(" 3/2 "));
    }

}
