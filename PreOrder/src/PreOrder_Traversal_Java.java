import java.util.ArrayList;


public class PreOrder_Traversal_Java {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		a.left = b;
		a.right = c;
		c.left = d;
		root.left = a;
		root.right = e;
		ArrayList<Integer> result = new Solution().preorderTraversal(root);
		System.out.println(result);
		




	}

}

class TreeNode {
	int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	preorderTraversalHelper(result, root);
    	return result;
    }
    
    private void preorderTraversalHelper(ArrayList<Integer> result, TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	
    	result.add(node.val);
    	 preorderTraversalHelper(result,node.left);
    	 preorderTraversalHelper(result,node.right);   	
    }
}
