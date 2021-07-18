package com.leetcode.binaryTree.p100.p120.p124;

import com.leetcode.binaryTree.TreeNode;

/**
 110. 平衡二叉树

 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

 路径和 是路径中各节点值的总和。

 给你一个二叉树的根节点 root ，返回其 最大路径和 。

 示例 1：

 输入：root = [1,2,3]
 输出：6
 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 示例 2：

 输入：root = [-10,9,20,null,null,15,7]
 输出：42
 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
  
 提示：

 树中节点数目范围是 [1, 3 * 104]
 -1000 <= Node.val <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 */
public class Solution {
    //最大路径和
    private int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        dfs(root);
        return maxPath;
    }

    //方法定义：当前节点能为父节点贡献的最大路径和，
    //也就是root+左子树的最大路径和  或  root+右子树的最大路径和,注意这里的贡献值和最大路径和的区别
    //参考：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        if (left < 0) {
            //如果left小于0，那么左子树的贡献为0，也就是不选择左子树
            left = 0;
        }
        int right = dfs(root.right);
        if (right < 0) {
            right = 0;
        }
        //更新最大路径和
        maxPath = Math.max(maxPath, root.val + left + right);
        //返回能为父节点贡献的路径和（只可能是root+左右子树的一边）
        return root.val + Math.max(left, right);
    }
}
