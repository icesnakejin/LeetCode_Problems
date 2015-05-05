import java.util.ArrayList;
import java.util.Stack;



public class PostOrderIterative {

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
			ArrayList<Integer> result = new Solution().postorderTraversal(root);
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    	//postorderTraversalHelper(result, root);
    	
    	return result;
    }
    
    private void postorderTraversalHelper(ArrayList<Integer> result, TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	
    	result.add(node.val);
    	 postorderTraversalHelper(result,node.left);
    	 postorderTraversalHelper(result,node.right);   	
    }
}
