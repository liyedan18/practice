package com.leetcode.others.p300.p340.p349;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
public class Result1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeatSet = new HashSet<>();
        for (int i: nums1) {
            set.add(i);
        }
        for (int j:nums2) {
            if (set.contains(j)){
                repeatSet.add(j);
            }
        }
        if (repeatSet.size()<=0) {
            return new int[0];
        }
        int[] num=new int[repeatSet.size()];
        int k=0;
        Iterator<Integer> it = repeatSet.iterator();
        while (it.hasNext()){
            num[k]=it.next();
            k++;
        }
        return num;
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
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
