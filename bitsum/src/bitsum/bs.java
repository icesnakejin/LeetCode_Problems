package bitsum;

public class bs {

	public static void main(String[] args) {
		int result = new Solution().rangeBitwiseAnd(2, 3);
		System.out.println(result);

	}

}

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int count = 0;
        int result = 0;
        while (m != n) {
            //result |= (1 << count);
            
            m >>= 1;
            n >>= 1;
            count ++;
        }
        System.out.println(Integer.toBinaryString(m));
        System.out.println( m & -1);
        return m & (Integer.MAX_VALUE << count);
    }
}