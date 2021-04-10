package com.leetcode.others.p300.p380.p383;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

 (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

  

 注意：

 你可以假设两个字符串均只含有小写字母。

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ransom-note
 */
public class Result1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = ransomNote.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (magazine.contains(String.valueOf(chars[i]))){
                magazine.replaceFirst(String.valueOf(chars[i]) ,"");
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chars = new int[26];
        Arrays.fill(chars, 0);
        ransomNote.chars().forEach(x -> --chars[x - 'a']);
        magazine.chars().forEach(x -> ++chars[x - 'a']);
        return Arrays.stream(chars).min().getAsInt() >= 0;
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        System.out.println(result1.canConstruct("aa","aab"));
        System.out.println(result1.canConstruct("a","b"));
        System.out.println(result1.canConstruct("ab","ba"));
        "hello".chars().forEach(value -> System.out.println((char) value));

        List<String> strings = Arrays.asList("aa","","bb","ccc","ddd","","ddd");
        List<String> strings1 = strings.stream()
                .distinct()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        strings1.stream().forEach(s -> System.out.println(s));

        List<Integer> integers = Arrays.asList(1,2,3,4,3,4,5,6);
        List<Integer> integerList = integers.stream().map(integer -> integer * 10).distinct().collect(Collectors.toList());
        integerList.stream().forEach(System.out::println);
        System.out.println("==============");
        integerList.stream().limit(3).forEach(System.out::println);
        System.out.println("==============");
        List<String> strings2 = Arrays.asList("aa","","bb","ccc","ddd","","ddd");
        List<String> notEmptyStr = strings2.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(notEmptyStr);
        System.out.println("联合");
        String joinStr = strings2.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining("="));
        System.out.println(joinStr);

        List<Integer> integers1 = Arrays.asList(1,2,3,4,3,4,5,6);
        IntSummaryStatistics intSummaryStatistics = integers1.stream().mapToInt(value -> value).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());



        int[] temp = new int[]{1,2,3,4,5,6};
        List<Integer> collect = Arrays.stream(temp).boxed().collect(Collectors.toList());
        collect.stream().mapToInt(x ->x).toArray();

        String[] str = new String[]{"aa","bb"};
        List<String> strings3 = Arrays.asList(str);
        String[] strings4 = strings3.toArray(new String[0]);
        String[] strings5 = strings3.toArray(String[]::new);
        System.out.println("================");
        Arrays.stream(strings4).forEach(s -> System.out.println(s));
        Arrays.stream(strings5).forEach(s -> System.out.println(s));
    }
}
