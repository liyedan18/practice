package array.p53;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 *
 * 思路：
 *      先用二分法查找到位置，然后向左边遍历和右边遍历
 *      方法2,二分法求出左边界和右边界
 */
public class Solution {
    public int search(int[] nums, int target) {
        //先用二分法查找到位置，
        //然后向左边遍历和右边遍历
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return 0;
        }

        int index = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[index] != target) {
            return 0;
        }
        int count = 1;
        int temp = index;
        while (--temp >= 0 && nums[temp] == target) {
            count++;
        }
        int rightTemp = index;
        while (++rightTemp <= nums.length - 1 && nums[rightTemp] == target) {
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(s.search(new int[]{1, 4}, 4));
    }

}
