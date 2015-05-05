class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class SearchARangeInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(12);
		TreeNode d = new TreeNode(22);
		TreeNode e = new TreeNode(-2);
		TreeNode f = new TreeNode(-1);
		root.left = a;
		root.right = d;
		a.left = b;
		a.right = c;
		new Solution().SearchRangeInBST(root,4,22);
	}

}

class Solution {
	public void SearchRangeInBST (TreeNode node, Integer low , Integer high) {
		if (node == null) {
			return;
		}
		
		if (node.val >= low) {
			SearchRangeInBST (node.left, low, high);
		}
		
		
		
		if (node.val >= low && node.val <= high) {
			System.out.println(node.val);
		}
		
		if (node.val <= high) {
			SearchRangeInBST (node.right, low, high);
		}	
	}
}
