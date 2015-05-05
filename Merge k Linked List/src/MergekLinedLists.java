import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}

public class MergekLinedLists {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(7);
		ListNode d = new ListNode(9);
		ListNode e = new ListNode(11);
		ListNode f = new ListNode(13);
		ListNode g = new ListNode(15);
		ListNode h = new ListNode(17);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = null;
		
		ListNode head1 = new ListNode(2);
		ListNode a1 = new ListNode(4);
		ListNode b1 = new ListNode(6);
		ListNode c1 = new ListNode(8);
		ListNode d1 = new ListNode(10);
		ListNode e1 = new ListNode(12);
		ListNode f1 = new ListNode(14);
		ListNode g1 = new ListNode(16);
		ListNode h1 = new ListNode(18);
		
		head1.next = a1;
		a1.next = b1;
		b1.next = c1;
		c1.next = d1;
		d1.next = e1;
		e1.next = f1;
		f1.next = g1;
		g1.next = h1;
		h1.next = null;
		
		ListNode head2 = new ListNode(3);
		ListNode a2 = new ListNode(6);
		ListNode b2 = new ListNode(9);
		ListNode c2 = new ListNode(12);
		ListNode d2 = new ListNode(15);
		ListNode e2 = new ListNode(18);
		ListNode f2 = new ListNode(21);
		ListNode g2 = new ListNode(24);
		ListNode h2 = new ListNode(27);
		
		head2.next = a2;
		a2.next = b2;
		b2.next = c2;
		c2.next = d2;
		d2.next = e2;
		e2.next = f2;
		f2.next = g2;
		g2.next = h2;
		h2.next = null;
		
		List<ListNode> input = Arrays.asList(head, head1, head2);
		
		
		Solution solution = new Solution();
		ListNode result = solution.mergeKLists(input);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}

class Solution {
   public ListNode mergeKLists(List<ListNode> lists) {
	   
	   ListNode result = null;
	   int index = 0;
	   while (index < lists.size()) {
		   result = mergeTwoLists(result,lists.get(index));
		   //System.out.println(lists.get(0).val);
		   index++;
	   }
	   return result;
   }
        
   private ListNode mergeTwoLists(ListNode listA, ListNode listB) {
	   ListNode result = new ListNode(0);
	   ListNode iterator = result;
	   while (listA != null && listB != null) {
		   //System.out.println (listA.val);
		   //System.out.println (result.val);
		   if (listA.val <= listB.val) {
			   iterator.next = listA;
			   listA = listA.next;
		   } else {
			   iterator.next = listB;
			   listB = listB.next;
		   }
		   iterator =  iterator.next;
		 }
	     if (listA == null) {
	    	 iterator.next = listB;
	     } else {
	    	 iterator.next = listA;
	     }
	   return result.next;
   	}
  }

	class Solution1 {
		   public ListNode mergeKLists(List<ListNode> lists) {
			   Comparator<ListNode> ListNodeComparator = new ListNodeComparator();
			   PriorityQueue<ListNode> heap =new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
			   ListNode dummy = new ListNode(0);
			   ListNode tail = dummy;
			   int index = 0;
			   while (index < lists.size()) {
				   if (lists.get(index) != null ){
					  heap.add(lists.get(index));
				   }
				   
				   //System.out.println(lists.get(0).val);
				   index++;
			   }
			   while (!heap.isEmpty()) {
				   ListNode head = heap.poll();
				   tail.next = head;
				   tail = head;
				   if (head.next != null) {
					   heap.add(head.next);
				   }
			   }
			   tail.next = null;
			   return dummy.next;
		   }
		}
	
	class ListNodeComparator implements Comparator<ListNode>{
		public int compare (ListNode a, ListNode b) {
			if ( a == null) {
				return 1;
			}else if (b == null) {
				return -1;
			}		
			return (a.val - b.val);
		}
	}



