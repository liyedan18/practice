package com.leetcode.array.p1000.p1200.p1288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1288. 删除被覆盖区间
 *
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *  
 *
 * 提示：​​​​​​
 *
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-covered-intervals
 */
public class Solution2 {
    public int removeCoveredIntervals(int[][] intervals) {
        //先排序，然后对比是否有重合，将重合的过滤掉
        if (intervals.length <= 1) {
            return 1;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[] interval = intervals[0];
        int res=1;
        for (int i = 1; i < intervals.length; i++) {
            if ((intervals[i][0] >= interval[0] && intervals[i][1] <= interval[1])
                    || (intervals[i][0] <= interval[0] && intervals[i][1] >= interval[1])) {

                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);

            } else {
                //不相交
                res++;
            }
        }
        return res;
    }

}
