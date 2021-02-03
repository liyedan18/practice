package com.leetcode.array.p1100.p1100.p1101;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *
 *
 * 提示：
 *
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 *
 * 思路：
 *      weights不可拆分
 *
 *      暴力解法：
 *          最低载重为max(weights)，也就是至少要能装下一天的货物重量
 *          最大载重为sum(weights)，一次（天）把所有的货物装走
 *          只需要从小大大遍历，然后找到第一个能把所有货物装下的结果即可
 *
 *          这里for (int i = min; i <= max; i++)
 *              可以用二分法优化，用查找左边界的二分法
 *
 *
 *      同leetcode-875
 */
public class Solution {
    public int shipWithinDays(int[] weights, int D) {

        //最小值最大值
        int min = Arrays.stream(weights).max().getAsInt();
        int max = Arrays.stream(weights).sum();

        //查找左边界的二分法
        int left = min;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isMeetDays(weights, D, mid)) {
                right = mid;
            } else {
                //是+1，寻找左边界
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 判断给定载重是否能在D天内装完所有货物
     */
    private boolean isMeetDays(int[] weights, int D, int shipWeight) {
        //至少是1天
        int allDays = 1;
        //已经装的总重量
        int alreadyWeight = 0;

        for (int weight : weights) {
            alreadyWeight += weight;

            //当前已经装不下，则算到下一天
            if (alreadyWeight > shipWeight) {
                allDays++;
                alreadyWeight = weight;
            }

            if (allDays > D) {
                return false;
            }
        }

        return true;
    }

}
