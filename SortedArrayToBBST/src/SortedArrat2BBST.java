

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class SortedArrat2BBST {

	public static void main(String[] args) {
		int [] num = {1,2,3,4,5};
		TreeNode result = new Solution().sortedArrayToBST(num);
		int index = 0;
		new Solution().PrintTree(result,index);
		// TODO Auto-generated method stub

	}

}

class Solution {
	private int index = 0;
	
    public TreeNode sortedArrayToBST(int[] num) {
    	if (num == null || num.length == 0) {
    		return null;
    	}
        int length = num.length;
        TreeNode result = sortedArrayToBSTHelper(length, num);
        return result;
        
        
    }
    private TreeNode sortedArrayToBSTHelper(int size, int[] num) {
    	if (size <= 0) {
    		return null;
    	}
    	TreeNode left = sortedArrayToBSTHelper(size/2, num);
    	TreeNode root = new TreeNode(num[index]);
    	index++;
    	TreeNode right = sortedArrayToBSTHelper(size - 1 - size/2, num);
    	root.left = left;
    	root.right = right;
    	
    	return root;
    	
    }
    
public void PrintTree (TreeNode root,int index) {
    	
    	if (root == null) {
    		return;
    	}
    	
    	index ++;
    	System.out.println (index+"th" + "number" + ":" + root.val);
    	PrintTree(root.left,index);   	
    	index ++;
    	PrintTree(root.right,index);
    } 
    
}
