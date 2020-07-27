package com.leetcode.p300.p380.p387;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * <p>
 * 把字符串变成字符数组，然后循环计数，找到第一个计数为1的字符。
 */
public class Result1 {
    public int firstUniqChar(String s) {
        List<Character> characters = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        int tempCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!characters.contains(s.charAt(i))) {
                characters.add(s.charAt(i));
                count.add(1);
            } else {
                tempCount = count.get(characters.indexOf(s.charAt(i)));
                count.set(characters.indexOf(s.charAt(i)), ++tempCount);
            }
        }
        System.out.println("======");
        //count中第一个是1的位置即为第一个不重复的字符的位置
        System.out.println(count.indexOf(1));
        if (count.indexOf(1)>0){
        return s.indexOf(characters.get(count.indexOf(1)));
        }
        return 0;

    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        System.out.println(result1.firstUniqChar("leetcode"));
        System.out.println(result1.firstUniqChar("loveleetcode"));
        System.out.println(result1.firstUniqChar("aaa"));
        System.out.println(result1.firstUniqChar("aaaaabbbbbdddddssssssccccccddddddddeeeeeesssssoddooz"));

    }
}
