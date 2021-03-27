package bit.p56;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 *
 * 思路：
 *         先排序，然后找——不行，排序的时间复杂度超过O(N)
 *         要用异或运算
 *         所有数字做一次异或，可以得到这两个数字的异或值A
 *         分组的话，将两个数字分到不同的组，那不同组各自异或之后的值，就是要求的两个值
 *         那怎么能将两个数字分到不同组？
 *         上面得到的A就是两个数字的异或值，那么A中所有二进制位中为1的位置就是两个数字的不同位置
 *         由此可以将这两个数字分开，且其他所有的值，相同的两个数字一定会分在同一组。
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {

        //异或值
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        //找res中的一个1，这里取最低位的1
        int value = 0x01;
        while ((value & res) == 0) {
            value <<= 1;
        }

        //分组
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((value & nums[i]) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[]{a, b};
    }
}