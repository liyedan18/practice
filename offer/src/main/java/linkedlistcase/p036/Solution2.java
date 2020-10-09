package linkedlistcase.p036;


/**
 * 036   题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&&tqId=11189&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * A:1-2-3-4-5-6-7-8
 * B:      0-0-9-7-8
 *
 * 1-2-3-4-5-6-7-8 -> 0-0-9-7-8
 * 0-0-9-7-8 -> 1-2-3-4-5-6-7-8
 *
 * 思路3：
 * 如上所示，两个链表如果有共同节点，那么这两个链表连起来遍历的话,
 * AB和BA整个链表的后面部分应该是相等的。
 * 则只需要在遍历时判断AB和BA两个链表是否有相等的节点即可。
 *
 */
public class Solution2 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode tempNode1 = pHead1;
        ListNode tempNode2 = pHead2;
        while(tempNode1 != tempNode2){
            if (tempNode1 == null){
                tempNode1 = pHead2;
            } else {
                tempNode1 = tempNode1.next;
            }
            if (tempNode2 == null){
                tempNode2 = pHead1;
            } else {
                tempNode2 = tempNode2.next;
            }

        }

        /**
         * 以上while循环可替换为：
         */
/*        while (tempNode1 != tempNode2){
            tempNode1 = tempNode1 == null ? pHead2 : tempNode1.next;
            tempNode2 = tempNode2 == null ? pHead1 : tempNode2.next;
        }*/

        return tempNode1;

    }

}
