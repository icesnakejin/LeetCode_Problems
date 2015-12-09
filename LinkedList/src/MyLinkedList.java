
public class MyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	ListNode dummy = new ListNode();
	public final static class ListNode {
		int value;
		ListNode next;
		void ListNode(int n) {
			value = n;
		}
	}
	
	public void insert(ListNode node) {
		if (dummy.next == null) dummy.next = node;
		ListNode head = node;
		ListNode pre = dummy;
		while (head != null && head.value <= node.value) {
			
				pre.next = node;
				node.next = head;
			
		}
		pre.next = node;
		node.next = head;
	}
}
