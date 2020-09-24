package stringcase.p043;


/**
 * 043  循环左移字符串（左旋转）
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&&tqId=11196&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路1：
 * 算法
 *
 *
 * 思路2：
 * 字符串翻转
 * 实际最后移动的位数=左移的位数%字符串长度
 * YX = (X'Y')'
 * 转换为字符串，以n为中点分段，左边段做翻转，右边做翻转，然后再整体翻转.
 * 也就是3次翻转
 *
 */
public class Solution2 {

    public String leftRotateString(String str, int n) {
        if (str == null || str.equals("") || n <= 0) {
            return str;
        }

        if (str.length() == 1) {
            return str;
        }

        int actualN = n % str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, actualN - 1);
        reverse(chars, actualN, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.leftRotateString("abcdefg", 2));
    }
}
