package com.leetcode.others.p800.p800.p804;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。

 为了方便，所有26个英文字母对应摩尔斯密码表如下：

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。

 返回我们可以获得所有词不同单词翻译的数量。

 例如:
 输入: words = ["gin", "zen", "gig", "msg"]
 输出: 2
 解释:
 各单词翻译如下:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."

 共有 2 种不同翻译, "--...-." 和 "--...--.".
  

 注意:

 单词列表words 的长度不会超过 100。
 每个单词 words[i]的长度范围为 [1, 12]。
 每个单词 words[i]只包含小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-morse-code-words

 1、取出每个单词，然后对该单词的字母进行翻译
 2、保存翻译结果，可以用set
 3、计算set的大小即可

 */
public class Result1 {
    private final String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        Arrays.stream(words).forEach(s -> {
            String str = "";
            StringBuilder stringBuilder = new StringBuilder();
            s.chars().forEach(value -> stringBuilder.append(code[value - 'a']));
            System.out.println(stringBuilder);
            set.add(stringBuilder.toString());
        });
        return set.size();
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(result1.uniqueMorseRepresentations(words));
//        result1.uniqueMorseRepresentations();

    }
}
