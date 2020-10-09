package linkedlistcase.p036;


/**
 * 036   题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&&tqId=11189&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 思路1：
 * 先判断是否有公共节点（最后一个节点是否相同，如果相同，则有公共节点，否则没有）
 * 遍历链表1，放入List。遍历链表2，到List中查询是否存在（==），存在则返回。
 *
 * 这思路太笨了，舍弃
 *
 * 1-2-3-4-5-6-7-8
 *       0-0-9-7-8
 *
 * 思路2：
 * 有公共节点，那么从某个节点开始之后，两个链表的所有元素都是一样的。
 * 怎么找到这个公共节点？
 * 类似快慢双指针的方式。
 * 让长链表先走，等待长链表剩余的长度和短链表相同时，两个指针再一起走。
 * 当两个指针相等，则是相同节点
 *
 * 1.各先遍历一遍，确认各自长度。
 * 2.确认起始节点，开始同时遍历
 *
 */
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        //1
        int length1 = 0;
        int length2 = 0;
        ListNode tempNode1 = pHead1;
        ListNode tempNode2 = pHead2;
        while (tempNode1 != null) {
            length1++;
            tempNode1 = tempNode1.next;
        }
        while (tempNode2 != null) {
            length2++;
            tempNode2 = tempNode2.next;
        }

        //2
        tempNode1 = pHead1;
        tempNode2 = pHead2;
        //Node2先走
        if (length1 <= length2) {
            for (int i = 0; i < length2 - length1; i++) {
                tempNode2 = tempNode2.next;
            }
        } else {
            for (int i = 0; i < length1 - length2; i++) {
                tempNode1 = tempNode1.next;
            }
        }

        while (tempNode1 != tempNode2) {
            tempNode1 = tempNode1.next;
            tempNode2 = tempNode2.next;
            if (tempNode1 == null || tempNode2 == null) {
                return null;
            }
        }
        return tempNode1;

    }

}
