package com.leetcode.string.calculate.p224;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 224. 基本计算器
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3* 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
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
 *      4.括号如何处理
 *          括号的内容就相当于输入一个新的字符串，也就是可以当做一个独立的表达式，
 *          因此，括号具有递归性质，可以直接调用calculate计算方法
 *          递归调用起点
 *              左括号：(
 *          递归调用结束：
 *              右括号：)
 *
 *       5.在处理过程中，发现将字符串转换为LinkedList方便处理
 *
 *      相关问题——227
 */
public class Solution {
    public int calculate(String s) {

        //字符串转换为List
        LinkedList<Character> list = new LinkedList<>();
        for (char c: s.toCharArray()){
            list.add(c);
        }

        return helper(list);
    }

    /**
     * 辅助计算方法，适用于加减乘除和括号
     *
     * @param list 输入的字符串
     * @return 计算器结果
     */
    private int helper(LinkedList<Character> list){

        int num = 0;
        Stack<Integer> stack = new Stack<>();
        //数字前面的符号，初始设置为+
        char sign = '+';

        while (!list.isEmpty()) {
            char c = list.removeFirst();

            //1.字符串解析成数字
            // if (Character.isDigit(c)) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }

            //(，递归调用计算括号内的内容
            if (c == '(') {
                /**
                 * 这里发现还是要把String改成LinkedList好，用一个就删除一个字符，
                 * 不用考虑在字符串中的索引跳过括号的问题
                 */
                num = helper(list);
            }

            //这里不能用else if,否则当最后一个是数字时，就走不到下面的if语句
            if ((!Character.isDigit(c) && c != ' ')
                    //或到达字符串结尾
                    || (list.isEmpty())) {
                //遇到一个符号，则把之前的数字和符号入栈
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
/*                    case '*':
                        num *= stack.pop();
                        stack.push(num);
                        break;
                    case '/':
                        int temp = stack.pop();
                        num = temp / num;
                        stack.push(num);
                        break;
                        */
                }
                sign = c;
                num = 0;

                //)右括号，跳出循环，返回计算结果
                //要在把num存到栈后才跳出循环
                if (c == ')') {
                    break;
                }

            }
        }

        //计算最终结果
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.calculate("1 + 1"));
        System.out.println(s.calculate("(4+5+2)-3"));
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    /**
     * 第一版
     */
    public int calculateFirst(String s) {

        int num = 0;
        Stack<Integer> stack = new Stack<>();
        //数字前面的符号，初始设置为+
        char sign = '+';
        //记录括号内的字符串
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //1.字符串解析成数字
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if ((!Character.isDigit(c) && c != ' ')
                    //或到达字符串结尾
                    || (i == s.length() - 1)) {
                //遇到一个符号，则把之前的数字和符号入栈
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                sign = c;
                num = 0;
            } else {
                //括号或空格
                //(，递归调用计算括号内的内容
                if (c == '(') {
                    /**
                     * 这里发现还是要把String改成LinkedList好，用一个就删除一个字符，
                     * 不用考虑在字符串中的索引跳过括号的问题
                     */
                    num = calculateFirst(s.substring(i + 1));
                } else if (c == ')') {
                    //)，返回计算结果
                    //为了跳出for循环
                    i = s.length();
                }
            }
        }

        //计算最终结果
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
