/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。  示例： 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-array 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date:2020-4-15 22:03
 */
public class mergeTwoLists {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode zipListNode(ListNode l1, ListNode l2) {
    ListNode preHead = new ListNode(-1);
    ListNode prev = preHead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      //移动哨兵节点指针
      prev = prev.next;
    }
    prev.next = l1 == null ? l2 : l1;
    return preHead.next;
  }


  public static void main(String[] args) {
    ListNode l1 = new mergeTwoLists().new ListNode(1);
    ListNode l2 = new mergeTwoLists().new ListNode(2);
    ListNode node = new mergeTwoLists().zipListNode(l1, l2);
    System.out.println(node.val);
    System.out.println(node.next.val);
  }
}
