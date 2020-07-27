package com.leetcode.p500.p530.p532;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2:
 * <p>
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3:
 * <p>
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 * <p>
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 * <p>
 * 1.去重
 * 2.取两数差的绝对值和k对比
 * <p>
 *  思路：num+k包含在nums数组中
 */
public class Result3 {
    public int findPairs(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k < 0) {
            return 0;
        }
        AtomicInteger countPairs = new AtomicInteger(0);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(value -> {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        });
        map.keySet().stream().forEach(integer -> {
            if (k == 0) {
                if (map.get(integer) > 1) {
                    countPairs.getAndIncrement();
                }
            } else if (map.containsKey(integer+k)){
                countPairs.getAndIncrement();
            }
        });
        return countPairs.get();

    }

    public static void main(String[] args) {
        Result3 result1 = new Result3();
        System.out.println(result1.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(result1.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(result1.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(result1.findPairs(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 5, 4}, 0));
    }
}
