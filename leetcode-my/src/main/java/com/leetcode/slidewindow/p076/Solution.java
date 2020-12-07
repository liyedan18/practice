package com.leetcode.slidewindow.p076;


import java.util.HashMap;
import java.util.Map;

/**
 76. 最小覆盖子串

 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

 示例 1：

 输入：s = "ADOBECODEBANC", t = "ABC"
 输出："BANC"
 示例 2：

 输入：s = "a", t = "a"
 输出："a"
  
 提示：

 1 <= s.length, t.length <= 105
 s 和 t 由英文字母组成
  

 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-window-substring

    我们要的结果在缩容时处理。
 */

public class Solution {
    public String minWindow(String s, String t) {

        if (s.equals("") || t.equals("")) {
            return "";
        }

        //滑动窗口问题

        //初始化需要的字符,<需要的字符，需要的个数>
        Map<Character, Integer> mapNeed = new HashMap<>();
        Map<Character, Integer> mapWindow = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapNeed.put(c, mapNeed.getOrDefault(c, 0) + 1);
        }

        //滑动窗口框架
        int left = 0, right = 0;
        //结果字符串的起始位置索引和长度
        int resStart = 0;
        int resEnd = Integer.MAX_VALUE;
        //当前window中已经匹配满足的字符个数,扩容结束开始缩容条件是meetCount==mapNeed.size()
        int meetCount = 0;

        //先移动右边界（扩容）
        for (; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            mapWindow.put(rightChar, mapWindow.getOrDefault(rightChar, 0) + 1);
            //每次只匹配一个字符
            // if (mapNeed.get(rightChar).equals(mapWindow.get(rightChar))) {  //这样会有空指针问题
            if (mapWindow.get(rightChar).equals(mapNeed.getOrDefault(rightChar, 0))) {
                meetCount++;
            }

            //条件满足，移动左边界（缩容）
            while (meetCount == mapNeed.size() && left <= right) {
                //记录结果值
                if (resEnd - resStart > right - left) {
                    resStart = left;
                    resEnd = right;
                }

                char leftChar = s.charAt(left);
                left++;

                //缩容数据处理
                mapWindow.put(leftChar, mapWindow.get(leftChar) - 1);
                if (mapNeed.get(leftChar) == null) {
                    // continue;
                // 这样没有考虑mapWindow中同一个字符次数比MapNeed中多的情况,如"aaaaaaaaaaaabbbbbcdd", "abcdd"
                // } else if (mapNeed.get(leftChar) != mapWindow.get(leftChar)) {
                } else if (mapNeed.get(leftChar) > mapWindow.get(leftChar)) {
                    meetCount--;
                }
            }

        }

        return resEnd == Integer.MAX_VALUE ? "" : s.substring(resStart, resEnd + 1);
    }

    public static void main(String[] args) {

        // Integer a = 278;
        // Integer b = 278;
        // Integer c = 277 + 1;
        // Integer不能判断相等，可以判断 > <
        // System.out.println(a == b);
        // System.out.println(a == c);
        // System.out.println("cccc".substring(0,4));
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(s.minWindow("a", "a"));
        System.out.println(s.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));

    }
}
