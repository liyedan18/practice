package array.p03;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * 思路：
 *      方式2：用set集合
 *      方式3：
 *          直接在原地修改
 *          如果nums[i]==i，则跳过i，继续遍历
 *         交换nums[i]与nums[nums[i]]的元素。如果nums[nums[i]]=i说明是重复元素
 *         时间复杂度：O(N)   空间复杂度：O(1)
 */
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }

            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;

            //下面这样不行，这样nums[nums[i]]已经在第2步改变了
            // nums[i]=nums[nums[i]];  2
            // nums[nums[i]]=temp;  3
        }

        return -1;
    }
}
