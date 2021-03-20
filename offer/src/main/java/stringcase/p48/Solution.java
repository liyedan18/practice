package stringcase.p48;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 *
 * 思路：
 *      滑动窗口问题 + Map
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        //扩容右边界
        while (right <= s.length() - 1) {
            char rightC = s.charAt(right);
            right++;
            map.put(rightC, map.getOrDefault(rightC, 0) + 1);

            // 判断左边界是否需要缩容
            while (map.get(rightC) > 1) {
                char leftC = s.charAt(left);
                left++;
                map.put(leftC, map.get(leftC) - 1);
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}