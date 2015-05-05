
public class RS2 {

	public static void main(String[] args) {
		char[] s = {'h', 'i','!'};
		new Solution().reverseWords(s);
		System.out.println(s);

	}

}

class Solution {
    public void reverseWords(char[] s) {
        swapInARange(s, 0 , s.length - 1);
        int start = 0;
        int end = 0;
        for (int i = 0 ; i < s.length ; i ++) {
            
            if (s[i] != ' ') end ++;
            else {
                swapInARange (s, start, end - 1);
                start = end + 1;
                end ++;
            }
        }
    }
    private void swapInARange (char[] input, int start, int end) {
        int i = start; 
        int j = end; 
        while (i <= j) {
            if (!Character.isLetter(input[j]) && input[i] != ' ') {
            	System.out.println(input[j]);
                j --;
                continue;
            }
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i ++;
            j --;
        }
    }
}