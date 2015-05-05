class Solution {
	 public int maximumGap(int[] num) {
	        if (num == null || num.length < 2) return 0;
	        int max = -1;
	        long maxGap = 0;
	        
	        for (int i = 0 ; i < num.length ; i ++) max = Math.max(max, num[i]);
	        
	        int[] hs = new int[max + 1];
	        
	        for (int i = 0 ; i < num.length ; i ++) hs[num[i]] = 1;
	        
	        for (int i = 1 ; i < hs.length ; i ++) hs[i] += hs[i - 1];
	        
	        int [] result = new int[num.length];
	        for (int i = 0 ; i < result.length ; i ++) {
	            result[hs[num[i]] - 1] = num[i];
	            hs[num[i]] --;
	        }
	        
	        for (int i = 1 ; i < result.length ; i ++) maxGap = (long)Math.max(result[i] - result[i - 1], maxGap);
	        return (int)maxGap;
	    }
    
}
public class MG {

	public static void main(String[] args) {
		int [] input = {2,99999999};
		int result = new Solution().maximumGap(input);
		System.out.println(result);
	}

}
