class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int len = s.length() - 1;
        int exp = 0;
        while (len >= 0) {
            char letter = s.charAt(len);
            
            result += (letter - 'A' + 1) * Math.pow(26,exp);
            System.out.println(result);
            exp ++;
            len --;
        }
        return result;
    }
}
public class E2T {

	public static void main(String[] args) {
		String s = "A";
		int result = new Solution().titleToNumber(s);
		System.out.println(result);

	}

}
