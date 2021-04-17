package com.leetcode.string.p000.p000.p006;

import java.util.LinkedList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 *
 * 思路：
 *      用num个list（linkedlist）表示排列后的字母
 *      然后遍历字符串，按情况把字符串分配到list，最后拼接即可。
 *
 */
public class Solution {
    public String convert(String s, int numRows) {
        List<Character>[] listArr = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            listArr[i] = new LinkedList<>();
        }
        int row = 0;
        //表示方向向下true，向上false
        boolean flag = true;
        for (char c : s.toCharArray()) {
            //将字符串添加到listArr的对应位置
            if (flag) {
                listArr[row].add(c);
                row++;
                //方向开始向上
                if (row == numRows) {
                    flag = false;
                    row = numRows - 2;
                    if (row <= 0) {
                        row = 0;
                    }
                }
            } else {
                listArr[row].add(c);
                row--;
                if (row == -1) {
                    flag = true;
                    row = 1;
                    if (numRows == 1) {
                        row = 0;
                    }
                }
            }
        }

        //拼接结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            listArr[i].forEach(sb::append);
        }

        return sb.toString();
    }
}
