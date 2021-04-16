package com.leetcode.string.p000.p010.p014;

import java.util.HashMap;
import java.util.Map;

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
 *      直接暴力计算，也就是纵向比较一个一个的字符
 *      这版代码逻辑写的不好
 *
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        //直接暴力计算
        if (strs.length == 0) {
            return "";
        }

        String res = "";
        //第几个字符串
        int i = 0;
        //第几个字符
        int j = 0;
        while (true) {
            for (i = 0; i < strs.length; i++) {
                //取第一个字符串为参考
                if (j >= strs[0].length()) {
                    return res;
                }
                char tempC = strs[0].charAt(j);
                //不超出字符串的长度范围
                if (j <= strs[i].length() - 1) {
                    //相等
                    if (strs[i].charAt(j) == tempC) {
                        if (i == strs.length - 1) {
                            res += tempC;
                            j++;
                        }
                    } else {
                        //不相等
                        return res;
                    }
                } else {
                    return res;
                }
            }
        }

    }
}
