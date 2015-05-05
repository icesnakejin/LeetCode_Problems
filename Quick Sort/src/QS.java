import java.util.ArrayList;


public class QS {
	
	public static void main(String[] args) {
		int [] solution = {5,6, 2, 1, 3, 4};
		//new Solution().quickSort(0, solution.length - 1, solution); 
		//for (int i = 0 ; i < solution.length ; i ++) System.out.print(solution[i]);
		// TODO Auto-generated method stub
		int max = Integer.MAX_VALUE;
		System.out.println(Integer.toBinaryString(4 & (max << 1)));

	}
	
}

class Solution {
	public void quickSort (int left, int right , int [] nums) {
		if (left >= right) return;
		int p = partition(left, right, nums);
		quickSort(left, p - 1, nums);
		quickSort(p + 1, right, nums);
	}
	
	private int partition (int left, int right, int [] nums) {
		
		int pV = nums[right];
		int storeI = left;
		for (int i = left ; i < right ; i ++) {
			if (nums[i] < pV) {
				swap(i, storeI, nums);
				storeI ++;
			}
		}
		swap(storeI, right, nums);
		return storeI;
	}
	
	private void swap (int start, int end , int [] nums) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp; 
	}
}



