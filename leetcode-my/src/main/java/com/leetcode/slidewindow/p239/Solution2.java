package com.leetcode.slidewindow.p239;


import java.util.Arrays;

/**
 239. 滑动窗口最大值

 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

 进阶：
 你能在线性时间复杂度内解决此题吗？


 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
  

 提示：

 1 <= nums.length <= 10^5
 -10^4 <= nums[i] <= 10^4
 1 <= k <= nums.length

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sliding-window-maximum

    滑动窗口直接暴力求解
 */

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //窗口大小为k
        int[] res = new int[nums.length-k+1];

        int right;
        for (int left = 0; left < nums.length - k + 1; left++) {
            int max = Integer.MIN_VALUE;
            for (int j = left; j < left+k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[left] = max;
        }

        return res;
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] a =new int[]{1,3,-1,-3,5,3,6,7};
        //[3,3,5,5,6,7]
        Arrays.stream(s.maxSlidingWindow(a, 3)).forEach(System.out::println);
    }
}
