package array.p39;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 *
 * 思路：
 *      先排序，然后看中间的那个数字是多少
 *
 *      也可以用Map，时间和空间复杂度都是O(N)
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length / 2];
    }
}
