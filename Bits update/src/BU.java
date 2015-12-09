
public class BU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = new Solution().updateBits(1, -1, 0, 31);
		//System.out.println(Integer.toBinaryString(result));
	}

}

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int bit = 1;
        int digit = 0;
        while (1 << digit != m) {
        	System.out.println(Integer.toBinaryString(1 << digit));
            if ( (1 << digit & m) != 0 ) n = n | (1 << (digit + i));
            else n = n & ~( 1 << (digit + i));
            digit ++;
        }
        return n;
    }
}