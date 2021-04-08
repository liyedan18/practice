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
 *      先排序，然后找重复数据
 *
 *      时间复杂度：O(NlogN)
 *
 */
public class Solution2 {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        //重复数据
        int a = 0;
        //缺失数据,初始是1
        int b = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                a = nums[i];
            } else {
                if (nums[i] - nums[i - 1] != 1) {
                    b = nums[i - 1] + 1;
                }
            }
        }

        if (nums[nums.length - 1] != nums.length) {
            b = nums.length;
        }

        return new int[]{a, b};
    }
}
