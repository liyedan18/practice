package com.leetcode.binaryTree.p200.p230.p236;


import com.leetcode.binaryTree.TreeNode;

/**

 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 说明:

 所有节点的值都是唯一的。
 p、q 为不同节点且均存在于给定的二叉树中。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree





 递归解决：
 1.明确方法的定义（相信方法的含义往下做，不要试图跳入循环。）
     ——这里可以根据定义的各种情况，判断出递归的停止条件
 2.确定方法参数的变量是什么
 3.拿到递归结果要干什么

 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        //只要遇到了p或者q，则一定是祖先的备选结果
        if (root == p || root == q) {
            return root;
        }

        //获取到最近公共祖先
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        //如果左右两个子树都不为null,说明当前root就是最近公共祖先
        if (leftAncestor != null && rightAncestor != null) {
            return root;
        }

        //如果左子树leftAncestor=p或者q,说明当前的公共祖先是leftAncestor
        if (leftAncestor == p || leftAncestor == q) {
            return leftAncestor;
        }
        //如果右子树rightAncestor=p或者q,说明当前的公共祖先是rightAncestor
        if (rightAncestor == p || rightAncestor == q) {
            return rightAncestor;
        }

        //左右子树只有一个不是null,则这个结果就是最近共公共祖先
        return leftAncestor == null ? rightAncestor : leftAncestor;

    }
}
