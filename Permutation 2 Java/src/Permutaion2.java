import java.util.ArrayList;
import java.util.Arrays;
public class Permutaion2 {

	public static void main(String[] args) {
		int [] solution = {-1,-1,3,-1};
		ArrayList<ArrayList<Integer>> result = new Solution().permuteUnique(solution); 
		System.out.println(result);
		// TODO Auto-generated method stub

	}

}

class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num) {
        if(list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1){
                continue;
            }
            
            visited[i] = 1;    
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }    
}

