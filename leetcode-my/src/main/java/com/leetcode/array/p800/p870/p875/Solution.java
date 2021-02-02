package com.leetcode.array.p800.p870.p875;

import java.util.Arrays;

/**
 * 875. 爱吃香蕉的珂珂
 *
 * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 *
 * 提示：
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 *
 * 思路：
 *      暴力解法：吃香蕉的最小速度是1，最大速度也就是piles数组一列的最大值。
 *      那么只要从最小值试到最大值，看是否满足题意，找到最小的满足题意的值即可
 *
 *      数组piles数据较大时，超出时间限制
 *
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {

        //寻找piles的最大值
        int max = Arrays.stream(piles).max().getAsInt();

        //从最小值到最大值遍历，找到合适的值即返回
        for (int i = 1; i < max; i++) {
            if (isMeetSpeed(piles, H, i)){
                return i;
            }
        }

        //找不到，则返回最大值
        return max;
    }

    /**
     * 判断index速度时，能否吃完香蕉
     */
    private boolean isMeetSpeed(int[] piles, int H, int index){
        //吃的总时间
        int hours = 0;
        for (int n : piles) {
            //判断吃完n需要几个小时
            int temp = n / index;
            if (n % index > 0) {
                temp += 1;
            }
            hours += temp;

            if (hours > H) {
                return false;
            }
        }

        return true;
    }
}
