package min_swap;

public class Min_swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 5, 6, 4, 1, 2};
		 
	    // if (a, b) is pair than we have assigned elements
	    // in array such that pairs[a] = b and pairs[b] = a
	    int pairs[] = {3, 6, 1, 5, 4, 2};
	    
	    int result = new Solution().minSwap(arr, pairs);
	    System.out.println(result);
	}

}

class Solution {
	public int minSwap (int [] arr, int [] pairs) {
		return helper(arr, pairs, 0);
	}
	
	private int helper(int [] arr, int [] pairs, int ind) {
		if (ind >= arr.length - 1) return 0;
		int firstPair = findPair(arr, pairs, ind);
		int secondPair = findPair(arr, pairs, ind + 1);
		if (arr[ind + 1] == firstPair || arr[ind] == secondPair) 
			return helper (arr, pairs, ind + 2);
		int firstP2Swap = findInd(arr, firstPair, ind);
		swap(arr, ind + 1, firstP2Swap);
		int a = helper(arr, pairs, ind + 2);
		swap(arr, ind + 1, firstP2Swap);
		int secondP2Swap = findInd(arr, secondPair, ind + 2);
		swap(arr, ind, secondP2Swap);
		int b = helper(arr, pairs, ind + 2);
		swap(arr, ind, secondP2Swap);
		return Math.min(a, b) + 1;
	}
	
	private void swap (int [] arr, int i , int j) {
		//System.out.println(j);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private int findPair (int [] arr, int [] pairs, int i) {
		//System.out.println(i);
//		if (i == 0) return pairs[i + 1] == arr[i + 1];
//		else if (i == arr.length - 1) return pairs[i - 1] == arr[i - 1];
//		else return arr[i + 1] == pairs[i + 1] || arr[i + 1] == pairs[i - 1];
		for (int j = 0 ; j < pairs.length ; j ++) {
			if (pairs[j] == arr[i]) {
				if (j % 2 == 0) return pairs[j + 1];
				else return pairs[j - 1];
			}
		}
		return -1;
	}
	
	private int findInd(int [] arr, int target, int start) {
		for (int i = start ; i < arr.length ; i ++) {
			if (arr[i] == target) return i;
		}
		return -1;
	}
}