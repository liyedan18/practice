package dynamicProgram.p007;

/**
 * 007 题目描述：
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 *
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 思路：
 * 第n个=第n-1个+第n-2个
 *
 */
public class Solution {

    //递归
    //复杂度1+2+4+8+...+2^(n-1)=2^n-1
    //O(2^n)
/*    public int Fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);

    }*/

    //非递归   第n个等于第n-1个+第n-2个
    //复杂度 O(n)
    public int Fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;

    }

}