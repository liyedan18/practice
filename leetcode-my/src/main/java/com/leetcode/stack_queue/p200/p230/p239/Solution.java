package com.leetcode.stack_queue.p200.p230.p239;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 *
 * 思路：
 *      构造单调队列求解
 *      提供添加到队尾、记录最大值、删除队尾元素3个方法
 *
 *      时间复杂度：O(n)
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        //滑动窗口
        MonotonicQueue window = new MonotonicQueue();

        for (int i = 0; i <= nums.length - 1; i++) {
            //先把前k-1个元素凑够
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                //窗口向前移动
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }

        return res;
    }
}

/**
 * 单调队列
 * 提供添加到队尾、记录最大值、删除队尾元素3个方法
 */
class MonotonicQueue{
    // private Deque<Integer> deque = new LinkedList<>();
    private LinkedList<Integer> deque = new LinkedList<>();

    public int max(){
        return deque.getFirst();
    }

    /**
     * 添加到队尾，并删除比新增元素小的值
     */
    public void push(int element){
        //这里不能用<=，也就是相同的值也可以放进去。不然滑动窗口有相同的最大值时，只能保留一个，会有问题
        while (!deque.isEmpty() && deque.getLast() < element) {
            //删除队尾
            deque.removeLast();
        }

        deque.add(element);
    }

    /**
     * 删除队头元素
     */
    public void pop(int element) {
        if (!deque.isEmpty() && element == deque.getFirst()) {
            deque.removeFirst();
        }
    }
}
