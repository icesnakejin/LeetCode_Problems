
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class PL {

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode a = new ListNode(1);
		
		head.next = a;

		head = new Solution().partition(head, 2);
		//cout<<head<<endl;
//		while (head != null)
//			{
//				//cout<<"a"<<endl;
//				System.out.println(head.val);
//				head = head.next;
//			}

	}

}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode head2 = dummy2;
        while (head != null) {
        	System.out.println(head.val);
            if (head.val < x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        //System.out.println(head1.val);
        //head2.next = null;
        head1.next = dummy2.next;
        return dummy1.next;
    }
}