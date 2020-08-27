package com.leetcode.p800.p810.p819;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * <p>
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * <p>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= 段落长度 <= 1000
 * 0 <= 禁用单词个数 <= 100
 * 1 <= 禁用单词长度 <= 10
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-common-word
 * <p>
 * 官方：用一次循环即可得出结果
 */
public class Result3 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> words = new HashMap<>();
        Set<String> banns = Set.of(banned);

        //非常重要，否则最后不会执行for中的else if
        paragraph+=".";

        StringBuilder word = new StringBuilder();
        String resultStr = "";
        int count = 0;
        int max = 0;
        for (Character c : paragraph.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(c);
                //这里不能只是else,要在单词中排除掉空格和标点
            } else if (word.length() > 0) {
                String str = word.toString();
                if (!banns.contains(str)) {
                    words.put(str, words.getOrDefault(str, 0) + 1);
                    count = words.get(str);
                    if (count > max) {
                        max = count;
                        resultStr = str;
                    }
                }
                word = new StringBuilder();
            }

        }
        return resultStr;
    }

    public static void main(String[] args) {
        Result3 result1 = new Result3();
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String paragraph = "a, a, a, a, b,b,b,c, c"; //不能以“ ”分开单词
        String paragraph = "Bob. hIt, baLl";
//        String[] banned = {"hit"};
//        String[] banned = {"a"};
        String[] banned = {"bob", "hit"};
        System.out.println(result1.mostCommonWord(paragraph, banned));

    }
}
