package com.leetcode.array.p000.p000.p001;


import java.util.HashMap;
import java.util.Map;

/**
 1. 两数之和

 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 链接：https://leetcode-cn.com/problems/two-sum

 方法二：
    用Map存储nums中的元素，遍历的同时，到map中查找有无对应（互补，target-nums[i]得到的值）的元素即可。只需一次遍历。
    Map<nums中的元素，元素对应的下标>
    Map中存的相当于是第一个加数，遍历的时候相当于是第二个加数。

    时间复杂度：O(N)
 */

public class Solution2 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            //获取互补的数
            if (map.get(target - nums[i]) != null) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            //不包含互补的数，就把这个数添加到map
            map.put(nums[i], i);
        }

        return res;
    }
}
