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

 滑动窗口+固定窗口
    在缩容左边界时，对数据是否满足要求进行判断。
 */

public class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.equals("") || s2.equals("") || s2.length() < s1.length()) {
            return false;
        }

        //需要确定s2完全包含s1的全部字符，同时滑动窗口内不能包含其他字符，也就是mapNeed.size==mapWindow.size
        //固定窗口往前滑动
        //用map存储s1的全部字符，遍历s2的字符，看是否满足map的需求，满足即返回
        Map<Character, Integer> mapNeed = new HashMap<>();
        Map<Character, Integer> mapWindow = new HashMap<>();
        for (char c : s1.toCharArray()) {
            mapNeed.put(c, mapNeed.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口框架
        int left = 0, right = 0;
        //计数器，满足map的条件：meetCount==mapNeed.size();
        int meetCount = 0;
        //扩容右边界
        while (right < s2.length()) {
            //更新数据
            char rightChar = s2.charAt(right);
            right++;
            mapWindow.put(rightChar, mapWindow.getOrDefault(rightChar, 0) + 1);
            //增加计数器
            if (mapNeed.get(rightChar) != null && mapNeed.get(rightChar).equals(mapWindow.get(rightChar))) {
                meetCount++;
            }

            // 缩容左边界
            while (right - left >= s1.length()) {
                char leftChar = s2.charAt(left);
                left++;

                //是否满足要求
                if (meetCount == mapNeed.size() && mapWindow.size() == mapNeed.size()) {
                    return true;
                }

                //缩减计数器
                if (mapNeed.get(leftChar) != null && mapNeed.get(leftChar).equals(mapWindow.get(leftChar))) {
                    meetCount--;
                }

                mapWindow.put(leftChar, mapWindow.get(leftChar) - 1);
                if (mapWindow.get(leftChar).equals(0)) {
                    mapWindow.remove(leftChar);
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.checkInclusion("ab", "eidboaoo"));
        // System.out.println(s.checkInclusion("ab", "eidbaooo"));
        System.out.println(s.checkInclusion("trinitrophenylmethylnitramine",
                "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
        System.out.println(s.checkInclusion("trini", "dinitrophenylhydrazinetrini"));
    }
}
