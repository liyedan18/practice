package com.leetcode.array.p000.p030.p036;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 *
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *  
 *
 * 示例 1：
 *
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 *
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *  
 *
 * 提示：
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 *
 * 思路：
 *      数据结构 + 不同情况分析
 *      算法题不要怕麻烦，一步一步想清楚去做就好。
 *      这个题做的真是难受
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //记录行
        Set<Character>[] rowSet = new Set[9];
        //记录列
        Set<Character>[] colSet = new Set[9];
        //记录方框
        Set<Character>[] kSet = new Set[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            kSet[i] = new HashSet<Character>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] > '9' || board[r][c] < '0') {
                    continue;
                }

                if (rowSet[r].contains(board[r][c])) {
                    return false;
                }
                rowSet[r].add(board[r][c]);

                if (colSet[c].contains(board[r][c])) {
                    return false;
                }
                colSet[c].add(board[r][c]);

                int index = r / 3 + 3 * (c / 3);
                if (kSet[index].contains(board[r][c])) {
                    return false;
                }
                kSet[index].add(board[r][c]);
            }
        }

        return true;
    }
}
