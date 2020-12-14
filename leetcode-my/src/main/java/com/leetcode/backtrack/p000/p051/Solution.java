package com.leetcode.backtrack.p000.p051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 *  
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *  
 * 上图为 8 皇后问题的一种解法。
 *  
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *  
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *  
 * 示例：
 *  
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *  
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 * 提示：
 *  
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *  
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 *
 *
 *   穷举法，解法类似全排列问题
 *      属于回溯算法，在算法（框架）过程穷举过程中找到合适的值
 *      1.路径
 *          已经选过的行和列上的点
 *      2.选择
 *          下一步可选择的行和列的点
 *          先确定行，那么选择就是循环选择列
 *      3.（单次循环）结束条件
 *          本轮已经没有可选择的点
 *
 *      可以画一个4*4的方格，模拟4皇后问题
 *      依次选第一行，第一个列...第一行，第二列...第一行第三列...
 *      先确定行，那么选择就是循环选择列
 *      (1,1),(2,2),(3,3),(4,4)
 *      (1,1),(2,3),(3,2),(4,4)...
 *
 *
 * BTW
 *          //记录单次循环的结果(N叉树根节点的一个分叉遍历结束)
 *         //初始化(相当于初始化了一个二维数组char[][])
 *         这个结构很关键
 *         List<char[]> singleRes = new ArrayList<>();
 */
public class Solution {

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        //记录单次循环的结果(N叉树根节点的一个分叉遍历结束)
        //初始化(相当于初始化了一个二维数组char[][])
        List<char[]> singleRes = new ArrayList<>();
        // List<String> singleRes = new ArrayList<>();  //用char[]更好
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            singleRes.add(c);
        }

        //这里的回溯算法，从0开始，也就是第一行
        backTrack(n, 0, singleRes);
        return res;
    }

    /**
     * 回溯算法框架
     * @param row 当前遍历到第几行
     * @param singleRes 保存遍历的结果
     */
    // private void backTrack(int row, List<char[]> singleRes){
    private void backTrack(int n, int row, List<char[]> singleRes) {
        //结束条件(遍历到最后一行且已经找到一组合适的点)
        if (row == n) {
            List<String> resList = new ArrayList<>();
            //char[]转为String
            singleRes.forEach(chars -> resList.add(new String(chars)));
            res.add(resList);
            return;
        }

        //在循环中做选择(行已经确定了，做选择就是选列)
        for (int col = 0; col < n; col++) {
            //去除不合适的选择
            if (!isValid(n, row, col, singleRes)) {
                continue;
            }

            //做选择
            singleRes.get(row)[col] = 'Q';

            backTrack(n, row + 1, singleRes);

            //撤销选择
            singleRes.get(row)[col] = '.';
        }
    }

    /**
     * 判断当前棋盘位置  singleRes.get(row)[col]  是否有效（彼此不能互相攻击）
     * 任何两个皇后都不能处于同一条横行、纵行或斜线上。
     *
     * 因为之前是依次从上往下一行一行遍历，所以这里只需要判断
     * 这一行（一行只有一个数据，不用判断）、这一列、左上、右上即可。
     * 右下和左下没有数据，不用判断。
     */
    private boolean isValid(int n, int row, int col, List<char[]> singleRes){
        //这一列,只需要比较到第row行即可。下面没有数据
        for (int i = 0; i < row; i++) {
            if (singleRes.get(i)[col] == 'Q'){
                return false;
            }
        }

        //左上
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (singleRes.get(r)[c] == 'Q') {
                return false;
            }
        }

        //右上
        for (int r = row, c = col; r >= 0 && c < n; r--, c++) {
            if (singleRes.get(r)[c] == 'Q') {
                return false;
            }
        }

        return true;
    }

}
