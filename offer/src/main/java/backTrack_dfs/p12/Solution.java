package backTrack_dfs.p12;

/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，
 * 在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 *
 * 思路：
 *      回溯算法（DFS）
 *      以二维数组每一个元素为起点，进行遍历。
 *          关键：
 *              遍历的过程中如果与word不匹配，则立刻终止本次遍历，进行下一次。
 *      选择就是
 *          每个元素的上下左右4个方向
 *          为了避免重复，做选择可以将当前元素置为空''，等撤销选择时，再恢复
 *      满足条件：
 *          与word匹配，也就是长度与word相等
 *      终止条件：
 *          本次与word不匹配，或超出二维数组范围
 *
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backTrack(char[][] board, String word, int i, int j, int curLength) {
        //终止条件
        if (i >= board.length || i < 0
                || j >= board[0].length || j < 0
                || curLength >= word.length()
                || word.charAt(curLength) != board[i][j]) {
            return false;
        }

        //满足条件,到这里时，当前元素已经匹配
        if (curLength >= word.length() - 1) {
            return true;
        }

        //遍历选择，做选择
        board[i][j] = ' ';
        boolean flag = backTrack(board, word, i, j + 1, curLength + 1)  //向右
                || backTrack(board, word, i + 1, j, curLength + 1)  //向下
                || backTrack(board, word, i, j - 1, curLength + 1)  //向左
                || backTrack(board, word, i - 1, j, curLength + 1);  //向上
        board[i][j] = word.charAt(curLength);

        return flag;
    }
}