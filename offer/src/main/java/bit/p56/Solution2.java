package bit.p56;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 *
 * 思路：
 *      方法1.用Map计数，再找到只出现一次的数据
 *          时间复杂度：O(N)
 *          空间复杂的：O(N)
 *      方法2.先排序，然后比较相邻位置是否相等
 *          时间复杂度：O(NlogN)  排序的时间复杂度高
 *          空间复杂的：O(1)
 *      方法3.利用位运算
 *          int数据是32位，将所有数字的二进制做&运算，count数组
 *          那么遍历32位，count[i]%3!=0的对应位i则是属于只出现一次的数字
 *          再将所有的位数拼接起来得出结果
 *          时间复杂度：O(N)
 *          空间复杂的：O(32)=O(1)
 *
 *      进阶：
 *          如果改为count[i] % n !=0
 *          那就可以计算一个数只出现一次，而其他的数出现n次的情况
 */
public class Solution2 {
    public int singleNumber(int[] nums) {

        int[] count = new int[32];
        Arrays.fill(count, 0);

        //统计所有二进制位中1的个数
        int bit = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                /**
                 * 这样写法不行，bit & nums[i]的结果不是1，而是所有位&的结果
                 */
                // count[j] += (bit & nums[i]);
                // bit<<=1;

                //转换为右移nums[i],这样每次都是计算最低位，结果是1或0
                count[j] += (bit & nums[i]);
                nums[i] >>>= 1;
            }
        }

        //拼接只出现一次的数
        int res = 0;
        int bit1 = 1;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                res |= bit1;
            }
            bit1 <<= 1;
        }

        return res;
    }
}
