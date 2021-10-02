package com.leetcode.array.p100.p120.p128;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        //要求时间复杂度为O(N),则不能使用排序
        //降低时间复杂度，一般就是用空间换时间
        //可以考虑用set,还需要一点数学技巧
        //用set存储数组元素
        //****以num开头的连续序列，则num+1,...+n都在set中存在，可以逐一判断是否存在，然后计算长度
        //****以num开头的连续序列，num-1一定不存在在set中，否则就是以num-1开头的序列。num-1存在就跳过
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int temp = num;
                int singleCount = 0;
                while (set.contains(temp)) {
                    singleCount++;
                    temp++;
                }
                res = Math.max(res, singleCount);
            }
        }

        return res;
    }
}
