package com.leetcode.array.p100.p160.p169;

/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 */
public class Solution {
    public int majorityElement(int[] nums) {
        //假设第一个是多数元素，相同则加1，不同则减1，当小于0时，重新选取当前为多数元素
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res != nums[i]) {
                count--;
                if (count <= 0) {
                    res = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }

        return res;
    }
}
