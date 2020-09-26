package stackcase.p005;

import java.util.Stack;

/**
 * 005 题目描述：
 * 用栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&&tqId=11158&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路:
 * 栈特性：先入后出
 * 队列特性：先入先出
 *
 * 要用到两个栈来配合！！！！stack1用来push，stack2用来pop
 * pop时，如果stack2不为空，则直接pop;如果空了，就把stack1的元素全都放入stack2，然后再pop
 * push时，直接push进stack1
 *
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if (stack2.isEmpty()) {
            //加一个两个队列都为空的判断更好
            if (stack1.isEmpty()){
                throw new RuntimeException("Queue is empty!!");
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pop();
    }

}