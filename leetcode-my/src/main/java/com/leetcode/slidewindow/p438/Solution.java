package com.leetcode.slidewindow.p438;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 438. 找到字符串中所有字母异位词

 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：

 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。
 示例 1:

 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]

 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
  示例 2:

 输入:
 s: "abab" p: "ab"

 输出:
 [0, 1, 2]

 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string

 */

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> resList = new ArrayList<>();
        if (s == null || s.equals("") || s.length() < p.length()) {
            return resList;
        }

        Map<Character, Integer> mapNeed = new HashMap<>();
        Map<Character, Integer> mapWindow = new HashMap<>();
        for (char c : p.toCharArray()) {
            mapNeed.put(c, mapNeed.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口框架
        int left = 0, right = 0;
        //计数器，满足map的条件：meetCount==mapNeed.size(),同时mapWindow.size() == mapNeed.size()
        int meetCount = 0;
        //扩容右边界
        while (right < s.length()) {
            //更新数据
            char rightChar = s.charAt(right);
            right++;
            mapWindow.put(rightChar, mapWindow.getOrDefault(rightChar, 0) + 1);
            //增加计数器
            if (mapNeed.get(rightChar) != null && mapNeed.get(rightChar).equals(mapWindow.get(rightChar))) {
                meetCount++;
            }

            // 缩容左边界
            while (right - left >= p.length()) {
                char leftChar = s.charAt(left);
                left++;

                //是否满足结果要求
                if (meetCount == mapNeed.size() && mapWindow.size() == mapNeed.size()) {
                    resList.add(left - 1);
                }

                //缩减计数器
                if (mapNeed.get(leftChar) != null && mapNeed.get(leftChar).equals(mapWindow.get(leftChar))) {
                    meetCount--;
                }
                //移除左边界数据
                mapWindow.put(leftChar, mapWindow.get(leftChar) - 1);
                if (mapWindow.get(leftChar).equals(0)) {
                    mapWindow.remove(leftChar);
                }
            }

        }

        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("ababe", "ab"));
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}
