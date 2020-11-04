package com.leetcode.stack.p000.p020.p020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * 思路：
 *      如果是对应的，那么左边的括号一定和右边的一一是对应的
 *
 *      左字符入栈，右字符匹配
 *
 *      1、碰到{([就放入栈，如果碰到)}]就从栈顶取出一个对比，如果比匹配就返回false
 *      2、如果s的长度是奇数，一定是false
 *      3、如果匹配完成后，栈为空，则是true，否则是false。
 */
public class Solution {
    public boolean isValid(String s) {

        if (s == null || s.equals("") || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (c != map.get(top)) {
                    return false;
                }
            }
        }

        //匹配完毕
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }

}
