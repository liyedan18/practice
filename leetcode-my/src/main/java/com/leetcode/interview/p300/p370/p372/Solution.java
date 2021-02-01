package com.leetcode.interview.p300.p370.p372;

import java.util.LinkedList;

/**
 * 372. 超级次方
 *
 * 你的任务是计算a的b次方对1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *
 *
 * 提示：
 *
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 *
 * 思路：
 *      1.a的b次方如何表示结果
 *          这里的b肯定已经溢出了，又如何计算
 *      2.如何计算取模
 *
 *      数组的性质：
 *          随机访问快，删除最后一个元素快
 *
 *      a的123次方
 *          =a^3 * a^[1,2,0]
 *          =a^3 * (a^[1,2])^10
 *          也就是mypow(a,123)
 *              =mypow(a,3) * (mypow(a,12))的10次方
 *      因此问题的规模被缩小了，a的b次方有递归性质
 *
 *      另外：
 *      a^c = a*a*....*a  c个a相乘
 *      (a*b)%c = (a%c)(b%c)%c
 *      可以通过a = Ac+B b= Dc+K  证明
 *
 *      注意：
 *          a可能开始会很大，所以计算之前，先直接对a取模
 *          (a^b)%k = (a%k * a%k a%k..... )%k
 *
 *      时间复杂度：  O(N)
 *      总结：
 *          递归 + 数组特点 + 取模运算
 */
public class Solution {

    int base = 1337;

    public int superPow(int a, int[] b) {

        //base case, a^0=1
        if (b.length == 0) {
            return 1;
        }

        //将int[]转换为LInkedList,便于应用数组特性
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < b.length; i++) {
            list.add(b[i]);
        }

        return superPowHelper(a, list);
    }

    private int superPowHelper(int a, LinkedList<Integer> list) {

        //base case
        if (list.isEmpty()){
            return 1;
        }

        int last = list.removeLast();
        int resA = myPow(a, last);

        int temp = superPowHelper(a, list);
        int resB = myPow(temp, 10);

        return (resA * resB) % base;
    }

    /**
     * 求a^k对base取模的结果
     */
    private int myPow(int a, int k) {
        if (k == 0) {
            return 1;
        }

        /**
         * 先把a对base取余,重要，防止后面溢出
         */
        a = a % base;

        int res = 1;
        for (int i = 0; i < k; i++) {
            res = res * a;
            res = res % base;
        }

        return res;
    }
}
