package array.p39;

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
 *      摩尔投票法：
 *          遇到次数超过一半的数字，票数+1，否则-1，则最终票数>=0
 *
 *          实际在遍历时，设初始票数votes=0，res=nums[0]
 *              当votes=0,时，假设当前遇到的数字是众数，则与这个数字相同票数+1，否则-1.
 *              如果数组前面一部分的票数相加后==0，那么剩余的部分仍然满足票数>=0
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                res = nums[i];
                votes++;
                continue;
            }

            if (res == nums[i]) {
                votes++;
            } else {
                votes--;
            }
        }

        // //如果题目中没说一定存在，则需要验证得到的是否是众数
        // int count=0;
        // for (int num : nums) {
        //     if (num==res){
        //         count++;
        //     }
        // }
        // if (count>nums.length/2){
        //     return res;
        // }

        return res;
    }
}
