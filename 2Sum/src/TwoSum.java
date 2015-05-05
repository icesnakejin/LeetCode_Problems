import java.util.HashMap;
public class TwoSum {

	public static void main(String[] args) {
		int [] a = {0,4,3,0};
		int [] result = new Solution().twoSum(a,0);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> indexes = new HashMap<Integer, Integer>();
        for ( int i = 0 ; i < numbers.length; i ++ ) {
            indexes.put (numbers[i] , i + 1); 
        }
        int [] result = new int[2];
        for ( Integer n : indexes.keySet()) {
        	
            if (indexes.containsKey(target - n)) {
            	
                	
                    result[0] = Math.min(indexes.get(n), indexes.get(target - n));
                    result[1] = Math.max(indexes.get(n), indexes.get(target - n));
                    break;
                
            }
        }
        return result;
    }
}
