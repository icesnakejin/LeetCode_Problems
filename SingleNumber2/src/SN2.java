
public class SN2 {

	public static void main(String[] args) {
		int[] a = {3,3,3,2,2};
		int ans = new Solution().singleNumber(a);
		System.out.print(ans);
	}

}

class Solution {
    public int singleNumber(int[] A) {
        int ans = 0;
        for ( int i = 0 ; i < 32 ; i ++ ) {
            int d = 1<<i , c = 0;
            
            for (int j : A) {
                if ((j&d) != 0) {
                    c++;
                }
            }
            if (c%3==1) {
                ans |= d;
            }
        }
        return ans;
    }
}
