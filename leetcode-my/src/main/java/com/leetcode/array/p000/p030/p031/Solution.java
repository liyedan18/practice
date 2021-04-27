package com.leetcode.array.p000.p030.p031;

/**
 * 31. 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 *
 * 思路：
 *         3遍从后向前遍历
 *         4,5,2,6,3,1
 *         第一次，寻找a[i]<a[i+1]的数字a[i]=2
 *         第2次，寻找a[i]>a[j]的节点a[j]=3
 *         4,5,3,6,2,1
 *         交换i和j对应的数字
 *         4,5,3,1,2,6
 *         第3次，重新排序i后的数字（排序之前，i后的数字已经是降序了，只需双指针对换即可）
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int min = -1;
        int max = -1;
        //1.找到a[i]
        int i = nums.length - 1;
        for (; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                min = nums[i - 1];
                break;
            }
        }
        //如果找不到，则说明已经是最大值了，只需要重新排序整个数组即可
        if (min == -1) {
            reverse(nums, i);
            return;
        }

        //找到a[j]
        int j = nums.length - 1;
        for (; j >= i; j--) {
            if (nums[j] > min) {
                max = nums[j];
                break;
            }
        }
        //找不到a[j]，则说明已经是倒序排列了，只需要重新排列后面的数组即可
        if (max == -1) {
            reverse(nums, i);
            return;
        }

        //交换a[i]和a[j]
        nums[j] = min;
        nums[i - 1] = max;

        //重新排序后面的数组
        reverse(nums, i);
    }

    private void reverse(int[] nums, int left) {
        for (int i = left, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
