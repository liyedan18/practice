package com.leetcode.p340.p345;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 *
 * 方法：两个指针相向而行。
 */
public class Result1 {

    private static Set<Character> characterSet = Stream.of('a','e','i','o','u','A','E','I','O','U')
            .collect(Collectors.toSet());
//    .collect(Collectors.toCollection(HashSet::new));
    public String reverseVowels(String s) {
        if (null == s || s.equals("")) {
            return s;
        }
        char[] strArr = s.toCharArray();
        int firstIndex = 0;
        int lastIndex = strArr.length - 1;
        char tempCFirst;
        char tempCLast;
        for (; firstIndex < lastIndex; firstIndex++) {
            tempCFirst = strArr[firstIndex];
            if (containsAEIOU(tempCFirst)) {
                for (; lastIndex > firstIndex; lastIndex--) {
                    tempCLast = strArr[lastIndex];
                    if (containsAEIOU(tempCLast)) {
                        strArr[lastIndex] = tempCFirst;
                        strArr[firstIndex] = tempCLast;
                        lastIndex--;
                        break;
                    }
                }
            }
        }
        return String.valueOf(strArr);

    }

/*    public boolean containsAEIOU(char c){
        String aeiou = "AEIOUaeiou";
        if (aeiou.contains(String.valueOf(c))){
            return true;
        }
        return false;
    }*/

    //使用stream
    public boolean containsAEIOU(char c) {
        return characterSet.contains(c);
    }


    public static void main(String[] args) {
        Result1 result1 = new Result1();

        System.out.println(result1.reverseVowels("hello"));
        System.out.println(result1.reverseVowels("leetcode"));
        System.out.println(result1.reverseVowels("aeiou AEIOU"));
    }
}
