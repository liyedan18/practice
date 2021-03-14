package binaryTree.p37;

import binaryTree.TreeNode;

/**
 * 剑指 Offer 37. 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 *
 * 思路：
 *      前中后序遍历都可以。用递归
 *      遍历时，带上空指针信息。那么反序列化时，只用单独的前中后序的一个就可以构造二叉树。
 */
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    //前序遍历
    private void preorder(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    //如果不用这个全局变量，可以用LinkedList作为方法参数放在preorderDes中
    private int indexOfDes;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        int length = str.length;
        if (length == 0) {
            return null;
        }
        indexOfDes = 0;
        return preorderDes(str);
    }

    private TreeNode preorderDes(String[] str) {
        if (indexOfDes >= str.length) {
            return null;
        }

        if ("null".equals(str[indexOfDes])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str[indexOfDes]));

        indexOfDes++;
        root.left = preorderDes(str);
        indexOfDes++;
        root.right = preorderDes(str);

        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));