package com.leetcode.string.p000.p010.p012;

/**
 * 12. 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *  
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= num <= 3999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 *
 * 思路：
 *      方式一：
 *          拆解，然后硬编码
 *          这样做，貌似失去了算法的思维和意义
 *
 */
public class Solution {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        //千
        int thousand = num / 1000;
        for (int i = 1; i <= thousand; i++) {
            res.append("M");
        }
        num %= 1000;

        //500 400 900
        int hundred = num / 100;
        if (hundred == 9) {
            res.append("CM");
        } else if (hundred == 4) {
            res.append("CD");
        } else if (hundred == 5) {
            res.append("D");
        } else if (hundred <= 3) {
            for (int i = 1; i <= hundred; i++) {
                res.append("C");
            }
        } else if (6 <= hundred && hundred <= 8) {
            res.append("D");
            res.append("C".repeat(hundred - 5));
        }
        num %= 100;

        //50 40 90
        int ten = num / 10;
        if (ten == 9) {
            res.append("XC");
        } else if (ten == 4) {
            res.append("XL");
        } else if (ten == 5) {
            res.append("L");
        } else if (ten <= 3) {
            for (int i = 1; i <= ten; i++) {
                res.append("X");
            }
        } else if (6 <= ten && ten <= 8) {
            res.append("L");
            // for (int i = 6; i <= ten; i++) {
            //     res.append("X");
            // }
            //将for循环优化优化
            res.append("X".repeat(ten - 5));
        }
        num %= 10;

        //5 4 9
        if (num == 9) {
            res.append("IX");
        } else if (num == 4) {
            res.append("IV");
        } else if (num == 5) {
            res.append("V");
        } else if (num <= 3) {
            for (int i = 1; i <= num; i++) {
                res.append("I");
            }
        } else if (6 <= num && num <= 8) {
            res.append("V");
            // for (int i = 6; i <= num; i++) {
            //     res.append("I");
            // }
            //优化for循环
            res.append("I".repeat(num - 5));
        }


        return res.toString();
    }

}
