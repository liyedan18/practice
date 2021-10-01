package com.leetcode.dynamicProgram.p000.p060.p064;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *  
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 *
 *  dfs/回溯算法会超时
 */
public class Solution {
    private static int res;

    public int minPathSum(int[][] grid) {
        //dfs或回溯算法，左上角到右下角路径最短
        res = Integer.MAX_VALUE;
        dfs(grid, 0, 0, 0);
        return res;
    }

    private void dfs(int[][] grid, int i, int j, int curPath) {
        //超出边界
        if (i >= grid.length || j >= grid[0].length) {
            return;
        }
        //剪枝
        if (curPath > res) {
            return;
        }
        curPath += grid[i][j];
        //满足条件
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            res = Math.min(res, curPath);
            return;
        }
        //超出边界
        //遍历所有情况
        dfs(grid, i + 1, j, curPath);
        dfs(grid, i, j + 1, curPath);
        curPath -= grid[i][j];
    }
}