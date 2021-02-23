package stringcase.p67;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
 * 作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。
 * 如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
 *
 * 示例1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *     因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 *
 * 思路：
 *      1.丢弃无用的开头空格字符
 *      2.寻找到的第一个非空字符为正或者负号时,表示符号
 *      3.有效的整数部分之后，多余的字符可以直接忽略
 *      4.假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，返回0
 *      5.不能转换，则返回0
 *
 *      先把有用的数字字符串挑出来，然后用parseInt转换即可。
 *
 *      注意更多的细节处理
 *      比如：开头直接是0的情况，应该忽略前面的0
 *
 *      这样处理，虽然思路清晰，但实现起来也确实过于复杂了。有80行代码了，不好。
 */
public class Solution {

    public int strToInt(String str) {
        //1.
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        char[] c = str.toCharArray();
        //4.
        if (c[0] >= 'A') {
            return 0;
        }
        //2.
        if (c[0] == '+' || c[0] == '-') {
            return value(c, 1, c[0]);
        }

        return value(c, 0, '+');
    }

    private int value(char[] c, int start, char sign) {
        StringBuilder sb = new StringBuilder();
        //3.
        //标志是否读到非0的数
        boolean flag = false;
        for (int i = start; i < c.length; i++) {

            //排除0000123的情况
            if (!flag){
                if (c[i] >= '1' && c[i] <= '9') {
                    sb.append(c[i]);
                    flag = true;
                    continue;
                } else if (c[i] == '0') {
                    continue;
                } else {
                    //不是数字，则退出解析循环
                    break;
                }
            }

            if (c[i] >= '0' && c[i] <= '9') {
                sb.append(c[i]);
            } else {
                break;
            }
        }

        String str = sb.toString();
        if (str.isEmpty()) {
            return 0;
        }

        //str是否超出int范围
        String max = String.valueOf(Integer.MAX_VALUE);
        if (str.length() > max.length()) {
            if (sign == '+') {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        //str是否超出int范围
        if (str.length() == max.length()) {
            if (sign == '+' && str.compareTo(max) >= 0) {
                return Integer.MAX_VALUE;
            }
            String min = String.valueOf(Integer.MIN_VALUE).substring(1);
            if (sign == '-' && str.compareTo(min) >= 0) {
                return Integer.MIN_VALUE;
            }
        }

        if (sign == '+') {
            return Integer.parseInt(str);
        }
        return -Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println(s.strToInt("-91283472332"));
        System.out.println(s.strToInt("words and 987"));
        System.out.println(s.strToInt("4193 with words"));
        System.out.println(s.strToInt("   -42"));
        System.out.println(s.strToInt("42"));
        System.out.println(s.strToInt("20000000000000000000"));
        System.out.println(s.strToInt("  0000000000012345678"));
    }
}
