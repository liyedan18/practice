package com.leetcode.array.p000.p040.p042;

/**
 * 42. 接雨水
 *
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 *
 * 思路：
 *      根据图形，从整体看没有什么思路，则从局部来分析。
 *      就像字符串有时候会一个一个字符处理一样。
 *
 *      这里将数组的一位当做一个区域，看数组的每一位上能装多少水，则总的加起来就是要求的能接多少雨水。
 *
 *      数组的每一位能装多少水，根据图形，取决于其左边最高值和右边最高值中较低的那个值。
 *
 *      因此
 *          遍历数组，同时求出左边和右边的最高值，然后取出小的那个，再减去自身高度，就是解果，然后累计结果。
 *
 *      时间复杂度：O(N*N)
 *
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int res = 0;
        //数组两边界肯定能装的都是0，因此去除边界
        for (int i = 1; i < height.length - 1; i++) {

            //计算左边最高值
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            //计算右边最高值
            int rightMax = 0;
            for (int k = height.length - 1; k > i; k--) {
                rightMax = Math.max(rightMax, height[k]);
            }

            if (height[i] >= leftMax || height[i] >= rightMax) {
                //不能装
                continue;
            }

            res = res + Math.min(leftMax, rightMax) - height[i];
        }

        return res;
    }
}
