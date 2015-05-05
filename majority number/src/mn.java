
public class mn {

	public static void main(String[] args) {
		int[] num = {1};
		int result = new Solution().majorityElement(num);
		System.out.println(result);

	}

}

class Solution {
    public int majorityElement(int[] num) {
        int n = num.length;
        int result = 0;
        for (int i = 0 ; i < 32 ; i ++) {
            int count = 0;
            for (int j = 0 ; j < n ; j ++) {
                int temp = num[j] >> i;
                if ((temp & 1) == 1) {
                	System.out.println("catch");
                	count ++;
                }
            }
            if (count >= n / 2 + 1) {
            	System.out.println("got" + count);
            	result = result | (1 << i);
            }
        }
        return result;
    }
}