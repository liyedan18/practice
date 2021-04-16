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
 *      同样是纵向比较
 *
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        //纵向比较字符
        if (strs == null || strs.length == 0) {
            return "";
        }

        //字符串个数
        int count = strs.length;
        //字符串的单个长度,以第0个字符串为参考
        int length = strs[0].length();
        //选中单个字符
        for (int i = 0; i < length; i++) {
            char tempC = strs[0].charAt(i);
            //遍历所有字符串
            for (int j = 1; j < count; j++) {
                //当前字符的长度已经达到要比较的字符串的长度
                if (i == strs[j].length() || tempC != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
