package com.leetcode.others.p700.p740.p748;


/**
 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。

 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。

 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。

 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。

 示例 1：

 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 输出："steps"
 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
  

 示例 2：

 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 输出："pest"
 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
  

 注意:

 牌照（licensePlate）的长度在区域[1, 7]中。
 牌照（licensePlate）将会包含数字、空格、或者字母（大写和小写）。
 单词列表（words）长度在区间 [10, 1000] 中。
 每一个单词 words[i] 都是小写，并且长度在区间 [1, 15] 中。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shortest-completing-word

 思路：
 1.统计licensePlate中各有多少个字母，然后去一个一个匹配words中的词，words中的词也算出有多少个字母。
 licensePlate中每个字母出现的频次。
 words的字母长度要》=licensePlate的字母长度

 Map<字母，次数>
 problem748用了此法

 如果单词中每个字母的计数大于或等于 licenseplate 中的字母数，则该单词是 licensePlate 的完整词。

 2.从words的一个词中移除（替换）对应的字母
 选择了此法

 */
public class Result1 {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        //注意边界条件
        //先筛选出字母
        int[] charsInt = licensePlate.chars().filter(
                value -> (value >= 'A' && value <= 'Z') || (value >= 'a' && value <= 'z')).toArray();
        char[] chars = new char[charsInt.length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) charsInt[i];
        }
//        System.out.println(chars);

        String shortestWord = "";
        int shortestLength = 0;
        String currebtWord = "";
        int currentLength = -1;

        //逐个单词匹配
        for (String str : words) {
            currentLength = str.length();
            if (currentLength < chars.length) {
                continue;
            }
            if (shortestLength > 0 && currentLength >= shortestLength) {
                continue;
            }

            currebtWord = str;
            str = str.toLowerCase();
            //每个单词去匹配,注意大小写要忽略
            String tempStr;

            //匹配每个字母
            int j = 0;
            for (; j < chars.length; j++) {
                tempStr = String.valueOf(chars[j]).toLowerCase();
                if (str.contains(tempStr)) {
                    //要加上str = ，不然后面循环的str不变
                    str = str.replaceFirst(tempStr, "0");
                } else {
                    break;
                }
            }

            //成功匹配
            if (j == chars.length) {
                shortestLength = currentLength;
                shortestWord = currebtWord;
            }

        }
        return shortestWord;
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        System.out.println(result1.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(result1.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
        System.out.println(result1.shortestCompletingWord("Ar16259", new String[]{"nature","though","party","food","any","democratic","building","eat","structure","our"}));
    }
}
