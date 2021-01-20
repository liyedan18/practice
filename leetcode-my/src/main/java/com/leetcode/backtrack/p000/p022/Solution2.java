package com.leetcode.backtrack.p000.p022;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * 思路：
 *      括号问题的2个性质
 *      1.合法的括号一定是左括号等于右括号
 *      2.对于0<=i<=n，一定是左括号数量大于等于右括号
 *
 *      判断括号合法性：用栈
 *      生成括号：用回溯递归
 *
 *      生成括号问题转换描述：
 *          有2n个位置，每个位置可以放'('或者')'，那么有多少种合法的括号组合？
 *
 *      注意：
 *          多个判断的顺序
 *
 * 思路2：
 *      这也是二叉树的遍历，可以用DFS
 *
 */
public class Solution2 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        if (n <= 0) {
            return res;
        }
        dfs(2 * n, "", 0, 0);
        return res;
    }

    /**
     * 回溯算法框架
     *
     * @param n         总共有几个位置
     * @param singleRes 单次递归记录结果
     * @param left      记录左括号数量，因为要判断左右括号数量的多少
     * @param right     记录右括号数量
     */
    private void dfs(int n, String singleRes, int left, int right) {

        //不合法
        if (right > left || (right + left) > n) {
            return;
        }

        //base case
        if (left == right && (left + right) == n) {
            res.add(singleRes);
            return;
        }

        //递归
        if (left < n) {
            dfs(n, singleRes + "(", left + 1, right);
        }

        if (right < n) {
            dfs(n, singleRes + ")", left, right + 1);
        }

    }

}
