import java.util.Comparator;
import java.util.PriorityQueue;


public class kthlargerst {

	public static void main(String[] args) {
		int [] input = {2, 1};
		int result = new Solution().findKthLargest(input, 1);
		System.out.println(result);

	}

}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> comparator = new reverseComparator();
        PriorityQueue<Integer> minStack = new PriorityQueue<Integer>(k, comparator);
        System.out.println(minStack.size());
        for (int i = 0 ; i < nums.length ; i ++) {
            minStack.offer(nums[i]);
            if (--k == 0) break;
        }
        int result = 0;
        while (minStack.size() > 0) {
        	result = minStack.poll();
        	System.out.println(result);
        }
        return result;
    }
    
    class reverseComparator implements Comparator<Integer> {
        public int compare (Integer a, Integer b) {
            if (a < b) return 1;
            else if (a > b) return -1;
            else return 0;
        }
    }
}
