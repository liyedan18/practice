package com.leetcode.dynamicProgram.p400.p490.p494;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号+和-。
 * 对于数组中的任意一个整数，你都可以从+或-中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 *
 * 思路：
 *      回溯算法 + 备忘录去重
 *      选择：
 *          两个：+ -
 *          只有两个选择，相当于二叉树遍历
 *
 *      加备忘录，去除重复计算。
 *      注意这里备忘录的形式，多个变量时，可以组成字符串作为key来设置备忘录
 */
public class Solution2 {
    private int res;
    //备忘录， <"index,currentSum" , res>
    private Map<String, Integer> note = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {

        res = 0;
        backTrack(nums, 0, 0, S);
        return res;
    }

    /**
     * 回溯算法框架,N叉树的遍历
     * 定义：返回index ,currentSum对应的结果
     */
    private int backTrack(int[] nums, int index, int currentSum, int target) {
        //结束条件
        if (index == nums.length) {
            //选择符合结果
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = index + "," + currentSum;
        if (note.containsKey(key)) {
            res = note.get(key);
            return res;
        }

        //做选择，选+
        currentSum += nums[index];
        int res1 = backTrack(nums, index + 1, currentSum, target);
        //撤销选择
        currentSum -= nums[index];

        //做选择，选-
        currentSum -= nums[index];
        int res2 = backTrack(nums, index + 1, currentSum, target);
        //撤销选择
        currentSum += nums[index];

        res = res1 + res2;
        note.put(key, res1 + res2);
        return res;
    }
}
