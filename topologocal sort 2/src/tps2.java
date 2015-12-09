import java.util.HashSet;


public class tps2 {

	public static void main(String[] args) {
		int [][] pre = {{0, 1}, {1, 0}};
		int [] result = new Solution().findOrder(2, pre);
//		System.out.println(result[0]);
//		System.out.println(result[1]);
	}

}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean [] visited = new boolean[numCourses];
        boolean [] visiting = new boolean[numCourses];
        HashSet<Integer>[] graph = new HashSet[numCourses];
        int [] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0 ; i < result.length ; i ++) result[i] = i;
            return result;
        }
        
        if (prerequisites[0] == null || prerequisites[0].length == 0) {
            for (int i = 0 ; i < result.length ; i ++) result[i] = i;
            return result;
        }
        
        for (int i = 0 ; i < graph.length ; i ++) graph[i] = new HashSet<Integer>();
        for (int i = 0 ; i < prerequisites.length ; i ++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        
        for (int i = 0 ; i < graph.length ; i ++) {
            if (visited[i]) continue;
            int[] result1 = new int[numCourses];
            
            if (DFS(result1, visited, visiting, i, 0, graph)) {
            	
                return result1;
            }
        }
        System.out.println(result[0]);
        System.out.println(result[1]);
        return result;
    }
    
    private boolean DFS(int [] result, boolean[] visited , boolean[] visiting, int ind, int current,  HashSet<Integer>[] graph) {
    	
    	if (visiting[ind]) return false;
        visited[ind] = true;
        visiting[ind] = true;
        if (current == result.length) return true;
        
        result[current] = ind;
        
        for (Integer i : graph[ind]) {
            if (DFS(result, visited, visiting, i, current + 1, graph)) return true;
        }
        visiting[current] = false;
        return false;
    }
}
