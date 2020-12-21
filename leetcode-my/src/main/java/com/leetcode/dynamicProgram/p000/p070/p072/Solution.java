package com.leetcode.dynamicProgram.p000.p070.p072;

import java.util.Arrays;

/**
 * 72. 编辑距离
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *  
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 *
 * dp数组定义：
 *      两个字符串的动态规划问题，多是用dp[][]
 *      必须由已计算的数据推导后面的数据
 *      遍历的终点是存储结果的位置
 *
 *      dp(i,j)表示str1[0.。。i]和str2[0.。。j]的最短编辑距离
 *          相等：dp(i,j) = dp(i-1,j-1)
 *          其他：dp(i,j) = min(dp(*,*)) + 1
 *      base case
 *          如果有一个为空，那最短距离就是另一个字符串的长度
 *
 *  可以优化dp[][]
 *  还可以使用递归来自顶向下计算
 */
public class Solution {
    public int minDistance(String word1, String word2) {

        //初始化
        int m = word1.length();
        int n = word2.length();
        //dp数组—— +1 留给空字符
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], 0);
        }

        //base case
        // 如果有一个为空，那最短距离就是另一个字符串的长度
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        //根据状态转移方程迭代计算
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                //字符相等, 则不用做操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不相等，3种操作 插入 删除  替换，选择次数最少的那个
                    //不知道哪个次数最少，那就全都计算一遍，然后比较大小选最小的
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,  //删除
                            Math.min(dp[i][j - 1] + 1,  //插入
                                    dp[i - 1][j - 1] + 1));  //替换、（跳过）
                }

            }
        }

        return dp[m][n];
    }

}