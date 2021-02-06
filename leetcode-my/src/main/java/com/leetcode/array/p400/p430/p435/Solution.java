package com.leetcode.array.p400.p430.p435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 *
 * 思路：
 *      找到最多互不重叠的区间个数也就知道了结果
 *
 *      贪心算法：通过局部最优，一步一步更新全局最优
 *      如何找最多互不重叠的区间：
 *          1.把所有区间按照end从小到大排序
 *          2.按顺序，把和end相交的区间删除
 *              相交，也就是下一个区间的start<上一个区间的end
 *          3.重复2，直到最后一个区间
 *
 *
 *      同leetcode-452
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - findMostIntervals(intervals);
    }

    /**
     * 找到最多互不重叠的区间，返回其个数
     */
    private int findMostIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }

        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //[1]即为end
                return o1[1] - o2[1];
            }
        });

        //去除重叠区间
        //初始值
        int end = intervals[0][1];
        //保存总共有几个不重叠区间,初始为1,最少有一个
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            //[0]为start
            if (intervals[i][0] >= end) {
                res++;
                end = intervals[i][1];
            }
        }

        return res;
    }

}
