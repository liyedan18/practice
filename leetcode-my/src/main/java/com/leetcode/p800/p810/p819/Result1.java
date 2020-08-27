package com.leetcode.p800.p810.p819;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。

 题目保证至少有一个词不在禁用列表中，而且答案唯一。

 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

 示例：

 输入:
 paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 banned = ["hit"]
 输出: "ball"
 解释:
 "hit" 出现了3次，但它是一个禁用的单词。
 "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
  

 提示：

 1 <= 段落长度 <= 1000
 0 <= 禁用单词个数 <= 100
 1 <= 禁用单词长度 <= 10
 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 paragraph 只包含字母、空格和下列标点符号!?',;.
 不存在没有连字符或者带有连字符的单词。
 单词里只包含字母，不会出现省略号或者其他标点符号。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/most-common-word

 1.把单词挑出来
 2.计算所有单词的个数，找出最多的那个
 3.用最多的去禁用表去判断是否存在，存在则进行下一个。


 */
public class Result1 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> strMap = new HashMap<>();
        //1
//        Arrays.stream(paragraph.split(" ")).forEach(word -> {    //不能用空格分割，有的单词之间只用了标点
        Arrays.stream(paragraph.split("[^a-zA-Z]+")).forEach(word -> {
            String temp = word.toLowerCase();

            //有正则表达式，这里也不需要了
//            if (temp.charAt(word.length()-1) > 'z' || temp.charAt(word.length()-1) < 'a') {
//                temp = temp.substring(0, temp.length() - 1);
//            }

            if (strMap.containsKey(temp)) {
                strMap.put(temp, strMap.get(temp) + 1);
            } else {
                strMap.put(temp, 1);
            }

        });

        //3 去除禁用表的数据
        strMap.keySet().removeAll(Arrays.asList(banned));;
        int max = 0;
        String resultStr = "";
        //2
        for (String str : strMap.keySet()) {
            if (strMap.get(str) > max) {
                max = strMap.get(str);
                resultStr = str;
            }
        }
        return resultStr;

    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph = "a, a, a, a, b,b,b,c, c"; //不能以“ ”分开单词
//        String[] banned = {"hit"};
        String[] banned = {"a"};
        System.out.println(result1.mostCommonWord(paragraph,banned));

    }
}
