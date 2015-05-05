class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
public class rl2 {

	public static void main(String[] args) {
//		ListNode a = new ListNode(1);
//		ListNode b = new ListNode(1);
//		a.next = b;
//		ListNode result = new Solution().deleteDuplicates(a);
//		while (result != null) {
//			System.out.println(result.val);
//			result = result.next;
//		}
		System.out.println(4 & (1 << 2));
	}

}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                //while (head.next != null && head.next.val == val) {
                	//System.out.println(head.next.val);
                	head.next = head.next.next;
                //}
            } else {
            	head.next = head.next.next;
                head = head.next;
            }
            
        }
        return dummy.next;
    }
}
