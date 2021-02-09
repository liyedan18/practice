package com.leetcode.array.p000.p040.p045;


/**
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 *
 * 思路：
 *
 *      动态规划方法(类似55题的DFS方法)
 *      dp()定义
 *          dp(nums,start)表示从start开始，最少需要多少步才能到达最后一个位置
 *          状态：nums的索引
 *          选择：nums[start]可以跳几步
 *
 *          base case
 *              start>=dp.length-1, 结果是0，也就不需要跳
 *
 *          求dp(nums,0)
 *          加备忘录
 *
 *      如果动态规划+备忘录超出时间限制，则极有可能就是有贪心性质
 *          在动态规划遍历每一个选择时，其实只要确定nums[next]最大的（能走的最远）那个就可以了
 *
 *      只要记录当前这一步和下一步的覆盖范围即可
 *          参考：https://mp.weixin.qq.com/s/kJBcsJ46DKCSjT19pxrNYg
 *
 *      同leetcode-55
 */
public class Solution2 {

    public int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }

        //记录当前索引中nums[i]能达到的最远距离（范围）,从nums[0]开始，i>=1则最少要走一步
        int curDistance = nums[0];
        //下一个索引中nums[i]能达到的最远距离（范围）
        int nextDistance = 0;

        //从nums[0]开始，i>=1则最少要走一步
        int res = 1;

        //如果curDistance达到了最后一个位置，则退出循环.考虑nums[0]就直接覆盖最后一个位置的情况
        if (curDistance >= length - 1) {
            return res;
        }

        //遍历所有
        for (int i = 0; i < length; i++) {
            nextDistance = Math.max(i + nums[i], nextDistance);
            //如果当前索引==最远距离对应的索引，则会进入下一个最远覆盖范围，需要步数+1
            if (curDistance == i) {
                res++;
                curDistance = nextDistance;
                //如果curDistance达到了最后一个位置，则退出循环
                if (curDistance >= length - 1) {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        // System.out.println(s.jump(new int[]{2,3,1,1,4}));
        System.out.println(s.jump(new int[]{1,2}));
    }

}
