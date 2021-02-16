package array.p04;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 *
 * 给定target=20，返回false。
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *
 * 思路：
 *
 *      每遍历一次，一定要能缩小问题规模
 *      暴力解法可以，复杂度O(M*N)
 *      或者用M次二分法，复杂度O(M*logN)
 *
 *      或者根据此数组特点，从左上角，右上角，左下角，右下角4个方向考虑
 *          左上角和右下角遍历不能缩小问题规模，不选
 *          从右上角向左遍历，如果target大于num[i,j]则向下移动1行，且本行左边的都不符合要求
 *              如果target小于num[i,j]，则向左移动1列，且本行下面的都不符合要求
 *
 *              时间复杂度：O(M+N)
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (target == matrix[0][i]) {
                    return true;
                }
            }

            return false;
        }

        for (int i = 0, j = matrix[0].length - 1; i <= matrix.length - 1 && j >= 0; ) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                //左移一列
                j--;
            } else {
                //下移一行
                i++;
            }
        }

        return false;
    }
}
