package com.leetcode.array.p000.p080.p088;

/**
 * 88. 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 *  思路：
 *      从后向前比较，只需一次遍历即可，并放入合适位置
 *      这也是双指针方法的一种（逆向双指针）
 *      时间复杂度：O(N)
 *      空间复杂度：O(1)
 *
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] < nums2[n]) {
                    nums1[i] = nums2[n];
                    n--;
                } else {
                    nums1[i] = nums1[m];
                    m--;
                }
            } else if (n >= 0) {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }
}
