import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

public class TreeToLinkedlist {

	public static void main(String[] args) {
		ArrayList<Integer> test = ArrayList<Integer>();
		TreeNode root = new TreeNode(20);
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(12);
		TreeNode d = new TreeNode(22);
		TreeNode e = new TreeNode(-2);
		TreeNode f = new TreeNode(-1);
		root.left = a;
		root.left = b;
		HashMap<Integer,Integer> cand = new HashMap<Integer,Integer>();
		cand.contains(5);
		cand.get(5);
		cand.size();
		cand.get(5)++;
		Set<Integer> keys = cand.keySet(); // The set of keys in the map.

        Iterator<Integer> keyIter = keys.iterator();
		for (int k : cand.keySet()) {
			
		}
		new Solution().flatten(root);
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}

	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public void flatten(TreeNode root) {
       if (root == null) {
           return;
       }
       
       Stack<TreeNode> stack = new Stack<TreeNode>();
       TreeNode dummy = new TreeNode(0);
       dummy.right = root;
       TreeNode head = dummy.right;
       
       stack.push(root);
       while (!stack.empty()) {
    	   System.out.println(head.val);
           TreeNode front = stack.pop();         
            head = front;              
            head = head.right;          
           if (front.right != null) {
               stack.push(front.right);
           }
           
           if (front.left != null) {
               stack.push(front.left);
           }
           
           
       }
       root.left = null;
       root.right = dummy.right.right;
    }
}
