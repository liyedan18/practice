package com.leetcode.array.nSum.p001;

import java.util.HashMap;
import java.util.Map;

/**
 * 22. 括号生成
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * 思路：
 *      一种是用暴力解法，两个for循环，时间复杂度O(N*N)
 *      一种用空间换时间，只需遍历一次即可，时间复杂度O(N)，但是需要O(N)的空间复杂度存储元素
 *
 */
public class Solution4 {
    public int[] twoSum(int[] nums, int target) {

        //存储<nums[i],i>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            //确保不是同一个数
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{i, map.get(other)};
            }
        }

        return new int[]{-1, -1};
    }
}
