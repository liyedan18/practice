package com.leetcode.array.nSum.p018;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，
 * 使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 *
 * 思路：
 *      target，如果已知a，那么另外三个就是target-a，变成了三数之和。
 *      三数之和又可以套用两数之和解决
 *      四数之和 -> 三数之和 -> 两数之和
 *
 *      用递归解决
 *      base case:
 *          两数之和
 *
 *      先排序，才能利用双指针技巧，才好跳过重复值
 *
 *      也就是：
 *          排序 + 穷举第一个值 + 递归处理 + 去重
 *
 *      时间复杂度：O(N*N*N) = 排序：O(NlogN) + O(N*N*N)
 *
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        //排序
        Arrays.sort(nums);
        return nSumTarget(nums, target, 0, 4);
    }

    /**
     * 计算target数之和组合的结果
     *
     * @param nums   升序数组
     * @param target target
     * @return 不重复的组合结果
     */
    private List<List<Integer>> nSumTarget(int[] nums, int target, int start, int nSum) {
        List<List<Integer>> res = new LinkedList<>();

        //base case，两数之和
        if (nSum < 2 || start >= nums.length) {
            return res;
        }
        if (nSum == 2) {

            for (int i = start, j = nums.length - 1; i < j; ) {
                int left = nums[i];
                int right = nums[j];
                int tempSum = left + right;

                if (target == tempSum) {
                    List<Integer> singleRes = new LinkedList<>();
                    singleRes.add(left);
                    singleRes.add(right);
                    res.add(singleRes);

                    //去重，并更新
                    while (i < j && left == nums[i]) {
                        i++;
                    }
                    while (i < j && right == nums[j]) {
                        j--;
                    }

                } else if (target < tempSum) {
                    //tempSum大了，右边左移
                    while (i < j && right == nums[j]) {
                        j--;
                    }
                } else {
                    //tempSum小了，左边右移
                    while (i < j && left == nums[i]) {
                        i++;
                    }
                }
            }

        } else {

            //多数之和，先穷举第一个数，然后递归调用(n-1)sum
            for (int i = start; i < nums.length; i++) {

                List<List<Integer>> resMoreSum = nSumTarget(nums, target - nums[i], i + 1, nSum - 1);
                if (!resMoreSum.isEmpty()) {
                    int first = nums[i];
                    resMoreSum.forEach(list -> list.add(first));
                    res.addAll(resMoreSum);
                }

                //去重,并更新i
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }

        }

        return res;
    }

}
