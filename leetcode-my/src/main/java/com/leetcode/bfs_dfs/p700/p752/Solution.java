package com.leetcode.bfs_dfs.p700.p752;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 752. 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 *
 *
 * 思路：
 *      问题拆解，由简到全（先考虑最简单情况，确定框架然后丰富算法，向目标前进）
 *      BFS的本质：
 *          在一幅图中，找到由起点start到终点target的最短路径
 *
 *      1.先考虑不加限制条件时，就是直接穷举法
 *      2.一次转动一个位置，则有8种方式（正向4种+反向4种）
 *          可能会有重复的情况，则去除重复情况
 *      3.N叉树（图）的层序遍历,找到target就停止
 *          BFS——二叉树层序遍历(队列)——一次while循环遍历一层节点
 *      同111题
 */

public class Solution {
    public int openLock(String[] deadends, String target) {

        //将deadends存入set，便于查询
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        // Arrays.stream(deadends).forEach(str -> deadSet.add(str));
        // deadSet.addAll(Arrays.asList(deadends));

        if (deadSet.contains("0000")) {
            return -1;
        }
        int lockSize = 4;
        //去除重复的情况，保存已经访问的锁
        Set<String> visited = new HashSet<>();
        //最终结果，表示要旋转的次数
        int step = 0;

        //BFS遍历框架
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        // 一次while循环遍历一层节点
        while (!queue.isEmpty()) {
            int levelNodeSize = queue.size();
            String cur;
            //这里不对，要在for循环之后更新步数
            // step++;

            for (int i = 0; i < levelNodeSize; i++) {
                cur = queue.poll();

                //具体业务：判断当前节点是否满足
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }

                //把与temp相连的节点（也就是temp经过一次转动后所有结果）都添加到队列
                for (int j = 0; j < lockSize; j++) {

                    //上旋
                    String upLockStr = switchUpLock(cur, j);
                    if (!visited.contains(upLockStr)) {
                        visited.add(upLockStr);
                        queue.offer(upLockStr);
                    }

                    //下旋
                    String downLockStr = switchDownLock(cur, j);
                    if (!visited.contains(downLockStr)) {
                        visited.add(downLockStr);
                        queue.offer(downLockStr);
                    }

                }
            }

            /** 层序遍历框架， for循环后更新步数*/
            step++;
        }

        //没有匹配选项
        return -1;
    }

    /**
     * 向上旋转锁i位置后的字符串结果
     */
    private String switchUpLock(String cur, int i) {
        char[] chars = cur.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    /**
     * 向下旋转锁i位置后的字符串结果
     */
    private String switchDownLock(String cur, int i) {
        char[] chars = cur.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

}
