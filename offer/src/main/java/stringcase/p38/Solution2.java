package stringcase.p38;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 *
 * 思路：
 *      类似于全排列，用DFS或者回溯算法
 *      用set去重过滤
 *      当前解法只适用于不含有重复字符的情况
 */
public class Solution2 {
    private Set<String> set;

    public String[] permutation(String s) {
        set = new HashSet<>();
        backTrack(s.toCharArray(), new LinkedList<>());
        String[] res = new String[set.size()];
        int i = 0;
        for (String str : set) {
            res[i] = str;
            i++;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    private void backTrack(char[] choice, LinkedList<Character> list) {
        if (list.size()==choice.length) {
            final StringBuilder sb = new StringBuilder();
            list.forEach(x -> sb.append(x));
            set.add(sb.toString());
            return;
        }

        for (char c : choice) {
            if (list.contains(c)){
                continue;
            }
            list.add(c);
            backTrack(choice, list);
            list.removeLast();
        }
    }

}
