package stringcase.p58;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 *
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 *
 * 注意连续多个空格
 */
public class Solution {
    public String reverseWords(String s) {
        if (s.isEmpty()) {
            return "";
        }

        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i > 0; i--) {
            //注意有多个连续空格的情况，会在str中包含""字符串
            if (str[i].isEmpty()) {
                continue;
            }
            sb.append(str[i].trim()).append(" ");
        }
        sb.append(str[0].trim());

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        //会在str中多出两个""
        System.out.println(s.reverseWords("a good   example"));
    }
}
