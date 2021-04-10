package com.leetcode.others.p700.p720.p724;


/**
 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

 示例 1：

 输入：
 nums = [1, 7, 3, 6, 5, 6]
 输出：3
 解释：
 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 同时, 3 也是第一个符合要求的中心索引。
 示例 2：

 输入：
 nums = [1, 2, 3]
 输出：-1
 解释：
 数组中不存在满足此条件的中心索引。
  
 说明：

 nums 的长度范围为 [0, 10000]。
 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-pivot-index

  解题：从i两侧开始加，然后判断两边是否相等
 当前解法太low了
 */
public class Result1 {
    public int pivotIndex(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 1;
        }
        int tempLeft = 0;
        int tempRight = 0;
        int i = 0;
        for (; i <= nums.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                tempLeft += nums[j];
            }
            for (int k = i + 1; k <= nums.length - 1; k++) {
                tempRight += nums[k];
            }
            if (tempLeft == tempRight) {
                return i;
            }
            tempLeft = 0;
            tempRight = 0;
        }

        return -1;
    }

    public static void main(String[] args) {
        Result1 result1 = new Result1();
        System.out.println(result1.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(result1.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(result1.pivotIndex(new int[]{-1,-1,-1,0,1,1}));
    }
}
