import java.util.HashMap;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class RandomNode {

	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode a = new RandomListNode(3);
		RandomListNode b = new RandomListNode(5);
		RandomListNode c = new RandomListNode(7);
		RandomListNode d = new RandomListNode(9);
		RandomListNode e = new RandomListNode(11);
		RandomListNode f = new RandomListNode(13);
		RandomListNode g = new RandomListNode(15);
		RandomListNode h = new RandomListNode(17);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = null;
		
		head.random = c;
		c.random = b;
		b.random = d;
		d.random = f;
		f.random = e;
		e.random = g;
		g.random = f;
		a.random = h;
		h.random = head;
		
		RandomListNode iterator = head;
		
		RandomListNode result = new Solution().copyRandomList(iterator);
		
		
		while (result != null && head != null) {
			if (result.label != head.label) {
				System.out.println("wrong");
			}		
			result = result.next;
			head = head.next;
		}
	}
	
	

}

class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) {
    		return head;
    	}   	
    	HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        
        while (head != null) {
        	RandomListNode newNode;
        	if (nodeMap.containsKey(head)) {
        		newNode = nodeMap.get(head);	
        	} else {
        		newNode = new RandomListNode(head.label);
        		nodeMap.put(head, newNode);
        	}
        	
        	if (nodeMap.containsKey(head.random)) {
        		newNode.random = nodeMap.get(head.random);    		
        	} else {
        		newNode.random = new RandomListNode(head.random.label);
        		nodeMap.put(head.random, newNode.random);
        	}
        	tail.next = newNode;
        	//System.out.println(newNode.label);
        	tail = tail.next;
        	head = head.next;
        }
        return dummy.next;
        
        
    }
}
