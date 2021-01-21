package com.leetcode.bfs_dfs.p700.p773;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 773. 滑动谜题
 *
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用0来表示.
 *
 * 一次移动定义为选择0与一个相邻的数字（上下左右）进行交换.
 *
 * 最终当板board的结果是[[1,2,3],[4,5,0]]谜板被解开。
 *
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 *
 * board是一个如上所述的 2 x 3 的数组.
 * board[i][j]是一个[0, 1, 2, 3, 4, 5]的排列.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 *
 * 思路：
 *      最少多少次可以解开，也就是最小路径，要想到BFS（二叉树层序遍历）
 *      BFS处理的问题：
 *          从start开始，经过最少多少步可以到达target
 *          也是暴力穷举，然后找到最优解
 *
 *      将问题转化为BFS问题：
 *          1.怎么转化为BFS
 *              1）也就是0能和周围相邻的多少个数字交换，有上下左右选择，遍历穷举
 *          2.问题是二维数组，怎么确定start和target
 *              将二维数组展成一维字符串就好比较了。
 *              start就是给定的值，target就是结果"123450"
 *
 *              展成字符串怎么知道交换那些位置？
 *                  可以记录下来数组和字符串的相邻位置的关系映射Map或list
 *
 */
public class Solution {
    public int slidingPuzzle(int[][] board) {

        String start = "";
        String target = "123450";
        int res = 0;
        StringBuilder sb = new StringBuilder();

        //数组和字符串交换位置的关系映射，也是相邻位置的映射关系
        //index表示字符串的位置索引，list.get(index)相对于字符串中的相邻位置有哪些
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 3});  //0
        list.add(new int[]{0, 2, 4});
        list.add(new int[]{1, 5});  //2
        list.add(new int[]{0, 4});
        list.add(new int[]{1, 3, 5});  //4
        list.add(new int[]{2, 4});

        //二维数组转换为字符串
        for (int i = 0; i <= board.length - 1; i++) {
            for (int j = 0; j <= board[i].length - 1; j++) {
                sb.append(board[i][j]);
            }
        }
        start = sb.toString();

        //BFS框架，一次一个节点
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int levelSize = queue.size();

        //去重
        Set<String> visitedSet = new HashSet<>();

        while (!queue.isEmpty()) {
            String temp = queue.poll();
            levelSize--;
            //找到结果
            if (temp.equals(target)){
                return res;
            }

            if (visitedSet.contains(temp)){
                //一层遍历结束
                if (levelSize == 0) {
                    levelSize = queue.size();
                    res++;
                }
                continue;
            }
            visitedSet.add(temp);

            //找到'0'的位置，然后移动
            int index = 0;
            while (temp.charAt(index) != '0') {
                index++;
            }

            //遍历，即移动
            for (int i = 0; i < list.get(index).length; i++) {
                StringBuilder tempsb = new StringBuilder(temp);
                //要交换的位置
                int indexNeedSwap = list.get(index)[i];
                tempsb.setCharAt(index, temp.charAt(indexNeedSwap));
                tempsb.setCharAt(indexNeedSwap, '0');
                if (visitedSet.contains(tempsb.toString())){
                    continue;
                }
                queue.add(tempsb.toString());
            }

            //一层遍历结束
            if (levelSize == 0) {
                levelSize = queue.size();
                res++;
            }

        }

        return -1;

    }

}
