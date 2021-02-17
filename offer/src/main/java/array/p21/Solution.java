package array.p21;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 *
 * 思路：
 *      快慢指针，快指针在前面找奇数，慢指针在后面找偶数，
 *      找到后，交换即可
 */
public class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            //奇数
            if ((nums[fast] & 0x1) == 1) {
                while (slow < fast) {
                    //找到偶数
                    if ((nums[slow] & 0x1) == 0) {
                        int temp = nums[slow];
                        nums[slow] = nums[fast];
                        nums[fast] = temp;
                        break;
                    } else {
                        slow++;
                    }
                }
            }
            fast++;
        }

        return nums;
    }
}
