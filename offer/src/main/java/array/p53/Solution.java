package array.p53;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 *
 * 思路：
 *      已经排序，用二分法
 *      如果num[right]-nums[mid]==right-mid,则在左边，否则在右边
 *      最后left=mid时，判断结果
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length - 1 == nums[nums.length - 1]) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (left == mid) {
                if (nums[left] == left) {
                    return left + 1;
                } else {
                    return left;
                }
            }
            int temp = nums[right] - nums[mid];
            int diff = right - mid;
            if (temp == diff) {
                //注意
                right = mid;
            } else {
                //注意
                left = mid;
            }
        }

        return left;
    }

}
