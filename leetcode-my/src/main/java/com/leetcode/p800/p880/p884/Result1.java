package com.leetcode.p800.p880.p884;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）

 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。

 返回所有不常用单词的列表。

 您可以按任何顺序返回列表。

 示例 1：

 输入：A = "this apple is sweet", B = "this apple is sour"
 输出：["sweet","sour"]
 示例 2：

 输入：A = "apple apple", B = "banana"
 输出：["banana"]

 提示：

 0 <= A.length <= 200
 0 <= B.length <= 200
 A 和 B 都只包含空格和小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences

 每个句子都先分隔成单词，然后计算个数，最后找到在本句中出现一次的，去另一个句子中查看是否包含。

 */
public class Result1 {
    private List<String> list = new ArrayList<>();

    public String[] uncommonFromSentences(String A, String B) {
        List<String> listA = Arrays.asList(A.split(" "));
        List<String> listB = Arrays.asList(B.split(" "));
        compute(listA, listB);
        compute(listB, listA);
        return list.toArray(String[]::new);

    }

    private void compute(List<String> listA, List<String> listB) {
        Map<String, Integer> mapA = new HashMap<>();
        listA.forEach(s -> mapA.put(s, mapA.getOrDefault(s, 0) + 1));
        mapA.keySet().removeAll(listB);
        mapA.forEach((s, integer) -> {
//            if (integer ==1 && !listB.contains(s)){
            if (integer == 1) {
                list.add(s);
            }
        });
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        String A = "this apple is sweet";
        String B = "this apple is sour";
        String A1 = "apple apple";
        String B1 = "banana";
        String A2 ="d b zu d t";
        String B2 ="udb zu ap";   //["b","t","udb","ap"]
        Arrays.stream(result1.uncommonFromSentences(A2, B2)).forEach(System.out::println);
//        Arrays.stream(result1.uncommonFromSentences(A1, B1)).forEach(System.out::println);

    }
}
