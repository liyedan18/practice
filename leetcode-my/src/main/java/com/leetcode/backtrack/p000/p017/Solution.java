package com.leetcode.backtrack.p000.p017;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * 思路：
 *      1.将数字区分开，
 *      2.找到数字对应的字母，
 *      3.全排列所有情况，并加入list中（回溯算法）
 *
 */
public class Solution {
    static final Map<Character, Character[]> map = new HashMap<>();

    static {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }

        //1.将数字区分开，
        char[] digitChar = digits.toCharArray();

        backTrack(digitChar, 0, new StringBuilder(), res);

        return res;
    }

    private void backTrack(char[] digitChar, int indexDigit, StringBuilder singleSb, List<String> res) {
        //结束条件
        if (indexDigit >= digitChar.length && singleSb.length() == digitChar.length) {
            res.add(singleSb.toString());
            return;
        }

        //遍历数字
        for (int i = indexDigit; i < digitChar.length; i++) {
            //遍历字符
            for (int j = 0; j < map.get(digitChar[i]).length; j++) {
                //做选择
                singleSb.append(map.get(digitChar[i])[j]);

                backTrack(digitChar, i + 1, singleSb, res);

                //取消选择
                singleSb.deleteCharAt(singleSb.length() - 1);
            }
        }
    }
}
