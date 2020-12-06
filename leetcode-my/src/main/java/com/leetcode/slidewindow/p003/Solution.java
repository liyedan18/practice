package com.leetcode.slidewindow.p003;


import java.util.HashMap;
import java.util.Map;

/**
 3. 无重复字符的最长子串

 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 示例 4:

 输入: s = ""
 输出: 0
  

 提示：

 0 <= s.length <= 5 * 104
 s 由英文字母、数字、符号和空格组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

    滑动窗口问题
        注意左边界缩容的条件
        注意什么情况下才是想要的结果
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        //滑动窗口框架
        int left = 0, right = 0;
        //右边界扩容
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            //数据处理
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            //左边界缩容条件,窗口中有重复元素
            while (map.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                left++;
                map.put(leftChar, map.get(leftChar) - 1);
            }

            //此时窗口中已经没有重复元素，这时的长度是想要的结果
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}
