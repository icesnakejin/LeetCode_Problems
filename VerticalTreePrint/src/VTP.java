import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;
import com.sun.javafx.collections.MappingChange.Map;

class TreeNode {
	int val;
	TreeNode left; 
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}
public class VTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode (0);
		TreeNode r1 = new TreeNode (1);
		TreeNode r2 = new TreeNode (2);
		TreeNode r3 = new TreeNode (3);
		TreeNode r4 = new TreeNode (4);
		TreeNode r5 = new TreeNode (5);
		root.left = r1;
		root.right = r2;
		r1.left = r3;
		r2.left = r5;
		r3.right = r4;
		new Solution().verticalPrint(root);
	}

}



class Solution {
	
	
	public void verticalPrint(TreeNode root) {
	    HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
	    helper(map, 0, root);
	    TreeMap<Integer, List<TreeNode>> tm = new TreeMap<Integer, List<TreeNode>>(map);
	    for (java.util.Map.Entry<Integer, List<TreeNode>> one : tm.entrySet()) {
	    	List<TreeNode> oneLine = one.getValue();
	    	//System.out.println(oneLine.size());
	    	for (int i = 0 ; i < oneLine.size(); i ++) {
	    		TreeNode oneN = oneLine.get(i);
	    		System.out.println(oneN.val);
	    	}
	    	System.out.println("/");
	    }
	}

	private void helper (HashMap<Integer, List<TreeNode>> map, int hd, TreeNode node){
	    if (node == null) return;
	    if (!map.containsKey(hd)) map.put(hd, new ArrayList<TreeNode>());
	    map.get(hd).add(node); 
	    helper (map, hd - 1, node.left);
	    //System.out.println(node.val);
	    helper (map, hd + 1, node.right);
	}
}