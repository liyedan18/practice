package com.leetcode.binaryTree.p400.p450.p450;

import com.leetcode.binaryTree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 *
 * 思路：
 *      先找到（遍历），再修改
 *      先写出二叉搜索树遍历框架
 *      修改：
 *          三种情况：
 *              1.该节点是叶子节点，则直接删除
 *              2.该节点是只有左子树或者右子树，则用有的那个左子树或者右子树替换该节点即可
 *              3.该节点既有左子树，又有右子树，删除该节点后，需要其前驱节点（左子树最大值）或者
 *              后继节点（右子树的最小值）代替此节点的位置，并且要删除原来替代的节点。
 *               画图，这里采用后继节点。
 *
 *      总结：
 *          二叉搜索树遍历框架 + 后继节点 + 分类处理（==null,!=null）
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        //找到，删除
        if (root.val == key) {
            //1.
            if (root.left == null && root.right == null) {
                //直接删除，就是设置为null
                return null;
                //2.
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
                //3.
            } else {
                //查找后继节点
                TreeNode next = nextNode(root);
                //替换此节点
                root.val = next.val;
                //删除替换的节点（后继节点），在右子树上
                root.right = deleteNode(root.right, next.val);
            }
        }

        //二叉搜索树遍历框架
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    /**
     * 查找root的后继节点,后继节点肯定在右子树上，且是右子树的最小值
     */
    private TreeNode nextNode(TreeNode root) {
        //上面已判断root.right!=null
        TreeNode rightNode = root.right;
        while (rightNode.left != null) {
            rightNode = rightNode.left;
        }
        return rightNode;
    }
}
