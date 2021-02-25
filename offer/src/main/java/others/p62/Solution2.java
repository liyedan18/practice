package others.p62;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 *
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出:3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出:2
 *
 *
 * 限制：
 *
 * 1 <= n<= 10^5
 * 1 <= m <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 *
 * 思路：
 *
 *      查找的同时，还要删除
 *      循环，可以考虑用两层复制，如
 *          0,1,2,3,4,0,1,2,3,4
 *
 *      采用数学法
 *      该问题有递归的特性
 *          循环删除第m个
 *          f(n,m)表示最后留下的数字的位置
 *          f(n-1,m)=x则是n-1个数字，每次删除第m个后留下的数字的位置是x
 *          找出f(n,m)与f(n-1,m)的关系
 *          那么
 *              对于n个数字来说，删除一个就变成了n-1个，删除的是(m-1)%n的位置，下一个要删除的位置就是
 *              (m-1)%n + x ，那留下来的就是((m-1)%n + x + 1)%n
 *
 *          f(n,m)=((m-1)%n + x + 1)%n=(m+x)%n
 *
 *      理解到递归的思想就好
 */
public class Solution2 {
    public int lastRemaining(int n, int m) {
        if (m == 1) {
            return n - 1;
        }

        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }

        int x = f(n - 1, m);
        return (m + x) % n;
    }
}
