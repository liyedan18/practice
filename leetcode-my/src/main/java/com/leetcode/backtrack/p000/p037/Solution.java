package com.leetcode.backtrack.p000.p037;

/**
 * 37. 解数独
 *
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 * 提示：
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 *
 *
 * 思路：
 *      同全排列、N皇后问题类似，穷举所有选择确定答案
 *      用回溯算法,(属于DFS，深度优先遍历)
 *
 *      先套用回溯算法框架，然后细化
 *      包括：base case，结束条件，选择如何去重（判断是否有效）
 *
 *      只有唯一解，则找到就返回
 *
 *      时间复杂度：O(9的M次方)，M是空格的个数
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        backTrack1(board, 0, 0);
    }

    /**
     * 回溯算法框架,对每一个board[i][j]穷举
     * 选择是每一个空格的1到9，而不是哪一行r哪一列c
     * void改为返回boolean，找到一组则返回
     *
     * @param board board
     * @param i     当前行
     * @param j     当前列
     */
    private boolean backTrack1(char[][] board, int i, int j) {

        int r = 9;
        int c = 9;

        //满足条件

        //进行下一行
        if (j == c) {
            return backTrack1(board, i + 1, 0);
        }

        //结束条件
        if (i == r){
            return true;
        }

        //base case,不是空格,进行下一列
        if (board[i][j] != '.'){
            return backTrack1(board, i, j+1);
        }

        //遍历选择
        for (char tempCh = '1'; tempCh <= '9'; tempCh++) {

            //选择去重（去除无效选择）
            if (!isValid(board, tempCh, i, j)) {
                continue;
            }

            //做选择
            board[i][j] = tempCh;

            //进行这一行的下一列
            // backTrack1(board, i, j+1);  //这里不能直接调用，而是确定返回值，为true找到可行解则返回.否则会撤销变为'.'
            if (backTrack1(board, i, j + 1)) {
                return true;
            }

            //撤销选择
            board[i][j] = '.';
        }

        return false;
    }

    /**
     * 判断c是否有效
     */
    private boolean isValid(char[][] board, char c, int i, int j){

        for (int k = 0; k < 9; k++) {
            //行有重复
            if (board[i][k] == c){
                return false;
            }
            //列有重复
            if (board[k][j] == c){
                return false;
            }
        }

        //9宫格有重复
        for (int k = 0; k <= 2; k++) {
            //第一列
            if (board[i / 3 * 3 + k][j / 3 * 3] == c) {
                return false;
            }
            //第二列
            if (board[i / 3 * 3 + k][j / 3 * 3 + 1] == c) {
                return false;
            }
            //第3列
            if (board[i / 3 * 3 + k][j / 3 * 3 + 2] == c) {
                return false;
            }
        }

        return true;
    }


    /**
     * 第一版
     * 回溯算法框架,对每一个board[i][j]穷举
     * 选择是每一个空格的1到9，而不是哪一行r哪一列c
     *
     * @param board board
     * @param i     当前行
     * @param j     当前列
     */
    private void backTrack(char[][] board, int i, int j) {

        int r = 9;
        int c = 9;

        //满足条件

        //进行下一行
        if (j == c) {
            backTrack(board, i + 1, 0);
            return;
        }

        //结束条件
        if (i == r){
            return;
        }

        //遍历选择
        for (char tempCh = '1'; tempCh <= '9'; tempCh++) {

            //选择去重（去除无效选择）
            if (!isValid(board, tempCh, i, j)){
                continue;
            }

            //做选择
            board[i][j] = tempCh;

            //进行这一行的下一列
            backTrack(board, i, j+1);

            //撤销选择
            board[i][j] = '.';
        }

    }

}
