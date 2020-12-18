package com.leetcode.dynamicProgram.p300.p350.p354;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 *
 * 思路
 *      在300.最长上升子序列上的延伸。先看第300题
 *
 *      这里思路比较巧妙：
 *          排序 + LIS
 *
 *          排序：
 *              对数组第一列进行升序排序，如果遇到相等的，则按第二列逆序排序。
 *              这里逆序就保证了，相等的几个只会有一个被选中加入上升子序列。
 *              然后在第二列上求最长递增子序列即可。
 *
 *          LIS动态规划法：
 *              1.确定dp数组的定义
 *                 dp[i]表示nums[i]的元素的最长上升子序列的长度
 *             2.base case
 *                 dp[0]=1,
 *                 所有数的初始值都是1，最长子序列要算上自己
 *             3.画图推导dp[i](数学归纳法)
 *                画出数组图，假设已经知道了dp[0,1,...,n-1]，怎么推导出dp[i]
 *                   类似递归方法的推导思想
 *                dp[i]=nums中i之前的那些比nums[i]小的长度的最大值 + 1
 *
 *             4.最后返回dp[i]中的最大值
 *
 *          当问题无从下手时，排序一般是一个选择，可以先排序看看，也许会有“柳暗花明”的感觉。
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0){
            return 0;
        }

        //排序
        Arrays.sort(envelopes, new EnveComparator());

        //挑出第二列，进行求LIS
        int[] highs = new int[envelopes.length];
        for (int i = 0; i < highs.length; i++) {
            highs[i] = envelopes[i][1];
        }

        return lengthOfLIS(highs);

    }

    //排序，二维数组升序排列
    class EnveComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
        }
    }

    //最长递增子序列
    private int lengthOfLIS(int[] highs){
        int[] dp = new int[highs.length];
        //base case
        Arrays.fill(dp, 1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (highs[j] < highs[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        //找最大值
        int res = Arrays.stream(dp).max().getAsInt();

        return res;
    }
}
