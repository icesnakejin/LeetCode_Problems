
public class SearchRotatedArray {
	public static void main(String[] args) {
		int [] a = {3,1};
		int result = new Solution().search(a,1);
		//System.out.println(result);
	}
	
}

class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int high = A.length - 1;
        int low = 0;
        
        while ( low <= high ) {
        	System.out.println("low"+ low);
            int m = (low + high) / 2;
            System.out.println("m"+ low);
       
            if (A[m] == target) {
            	System.out.println (m);
                return m;
            }
    
            if ( A[m] >= A[low] ) {
            	System.out.println("a");
                if ( target < A[m] && target >= low) {
                	System.out.println("b");
                    high = m - 1;
                } else {
                    low = m + 1;
                }
            } else {
                if (target > A[m] && target <= A[high]) {
                    low = m + 1;
                } else {
                    high = m - 1;
                }
            }
        }
        return -1;
        
    }
}
