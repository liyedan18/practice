package array.p45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 *
 * 思路：
 *      题意是其实是字符串排序
 *      比较(xy)和(yx)拼接后的大小即可
 *      直接比较字符串(xy)和(yx)或者用内置比较方法
 *
 */
class Solution2 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        // Arrays.sort(str, (x,y)-> (x+y).compareTo(y+x));
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = o1.length() + o2.length();
                String temp1 = o1 + o2;
                String temp2 = o2 + o1;
                for (int i = 0; i < length; i++) {
                    if (temp1.charAt(i) != temp2.charAt(i)) {
                        return temp1.charAt(i) - temp2.charAt(i);
                    }
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }

}