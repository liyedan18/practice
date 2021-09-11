package com.leetcode.bfs_dfs.island.p200.p200;

/**
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 *
 * 思路：
 *      dfs
 *      参考：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 *
 */
public class Solution {
    public int numIslands(char[][] grid) {
        //同树和图的遍历问题类似，采用深度优先遍历（回溯算法）
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    res++;
                }
            }
        }

        return res;
    }

    //将遍历过的1都标记成2，表示已经遍历了
    private void dfs(char[][] grid, int i, int j) {
        if (!validate(grid, i, j)) {
            return;
        }

        grid[i][j] = '2';

        //做选择，也就是往4个方向走
        dfs(grid, i - 1, j);  //上
        dfs(grid, i, j + 1);  //右
        dfs(grid, i + 1, j);  //下
        dfs(grid, i, j - 1);  //左
    }

    private boolean validate(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        //不是陆地都返回
        if (grid[i][j] != '1') {
            return false;
        }

        //==1
        return true;
    }
}
