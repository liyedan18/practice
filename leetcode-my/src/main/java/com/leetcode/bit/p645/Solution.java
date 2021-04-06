package com.leetcode.bit.p645;

import java.util.Arrays;

/**
 * 645. 错误的集合
 *
 * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 *
 * 思路：
 *      用额外的数组存放所有的数据
 *      初始化为0，存放时，看是否重复
 *      存放后，找到位置为0的即是缺失的数据
 *
 *      时间复杂度：O(N)
 *      空间复杂度：O(N)
 *
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] temp = new int[nums.length];
        Arrays.fill(temp, 0);

        //重复数据
        int a = 0;
        //缺失数据
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i] - 1] != 0) {
                a = temp[nums[i] - 1];
            }
            temp[nums[i] - 1] = nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                b = i + 1;
                break;
            }
        }

        return new int[]{a, b};
    }
}
