class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class MaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(-2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		root.left = a;
		a.left = b;
		int result = new Solution().maxPathSum(root);
		System.out.println(result);

	}

}

class Solution {
    //int currentMax = -9999999;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        int currentLeft = maxPathSum(root.left);
        int currentRight = maxPathSum(root.right);
        int currentMax;
        if (root.left == null) {
                currentMax = currentRight;
        }else if (root.right == null) {
                currentMax = currentLeft;
        }else if (currentLeft >= 0 && currentRight >= 0) {
            currentMax = currentRight + currentLeft;
        } else {
            currentMax = Math.max(currentLeft, currentRight);
            currentMax = Math.max(currentMax, currentLeft + currentRight); 
        }
        
        if (root.val < 0) {
            return currentMax > root.val ? currentMax : root.val;
        } else {
            if (currentMax <= 0) {
                return root.val;
            } else {
                return currentMax + root.val;
            }
        }
    }
    
}
