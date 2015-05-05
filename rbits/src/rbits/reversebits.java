package rbits;

public class reversebits {

	public static void main(String[] args) {
		int result = new Solution().reverseBits(1);
		System.out.println(result);

	}

}

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	if (n == 0) return 0;
        long result = 0;
        int pos = 31;
        long n1 = (long)n;
        long maxDigit = (long)1 << pos;
        while (pos >= 0) {
            if (maxDigit <= n1) {
               result |= (long)1 << (30 - pos);
               n1 -= maxDigit;
            }
            pos --;
            maxDigit = (long)1 << pos;
        }
        return (int)result;
    }
}
