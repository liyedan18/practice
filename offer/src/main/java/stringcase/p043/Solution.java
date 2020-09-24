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
 * 实际最后移动的位数=左移的位数%字符串长度
 * 把字符串以实际移动位数为分界点，切割为两份，然后拼接返回：后半部分＋前半部分
 *
 */
public class Solution {

    public String leftRotateString(String str, int n) {
        if (str == null || str.equals("") || n <= 0){
            return str;
        }

        if (str.length() == 1){
            return str;
        }

        int actualN = n % str.length();
        return  str.substring(actualN, str.length()) + str.substring(0, actualN);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leftRotateString("abcdefg", 2));;
    }
}
