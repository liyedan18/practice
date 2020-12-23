package com.leetcode.dynamicProgram.p000.p010.p005;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * 思路：
 *      双指针 + 回文子串对称（规律、套路）
 *      奇数：以s[i]为中点
 *      偶数：以s[i] s[i+1]为中点
 *
 *      也可动态规划解法
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        String res = "";
        for (int i = 0; i < length; i++) {
            // 以s[i]为中心
            String s1 = sublp(s, i, i);
            //以s[i,i+1]为中心
            String s2 = sublp(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;
    }

    /**
     * 获取s(l,r)为中心的最长回文子串
     */
    private String sublp(String s, int l, int r) {
        while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
            l--;
            r++;
        }
        //substring [)
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println("aa".substring(0,1));
        System.out.println("aaab".substring(0,2));
        System.out.println("aaab".substring(0,4));
    }
}
