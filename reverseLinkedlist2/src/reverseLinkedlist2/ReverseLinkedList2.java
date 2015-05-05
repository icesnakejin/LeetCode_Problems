package reverseLinkedlist2;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	 }

public class ReverseLinkedList2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode bd = new ListNode(5);
		head.next = bd;
		ListNode result = new Solution().reverseBetween(head, 1, 2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode walker = dummy;
        while (m > 1) {
        	//System.out.println(walker.val);
            walker = walker.next;
            m --;
        }
        
        while (n > 1) {
        	//System.out.println(runner.val);
            runner = runner.next;
            n --;
        }
        
        ListNode w1 = walker.next;
        ListNode r1 = runner.next.next;
        ListNode a = w1;
        
        runner.next.next = null;
        
        //System.out.println(w1.next.val);
//        int i = 1;
//        while (w1.next != null) {
//        	System.out.println(i);
//        	System.out.println(w1.val);
//        	i ++;
//        	w1 = w1.next;
//        }
        ListNode nHead = reverse(w1);
        //System.out.println(nHead.val);
        walker.next = nHead;
//        while (w1.next != null) {
//        	System.out.println(w1.val);
//            w1 = w1.next;
//        }
        w1.next = r1;
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
