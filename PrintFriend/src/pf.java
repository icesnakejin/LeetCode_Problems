import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class pf {

	public static void main(String[] args) throws IOException {
		File dir = new File(".");
		File fin = new File(dir.getCanonicalPath() + File.separator + "in.txt");
		String [] input = {"A: B,C,D ",
						   "D: B,E,F ",
						   "E: C,F,G " 
						   };
		new Solution().pf(input, "A");
	}

}
class Node {
	boolean visited = false;
	List<Node> neighbors;
	String name;
	Node (String name) {
		this.name = name;
		neighbors = new ArrayList<Node>();
	}
}

class Solution {
	public void pf (String[] file, String s) {
		HashMap<String, String[]> friendMap = new HashMap<String, String[]>();
		HashMap<String, Node> nodeMap = new HashMap<String, Node>();
		for (int i = 0 ; i < file.length ; i ++) {
			String line = file[i];
		    String key = line.split(":")[0];
		    String[] values = (line.split(":")[1].trim()).split(",");
		    for (int j = 0 ; j < values.length ; j ++) {
		    	System.out.print(values[j]);
		    	
		    }
		    System.out.println("");
		    System.out.println(key);
		    friendMap.put(key, values);
			
		}
		Node root = new Node(s);
		createNodeNeighbors(root, friendMap, nodeMap);
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		int level = 1;
		while (!queue.isEmpty()) {
			System.out.println("Level " + level + " - ");
			int size = queue.size();
			for (int i = 0 ; i < size ; i ++) {
				Node front = queue.poll();
				
				
				for (Node one : front.neighbors) {
					if (!one.visited) {
						System.out.print("," + one.name);
						createNodeNeighbors(one, friendMap, nodeMap);
						queue.offer(one);
						one.visited = true;
					}
				}
			}
			System.out.println("");
			level ++;
		}
		
	}
	
	private void createNodeNeighbors (Node node , HashMap<String, String[]> friendMap, HashMap<String, Node> nodeMap) {
		String key = node.name;
		//System.out.println(key);
		//System.out.println(friendMap.get(key));
		if (!friendMap.containsKey(key)) return;
		for (String one :friendMap.get(key)) {
			if (!nodeMap.containsKey(one)) {
				Node oneNode = new Node(one);
				node.neighbors.add(oneNode);
				nodeMap.put(one, oneNode);
			} else {
				node.neighbors.add(nodeMap.get(one));
			}
		}
		
		
	}
}
