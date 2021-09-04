package com.leetcode.array.p000.p050.p056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 *
 * 参考：
 *  https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
 *  属于多个情况的考虑
 */
public class Solution2 {
    public int[][] merge(int[][] intervals) {
        //先对数组排序，按照起始端点排序
        //判断是否有重合
        //从第2个开始，判断start2是否大于等于start1,且start2<=end1，是则有重合
        //再比较end2是否>=end1,取最大的为新的边界
        //思路相同，但是直接在数组中操作，最后再复制数组即可。
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[][] res = new int[intervals.length][2];
        //表示结果数组res的最后一个数组的索引
        int curIndex = 0;
        res[0] = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] <= res[curIndex][1]) {
                //当前数组的起始位置小于res最后一个数组的终止位置，有重叠
                //因为已经排了序，则只需要确定哪个是最大的终止位置即可
                res[curIndex][1] = Math.max(res[curIndex][1], interval[1]);
            } else {
                //没有重叠
                curIndex++;
                res[curIndex] = interval;
            }
        }

        return Arrays.copyOf(res, curIndex + 1);
    }
}
