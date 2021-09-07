package com.leetcode.array.p000.p050.p057;

import java.util.Arrays;

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //已经排好序了，则直接进行判断是否重叠即可
        //分3中情况
        int[][] res = new int[intervals.length + 1][2];
        if (intervals.length == 0) {
            res[0] = newInterval;
            return res;
        }

        int resIndex = 0;
        int interIndex = 0;
        //在插入区间的左边
        while (interIndex < intervals.length && intervals[interIndex][1] < newInterval[0]) {
            res[resIndex] = intervals[interIndex];
            resIndex++;
            interIndex++;
        }

        // 有重合,需要记录重合后的区间
        while (interIndex < intervals.length && newInterval[1] >= intervals[interIndex][0]) {
            newInterval[0] = Math.min(intervals[interIndex][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[interIndex][1], newInterval[1]);
            interIndex++;
        }
        res[resIndex] = newInterval;
        resIndex++;

        //在插入区间的右边
        while (interIndex < intervals.length) {
            res[resIndex] = intervals[interIndex];
            resIndex++;
            interIndex++;
        }

        return Arrays.copyOf(res, resIndex + 1);
    }
}
