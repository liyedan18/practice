package com.leetcode.binaryTree.p200.p290.p297;

import com.leetcode.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
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
 * 提示:这与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明:不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 *
 * 思路：
 *      序列化即为二叉树的遍历
 *      反序列化，即根据二叉树的遍历重新构造为二叉树
 *      序列化和反序列化要成对使用
 *
 *      前序、后续遍历都可以。中序遍历不行（不能实现反序列化）
 *      层序遍历可以
 *
 *      方式三：
 *          层序遍历
 *
 *          反序列化时，按照层序遍历框架，构造二叉树
 */
public class Solution3 {

    private final String COMMA = ",";
    private final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    /**
     * 二叉树层序遍历
     * 用队列
     */
    private void serialize(TreeNode root, StringBuilder sb){
        if (root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node==null) {
                sb.append(NULL).append(COMMA);
                continue;
            }
            sb.append(node.val).append(COMMA);

            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(COMMA)));
        return deserialize(list);
    }

    /**
     * 由层序遍历构造二叉树
     */
    private TreeNode deserialize(LinkedList<String> list){
        if (list.isEmpty()){
            return null;
        }

        String val = list.removeFirst();
        if (val == null || val.equals("")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));

        /**
         * 层序遍历框架
         */
        //这里存放parent节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode parent = queue.poll();

            String leftVal = list.removeFirst();
            if (!leftVal.equals(NULL)){
                parent.left = new TreeNode(Integer.parseInt(leftVal));
                queue.add(parent.left);
            } else {
                parent.left = null;
            }

            String rightVal = list.removeFirst();
            if (!rightVal.equals(NULL)){
                parent.right = new TreeNode(Integer.parseInt(rightVal));
                queue.add(parent.right);
            } else {
                parent.right = null;
            }

        }

        return root;
    }
}
