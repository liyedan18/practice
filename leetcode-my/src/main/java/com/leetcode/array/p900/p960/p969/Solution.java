package com.leetcode.array.p900.p960.p969;

import java.util.LinkedList;
import java.util.List;

/**
 * 969. 煎饼排序
 *
 * 给定数组A，我们可以对其进行煎饼翻转：我们选择一些正整数k<= A.length，然后反转 A 的前 k个元素的顺序。
 * 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 *
 * 返回能使A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在10 * A.length 范围内的有效答案都将被判断为正确。
 *
 * 示例 1：
 *
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 A = [3, 2, 4, 1]
 * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
 * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
 * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
 * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如[3，3]，也将被接受。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * A[i] 是[1, 2, ..., A.length]的排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pancake-sorting
 *
 * 思路：
 *      类似k个一组翻转链表，有递归思想
 *
 *      先找到最大的那个饼A，（记录位置）然后翻到最上面，（再记录位置），最后翻到最底下。
 *      那么，只需要继续翻转剩下的n-1个即可，也就是递归调用上面的翻饼操作。
 *      能逐步减小问题规模
 *
 *      base case
 *          n ==1,不需要翻转
 *
 *      时间复杂度：
 *          每一次递归复杂度：O(N)
 *          递归次数：N次
 *          总复杂度：O(N)*N = O(N*N)
 *
 *      当然，这样肯定不是最优解
 *      如果要求最少的翻转次数，怎么办？
 *          回溯算法，求所有的值，然后再求出最优解。
 *
 */
public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        return sort(arr, arr.length);
    }

    /**
     * 针对前n个烧饼，把最大的烧饼翻到位置n
     *
     * @param arr arr
     * @param n   前n个烧饼
     * @return 要翻得位置
     */
    private List<Integer> sort(int[] arr, int n) {
        List<Integer> res = new LinkedList<>();

        //base case
        if (n <= 1) {
            return res;
        }

        //找到最大值和索引
        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }

        //翻转到最上面
        res.add(index + 1);
        reverse(arr, 0, index);

        //翻转到位置n(也就是最下面)
        res.add(n);
        reverse(arr, 0, n - 1);

        //递归处理剩下n-1个烧饼
        res.addAll(sort(arr, n - 1));

        return res;
    }

    /**
     * 翻转start到end
     */
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
