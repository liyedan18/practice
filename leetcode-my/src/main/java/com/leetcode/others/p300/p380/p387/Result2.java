package com.leetcode.others.p300.p380.p387;


import java.util.HashMap;
import java.util.Map;

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
 * 用map记录字符及其个数，然后找只有一个的.
 * 再次遍历字符串，到map中去比较哪个次数是一个
 */
public class Result2 {
    public int firstUniqChar(String s) {
        Map<Integer, Integer> count = new HashMap<>();
        s.chars().forEach(value -> {
            if (count.containsKey(value)){
                count.put(value, count.get(value)+1);
            } else {
                count.put(value,1);
            }
        });
        for (int i = 0; i < s.length(); i++) {
            if (count.get((int)s.charAt(i))==1){
                return i;
            }
        }
        return 0;

    }


    public static void main(String[] args) {
        Result2 result1 = new Result2();
        System.out.println(result1.firstUniqChar("leetcode"));
        System.out.println(result1.firstUniqChar("loveleetcode"));
        System.out.println(result1.firstUniqChar("aaa"));
        System.out.println(result1.firstUniqChar("aaaaabbbbbdddddssssssccccccddddddddeeeeeesssssoddooz"));
    }
}
