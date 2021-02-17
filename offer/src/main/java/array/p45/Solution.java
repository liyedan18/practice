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
 *      第一版这里将O1和O2单独进行比较，麻烦
 *      且有情况处理不了。
 *
 *      思路2解题思路更优
 *
 */
class Solution {

    /**
     * 版本1： 121 12  麻烦，且这个例子不能通过
     */
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();

                if (len1 == len2) {
                    for (int i = 0; i < len1; i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }

                    return 0;
                }
                //789 7890 7898
                else if (len1 > len2) {
                    for (int i = 0; i < len1; i++) {
                        if (o1.charAt(i) != o2.charAt(i % len2)) {
                            return o1.charAt(i) - o2.charAt(i % len2);
                        }
                    }

                    return len1-len2;
                } else {
                    for (int i = 0; i < len2; i++) {
                        if (o1.charAt(i % len1) != o2.charAt(i)) {
                            return o1.charAt(i % len1) - o2.charAt(i);
                        }
                    }

                    return len1-len2;
                }

            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println(s.minNumber(new int[]{121,12}));
        System.out.println(s.minNumber(new int[]{12,121}));
        System.out.println(12112);

        System.out.println("=====");
        System.out.println(s.minNumber(new int[]{122,12}));
        System.out.println(s.minNumber(new int[]{12,122}));
        System.out.println(12122);

        System.out.println("=====");
        System.out.println(s.minNumber(new int[]{1,2}));
        System.out.println(s.minNumber(new int[]{2,1}));
        System.out.println(12);

        System.out.println("=====");

        System.out.println(s.minNumber(new int[]{8303,830}));
        System.out.println(s.minNumber(new int[]{830,8303}));
        System.out.println(8303830);

        System.out.println("=====");

        System.out.println(s.minNumber(new int[]{830,8309}));
        System.out.println(s.minNumber(new int[]{8309,830}));
        System.out.println(8308309);

        System.out.println("=====");
        System.out.println(s.minNumber(new int[]{8308,830}));
        System.out.println(s.minNumber(new int[]{830,8308}));
        System.out.println(8308308);
        // System.out.println(8308830);
    }
}