import java.util.ArrayList;
public class FCA {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		root.left = a;
		a.parent = root;
		a.left = b;
		b.parent = a;
		a.right = c;
		c.parent = a;
		c.left = d;
		d.parent = c;
		d.left = e;
		e.parent = d;
		root.right = f;
		f.parent = root;
		
		TreeNode result = new SolutionWithParentDivideAndConquer().FSA( b ,e);
		System.out.print(result.val);
//		boolean cover = new Solution().covers(b, c);
//		System.out.print(cover);

	}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(int x) { val = x; }
}

class Solution {
	
	
	
	public TreeNode FSA (TreeNode node, TreeNode a, TreeNode b) {
		 return  Helper(node, a, b);
		
		
	}
	
	public TreeNode Helper (TreeNode node, TreeNode a, TreeNode b) {
		if ( node == null || a == null || b == null) {
			return null;
		}
		boolean isLeft = covers(node.left, a);
		boolean isRight = covers(node.left, b);
		//System.out.println(node.val);
		if (isLeft != isRight) {
			return node;
		}
		//TreeNode left = Helper(node.left, a,b);
		if (isLeft)
		{
			return Helper(node.left, a,b);
		} else {
			return Helper(node.right, a,b);
		}
	}
	
	public boolean covers (TreeNode node, TreeNode target) {
		if (node == null) {
			return false;
		}
		 if (node == target) {
			 return true;
		 }
		 return (covers(node.left, target)||covers(node.right, target));
	} 
}

class SolutionWithParentAdditionalSpace {
		
	public TreeNode FSA (TreeNode node, TreeNode a, TreeNode b) {
		ArrayList<TreeNode> path1 = getPathToRoot(a);
		//System.out.println(path1.get(0).val);
		
		ArrayList<TreeNode> path2 = getPathToRoot(b);
		//System.out.println(path2.get(0).val);
		
		//int length = 0;
		//TreeNode result;
		if (path1.size() > path2.size()) {
			for (int i = 0; i < path2.size() ; i++ ) {
				if (path1.contains(path2.get(i))) {
					return path2.get(i);
				}
			}
		} else {
			for (int i = 0; i < path1.size() ; i++ ) {
				if (path2.contains(path1.get(i))) {
					return path1.get(i);
				}
			}
		}
		return null;
		
		
		
	}
	
	private ArrayList<TreeNode> getPathToRoot (TreeNode node) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		while (node != null ) {
			list.add(node);
			node = node.parent;
		}
		return list;
	}
}

class SolutionWithParentDivideAndConquer {
	TreeNode result;
	public TreeNode FSA (TreeNode a, TreeNode b) {
		TreeNode root = getRoot(a);
		//System.out.println(root.val);
		 Helper(root,a,b);
		return result;
	}
	
	private TreeNode Helper (TreeNode node, TreeNode a, TreeNode b) {
		if (node == null) {
			return null;
		}
		TreeNode left = Helper (node.left, a, b);
		TreeNode right = Helper (node.right, a, b);
		if (node == a || node == b) {
			if (result == null || result == a || result == b) {
				result = node;
			}
			return node;
			
		}
		if ((left == a || left == b) && (right == a || right == b) && (result == null || result == a || result == b)) {
			//System.out.println(node.val);
			result = node;
		}
		if (left == a || left == b) {
			//System.out.println(node.val);
			return left;
		}
		
		if (right == a || right == b) {
			//System.out.println(node.val);
			return right;
		}
		
		return null;
	}
	
	private TreeNode getRoot (TreeNode node) {
		
		while (node.parent != null) {
			node = node.parent;
		}
		return node;
	}
}

class SolutionWithParentDivideAndConquer2 {
	TreeNode result;
	public TreeNode FSA (TreeNode a, TreeNode b) {
		TreeNode root = getRoot(a);
		//System.out.println(root.val);
		 Helper(root,a,b);
		return result;
	}
	
	private TreeNode Helper (TreeNode node, TreeNode a, TreeNode b) {
		if (node == null || node == a || node == b) {
			return node;
		}
		TreeNode left = Helper (node.left, a, b);
		TreeNode right = Helper (node.right, a, b);
		
		if ((left != null) && (right != null)) {
			return node;
		}
		
		if (left != null) {
			return left;
		}
		
		if (right != null) {
			return right;
		}
		
		return null;
	}
	
	private TreeNode getRoot (TreeNode node) {
		
		while (node.parent != null) {
			node = node.parent;
		}
		return node;
	}
}
