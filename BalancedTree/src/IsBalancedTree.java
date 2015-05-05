
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class IsBalancedTree {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		root.right = a;
		a.right = b;
		boolean result = new Solution().isBalanced(root);
		System.out.println(result);
		// TODO Auto-generated method stub

	}
	

}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
      
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        System.out.println("left" + left);
        System.out.println("right" + right);
        
        if (Math.abs(left - right) > 1) {
            return false;
        } else if (isBalanced(root.left) && isBalanced(root.right)){
            return true;
        } else {
        	return false;
        }
    }
    
    private int getHeight(TreeNode node) {
        
        if (node == null) {
            return 0;
        }
        
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        return left > right ? left + 1 : right + 1;
        
    }
}
