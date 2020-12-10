package com.leetcode.slidewindow.p567;


import java.util.HashMap;
import java.util.Map;

/**
 567. 字符串的排列

 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

 换句话说，第一个字符串的排列之一是第二个字符串的子串。

 示例1:

 输入: s1 = "ab" s2 = "eidbaooo"
 输出: True
 解释: s2 包含 s1 的排列之一 ("ba").
  
 示例2:

 输入: s1= "ab" s2 = "eidboaoo"
 输出: False
  

 注意：

 输入的字符串只包含小写字母
 两个字符串的长度都在 [1, 10,000] 之间

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutation-in-string

 看错题意，如下解答是解决了s2是否完全包含s1的全部字符
 */

public class Solution2 {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.equals("") || s2.equals("")) {
            return false;
        }

        //只需要确定s2完全包含s1的全部字符即可
        //单向滑动窗口，不需要缩容
        //用map存储s1的全部字符，遍历s2的字符，看是否满足map的需求，满足即返回
        Map<Character, Integer> mapNeed = new HashMap<>();
        Map<Character, Integer> mapWindow = new HashMap<>();
        for (char c : s1.toCharArray()) {
            mapNeed.put(c, mapNeed.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口框架
        int left = 0, right = 0;
        //满足map的条件：meetCount==map.size();
        int meetCount = 0;
        //扩容右边界
        while (right < s2.length()) {
            //数据处理
            char rightChar = s2.charAt(right);
            mapWindow.put(rightChar, mapWindow.getOrDefault(rightChar, 0) + 1);
            right++;
            //临界条件
            if (mapNeed.get(rightChar) != null && mapNeed.get(rightChar).equals(mapWindow.get(rightChar))) {
                meetCount++;
                if (meetCount == mapNeed.size()) {
                    return true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.checkInclusion("ab", "eidboaoo"));
        // System.out.println(s.checkInclusion("a", "a"));
        // System.out.println(s.checkInclusion("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
