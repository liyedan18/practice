package com.leetcode.array.p100.p170.p179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 *
 * 同offer-45
 */
public class Solution {
    public String largestNumber(int[] nums) {
        //	本质还是无序数组排序问题 同offer-45
        //将数组的数字转换为字符串，然后对字符串排序
        //字符串排序是对每个字符进行比较，排序，从第一个字符开始，字符不同则比较出了字符串的顺序
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (x, y) -> (y + x).compareTo(x + y));
        //同下面的字符串比较方法
        // Arrays.sort(str, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         String str1 = o2 + o1;
        //         String str2 = o1 + o2;
        //         for (int i = 0; i < str1.length() && i < str2.length(); i++) {
        //             if (str1.charAt(i) != str2.charAt(i)) {
        //                 return str1.charAt(i) - str2.charAt(i);
        //             }
        //         }
        //         return 0;
        //     }
        // });
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }

        //排除前导0
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
