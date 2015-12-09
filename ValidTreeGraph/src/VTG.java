import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class VTG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] input = {{1, 0}};
		boolean result = new Solution().validTree(2, input);
		System.out.print(result);

	}

}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        int [] edgeN = new int [n];
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        for (int [] one : edges) {
            if (!hm.containsKey(one[0])) {
                List<Integer> out = new ArrayList<Integer>();
                hm.put(one[0], out);
            }
            hm.get(one[0]).add(one[1]);
            edgeN[one[1]] ++;
        }
        
        boolean [] visited = new boolean[n];
        LinkedList<Integer>queue = new LinkedList<Integer>();
        for (int i = 0 ; i < edgeN.length ; i ++) {
            if (edgeN[i] == 0) queue.offer(i);
            System.out.println(i);
            break;
        }
        
        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (visited[front]) {
            	System.out.println(front);
            	return false;
            }
            visited[front] = true;
            if (!hm.containsKey(front)) continue;
            for (int i : hm.get(front)) {
                
                queue.offer(i);
            }
        }
        
        for (int i = 0 ; i < visited.length ; i ++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
