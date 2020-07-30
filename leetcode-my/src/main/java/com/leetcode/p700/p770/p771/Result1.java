package com.leetcode.p700.p770.p771;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

 J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

 示例 1:

 输入: J = "aA", S = "aAAbbbb"
 输出: 3
 示例 2:

 输入: J = "z", S = "ZZ"
 输出: 0
 注意:

 S 和 J 最多含有50个字母。
  J 中的字符不重复。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/jewels-and-stones

 思路：
 1.都转换为char数组，然后J中的字母匹配S中的字母，并计数。
 可以用双for循环

 */
public class Result1 {
    public int numJewelsInStones(String J, String S) {
        int[] array = J.chars().toArray();
        AtomicInteger count = new AtomicInteger();
        for (int i : array) {
            S.chars().forEach(value -> {
                if (value == i){
                    count.incrementAndGet();
                }
            });
        }
        return count.get();
    }

    public void numJewelsInStones1(String J, String S) {
        //字符串J转换为Set
        Set<Integer> set = J.chars().boxed().collect(Collectors.toCollection(HashSet::new));
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        System.out.println(result1.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(result1.numJewelsInStones("z", "ZZ"));
    }
}
