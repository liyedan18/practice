package com.leetcode.array.p000.p030.p033;

/**
 * 33. 搜索旋转排序数组
 *
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为[4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * 思路：
 *      排序数组 -> 二分搜索
 *
 *      虽然数组经过旋转，但是二分之后，一定有一边是排序树组，因此还是可以用二分搜索查找
 *
 *      如果[l,mid]是排序数组，且nums[l]<=target<=nums[mid]，那就在左边找，否则就去右边找
 *
 *      如果[mid,r]是排序数组，且nums[mid]<=target<=nums[r],那就在右边找，否则去左边找
 *
 *      二分搜索闭区间，边界情况要打补丁。
 *
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;

            }

            /**
             * 对边界情况的处理
             * right>left时，mid不会等于右边界，只可能等于左边界。因此只需要处理左边界
             * 例如：
             *      (7+8)/2=7
             * 如果nums.length==1,则左边界等于右边界
             *
             * mid等于边界时，就一定是边界旁边的两个值之一
             * 如果不相等，则不存在
             */
            if (mid == left) {
                if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            }
            // if (mid == right) {
            //     if (nums[left] == target) {
            //         return left;
            //     } else {
            //         return -1;
            //     }
            // }

            //[l,mid]是排序数组
            if (nums[left] <= nums[mid - 1]) {
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

                //[mid,r]是排序数组
            } else {
                if (nums[mid + 1] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println(s.search(new int[]{3,4,5,6,7,8,1,2},2));
        System.out.println(s.search(new int[]{3,4,5,6,7,8,1,2},3));
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
                //[l,mid]是排序数组
            } else if (mid - 1>=0 && nums[left] <= nums[mid - 1]) {
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

                //[mid,r]是排序数组
            } else if (mid + 1 <= nums.length - 1 && nums[mid + 1] <= nums[right]) {
                if (nums[mid + 1] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

                //越界
            } else if (mid + 1 > nums.length - 1 || mid - 1 < 0) {
                return -1;
            }
        }

        return -1;

    }
}
