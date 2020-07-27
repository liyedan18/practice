package com.leetcode.p500.p550.p557;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 示例 1:

 输入: "Let's take LeetCode contest"
 输出: "s'teL ekat edoCteeL tsetnoc" 
 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii

 思路：
 把字符串按照空格分割，然后反转单个单词。
 */
public class Result1 {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        Arrays.stream(str).forEach(s1 -> {
            buffer.append(new StringBuffer(s1).reverse().append(" "));
        });
//        return Arrays.stream(str).collect(Collectors.joining(" "));
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        System.out.println(result1.reverseWords("rrr qqaa"));
        System.out.println(result1.reverseWords("abcr frd"));
        System.out.println(result1.reverseWords("123 456 546 678 dfg"));
    }
}
