
public class BitInRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = new Solution().rangeBitwiseAnd(1, 2);

	}

}

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int temp = m;
        int count = 0;
        while (m != n) {
            count ++;
            m <<= 1;
            n <<= 1;
        }
        System.out.println(count);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE << count));
        return temp & (Integer.MAX_VALUE << count);
    }
}
