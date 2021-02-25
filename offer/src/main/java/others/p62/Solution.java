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
 *      整体时间复杂度O(N*N)
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        if (m == 1) {
            return n - 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int size = 0;
        int index = 0;
        while ((size = list.size()) > 1) {
            index = (m -1 + index) % size;
            /**
             * 如果使用LinkedList，这里会超时，
             * 因为LinkedList的删除操作虽然复杂度是O(1),但是查找到索引位置时间复杂度是O(N)，因此其删除对应索引的时间复杂度就是O(N)
             * 而ArrayList，这里的将后续元素前移，使用的copyOfRange，是整体前移，所以复杂度更低
             * 勉强通过
             */
            list.remove(index);
        }

        return list.get(0);
    }

}
