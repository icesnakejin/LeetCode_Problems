
public class MCNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
	public int minimumN (int [] coins, int n) {
		int[] min = new int[n];
		min[0] = 1;
		for (int i = 1 ; i < n ; i ++) {
			int minV = i;
			for (int j = 0 ; j < i ; j ++) {
				if (coins.contains(i - j)) minV = Math.min(minV, min[j] + 1);
				min[i] = minV ;
			}
		}
		return min[n - 1];
	}
	
}
