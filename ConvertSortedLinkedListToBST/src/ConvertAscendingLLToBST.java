
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class ConvertAscendingLLToBST {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(8);
		ListNode c = new ListNode(9);
		ListNode d = new ListNode(10);
		ListNode e = new ListNode(11);
		ListNode f = new ListNode(12);
		ListNode g = new ListNode(13);
		ListNode h = new ListNode(14);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		
		
		TreeNode result = new Solution().sortedListToBST(head);
		
		int index = 1;
		new Solution().PrintTree(result, index);
		//System.out.println("result"+":"+result.val);
		// TODO Auto-generated method stub

	}

}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
    	TreeNode root = new TreeNode(FindMid(head,false).val);
//    	while (head != null) {
//    		System.out.println (head.val);
//    		head = head.next;
//    	}
    	//System.out.println (getListLength(head));
    	TreeNode result = sortedListToBSTHelp(head,root);
    	return result;
    	
    }
    
    private TreeNode sortedListToBSTHelp(ListNode head,TreeNode root) {
    	TreeNode newNode = new TreeNode(0);
    	//System.out.println(head.val);
    	if (head == null || head.next == null) {
    		newNode.val = head.val;
    		//System.out.println("lasttime"+":"+newNode.val);
    		return newNode;
    	}
    	ListNode mid;
    	if (head.next.next == null) {
    		mid = FindMid(head,false);
    	} else {
    		mid = FindMid(head,true);
    	}
    	
    	System.out.println("mid "+mid.val);
    	if (mid == head) {
    		
    		//System.out.println("head" + " " + head.val);
    		//System.out.println("root" + " " + root.val);
    		newNode.val = mid.next.val;
    		TreeNode left = new TreeNode(mid.val);
    		newNode.left = left;
    		//mid.next = null;
    			
    			return newNode;
    		 		
    	}
    	newNode.val = mid.val;
    	
    	ListNode right = mid.next;
    	//System.out.println("right"+" "+right.val);
    	//mid.next = null;
    	//mid = null;
    	ListNode left = head;
    	newNode.left = sortedListToBSTHelp(left,root);
    	
    	newNode.right = sortedListToBSTHelp(right,root);
    	
    	//System.out.println(newNode.val);
    	return newNode;
    }
    
    private ListNode FindMid(ListNode head,boolean cut) {
    	if (head == null) {
    		return head;
    	}
    	ListNode pre = head;
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while (fast != null && fast.next != null) {
    		pre = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	if (cut) {
    		pre.next = null;
    	}
    	
    	//System.out.println("bingo" + " " + getListLength(head));
    	
    		return slow;
      	
    }
    
    public void PrintTree (TreeNode root,int index) {
    	
    	if (root == null) {
    		return;
    	}
    	System.out.println (index+"th" + "number" + ":" + root.val);
    	index ++;
    	PrintTree(root.left,index);
    	PrintTree(root.right,index);
    } 
    
    
    
    
}
