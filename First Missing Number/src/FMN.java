
public class FMN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 1};
		int result = new Solution().firstMissingPositive(a);
		System.out.println(result);
	}

}

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0 ; i < nums.length ; i ++) {
            while ( nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
            	
                int temp = nums[i];
                //System.out.println(temp);
                swap(nums, i, nums[i] - 1);
                
            }
        }
        for (int i = 0 ; i < nums.length ; i ++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
    private void swap (int [] a , int i , int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    	
}
