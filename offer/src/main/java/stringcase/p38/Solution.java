package stringcase.p38;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
 *      交换法：
 *          如abc，固定第一个字符，将后面的字符看成一个整体，则有两种方式，abc bca
 *          也就是第一部分a和后面的部分bc交换即可。
 *          第一个字符为b，bac acb
 *              这里其实就是交换了a和b的位置
 *          第一个字符为c，cba bac
 *              这里其实就是交换了a和c的位置
 *
 *          然后固定第二个字符。。。第三个字符。。。递归进行
 */
public class Solution {
    private List<String> res;
    //存储s的全部字符，用于交换
    char[] c;

    public String[] permutation(String s) {
        res = new LinkedList<>();
        c = s.toCharArray();
        int size = s.length();
        backTrack(0);
        return res.toArray(new String[s.length()]);
    }

    //start相当于是哪一层
    private void backTrack(int start) {
        //终止条件
        if (start == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }

        //确保当前位置(start)不会有重复字符
        Set<Character> set = new HashSet<>();
        for (int i = start; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            //交换
            swap(i, start);
            backTrack(start + 1);
            //撤销
            swap(i, start);
        }
    }

    private void swap(int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
