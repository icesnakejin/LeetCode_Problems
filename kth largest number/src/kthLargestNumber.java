import java.util.*;
public class kthLargestNumber {

	public static void main(String[] args) {
		int [] in = {9, 3, 2, 4, 8};
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(9);
		input.add(3);
		input.add(2);
		input.add(4);
		input.add(8);
		int result = new Solution().kthLargestElement(3,input);
		System.out.print(result);
	}

}

class Solution {
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        int[] nums =  new int[numbers.size()];
        for (int i = 0 ; i < nums.length ; i ++) {
            if (numbers.get(i) != null) nums[i] = numbers.get(i);
        }
        
        return select(k - 1, 0 , nums.length - 1, nums);
    }
    
    private int select(int k , int left, int right, int [] numbers) {
        if (left == right) return numbers[left];
        //int pivot = left + (right - left) / 2 ;
        int pos = partition(numbers, left, right);
        if (pos == k) return numbers[pos];
        else if (pos > k) return select(k, left, pos - 1, numbers);
        else return select(k, pos + 1 , right, numbers);
    }
    private int partition(int[] array, int left, int right) {
    	System.out.println(left);
        int pivot = array[left]; // taking first element as pivot
        //System.out.println(pivot);
        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        System.out.println(left);
        return left;
    }
    
    private void swap (int [] a , int start, int end) {
        //if (start < 0 || end >= a.length) return;
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
};
