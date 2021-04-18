package com.leetcode.array.p000.p010.p011;

/**
 * 11. 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 *
 * 提示：
 *
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * 思路：
 *      数组的双指针技巧
 *      最多的水也就是最大的面积=min(height[right], height[left])*(right-left)
 *      左右指针的位置高度表示宽，左右指针的距离为长
 *      当指针从两边向中间移动时，长会减小1
 *          如果移动短板，则宽可能变大，也可能变小，则面积可能增大也可能变小
 *          如果移动长板，则宽可能不变，也可能变小，则面积一定变小。
 *          因此要移动短板，才可能使得面积增大
 *          复杂度：O(N)
 *
 *      或者暴力解法，左右指针从两边向中间移动，计算所有的面积
 *          复杂度：O(N*N)
 *
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxRes = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                int temp = Math.min(height[right], height[left]) * (right - left);
                maxRes = Math.max(maxRes, temp);
                left++;
            } else {

                int temp = Math.min(height[right], height[left]) * (right - left);
                maxRes = Math.max(maxRes, temp);
                right--;
            }
        }

        return maxRes;
    }
}
