package com.leetcode.bfs_dfs.island.p463;

/**
 * 463. 岛屿的周长
 *
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 示例 1：
 *
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 *
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0]]
 * 输出：4
 *  
 *
 * 提示：
 *
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 *
 * 思路：
 *      直接数学计算法
 *      判断每个陆地，上下左右如果是边界或者水，则边界+1
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //直接数学计算法
        //判断每个陆地，上下左右如果是边界或者水，则边界+1
        int maxLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //上
                    if (i - 1 < 0 || grid[i - 1][j] == 0) {
                        maxLength++;
                    }
                    //下
                    if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
                        maxLength++;
                    }
                    //左
                    if (j - 1 < 0 || grid[i][j - 1] == 0) {
                        maxLength++;
                    }
                    //右
                    if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) {
                        maxLength++;
                    }
                }
            }
        }

        return maxLength;
    }
}
