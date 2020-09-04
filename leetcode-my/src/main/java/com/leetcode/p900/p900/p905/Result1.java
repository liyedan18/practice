package com.leetcode.p900.p900.p905;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

 你可以返回满足此条件的任何数组作为答案。

 示例：

 输入：[3,1,2,4]
 输出：[2,4,3,1]
 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
  
 提示：

 1 <= A.length <= 5000
 0 <= A[i] <= 5000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-array-by-parity

 法一、双指针交换
 法二、两次过滤，然后拼接

 */
public class Result1 {
    public int[] sortArrayByParity(int[] A) {

        List<Integer> list1 = Arrays.stream(A)
                .filter(value -> value % 2 == 0)
//                .mapToObj(Integer::valueOf)    //就相当于.boxed()
                .boxed()
                .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(A)
                .filter(value -> value % 2 != 0)
                .boxed()
                .collect(Collectors.toList());

        list1.addAll(list2);

        return list1.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {

        Result1 result1 = new Result1();
        int[] a = {3,1,2,4};
        Arrays.stream(result1.sortArrayByParity(a)).forEach(System.out::println);

    }
}
