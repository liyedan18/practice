package com.leetcode.string.p000.p020.p028;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 *
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i + needle.length() <= haystack.length(); i++) {

            int k = 0;
            for (int j = i; j < haystack.length() && k < needle.length(); j++, k++) {

                if (haystack.charAt(j) != needle.charAt(k)) {
                    break;
                }
            }

            if (k == needle.length()) {
                //找到匹配
                return i;
            }
        }

        //不匹配
        return -1;
    }
}
