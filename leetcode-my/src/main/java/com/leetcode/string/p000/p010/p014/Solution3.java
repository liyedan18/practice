package com.leetcode.string.p000.p010.p014;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * 思路：
 *      横向比较，即类似于滑动窗口
 *      去第一个为参考，然后向右滑动比较
 *
 */
public class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        //横向比较
        if (strs == null || strs.length == 0) {
            return "";
        }

        int count = strs.length;
        String res = strs[0];
        int length = res.length();
        //遍历每一个字符串
        for (int i = 1; i < count; i++) {
            int j = 0;
            while (j < length && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            //相等的字符串长度为0
            if (j == 0) {
                return "";
            }
            if (j < length) {
                length = j;
                res = res.substring(0, j);
            }
        }

        return res;
    }
}
