
public class ReverseList2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(7);
		ListNode g = new ListNode(8);
		ListNode h = new ListNode(9);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = null;
		
		
		
		Solution solution = new Solution();
		ListNode result = solution.reverseBetween(head, 3, 6);
		while (result != null) {
    		System.out.println(result.val);
    		result = result.next;
    	}
		//System.out.println(result.val);
		
//		while (result != null) {
//			
//			System.out.println(result.val);
//			result = result.next;
//		}

	}

}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	 }
	 
class Solution {
	
	private ListNode FindNodeAtIndex(ListNode head, int n) {
		int index = 1;
		while (index < n) {
			//System.out.println(head.val);
			head = head.next;
			index ++;
		}
		return head;
	}
	
	private ListNode FindPreNodeAtIndex(ListNode head, int n) {
		int index = n - 2;
		while (index > 0 ) {
			//System.out.println(head.val);
			head = head.next;
			index --;
		}
		return head;
	}
	 private ListNode Reverse(ListNode head) {
		 ListNode pre = null;
		 while (head != null) {
			 ListNode temp = head.next;
			 head.next = pre;
			 pre = head;
			 head = temp;
		 }
		 return pre;
	 }
	 
	 private ListNode FindTail(ListNode head) {
		 while (head.next != null) {
			 head = head.next;
		 }
		 return head;
	 }
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode front;
    	if (m == 1) {
    		front = head;
    	} else {
    		front = FindPreNodeAtIndex(head, m);
    	}   	
    	//System.out.println(front.val);
    	ListNode end;
    	if (m == 1) {
    		end = FindNodeAtIndex(front.next, n - m);
    	}else {
    		end = FindNodeAtIndex(front.next, n - m + 1);
    	}
    	
    	//System.out.println(end.val);
    	ListNode head1 = front;
    	ListNode head2 = end.next;
    	end.next = null;
    	ListNode newHead;
    	if (m == 1) {
    		newHead = Reverse(front);
    	} else {
    		newHead = Reverse(front.next);
    	}
    	
    	ListNode newTail = FindTail(newHead);
    	
    	
    	//System.out.println(newTail.val);
    	head1.next = newHead;
    	newTail.next = head2;
    	
    
    	if (m == 1) {
    		return newHead;
    	}else {
    		return head;
    	}
    	
    }
}