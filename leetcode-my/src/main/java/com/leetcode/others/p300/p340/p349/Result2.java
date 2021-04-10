package com.leetcode.others.p300.p340.p349;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 给定两个数组，编写一个函数来计算它们的交集。

 示例 1：

 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2]
 示例 2：

 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出：[9,4]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 */
public class Result2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(HashSet::new));
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(HashSet::new));
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Result2 result1 = new Result2();
        int[] a = result1.intersection(new int[]{1,2,2,1},new int[]{2,2});
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("===========");
        int[] b = result1.intersection(new int[]{4,9,5},new int[]{9,4,9,8,4});
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
