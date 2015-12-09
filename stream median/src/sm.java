import java.util.Comparator;
import java.util.PriorityQueue;


public class sm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {4,5,1,3,2,6,0};
		int [] result = new Solution().medianII(input);
		for (int i = 0 ; i < result.length ; i ++) {
			 System.out.println(result[i]);
		}
		
	}

}

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int []result = new int[nums.length];
        PriorityQueue<Integer> minH = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            public int compare (Integer a, Integer b) {
                if (a > b) return 1;
                if (a < b) return -1;
                return 0;
            }
        });
        
        PriorityQueue<Integer> maxH = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            public int compare (Integer a, Integer b) {
            	if (a < b) return 1;
                if (a > b) return -1;
                return 0;
            }
        });
        
        minH.offer(Integer.MAX_VALUE);
        maxH.offer(Integer.MIN_VALUE);
        for (int i = 0 ; i < nums.length ; i ++) {
           if (minH.size() == maxH.size()) {
        	   
                if (nums[i] <= maxH.peek()) {
                	
                    maxH.offer(nums[i]);
                    result[i] = maxH.peek();
                    
        
                } else {
                    minH.offer(nums[i]);
                    result[i] = minH.peek();
                    
                }
            } else if (minH.size() > maxH.size()) {
            	
                if (nums[i] > minH.peek()) {
                    minH.offer(nums[i]);
                    int a = minH.poll();
                    int b = minH.peek();
                    maxH.offer(a);
                    
                    result[i] = (a + b) / 2;
                    
                } else {
                	//System.out.println(result[i]);
                    maxH.offer(nums[i]);
                    int a = maxH.peek();
                    int b = minH.peek();
                    result[i] = (a + b) / 2;
                }
                
            } else {
                if (nums[i] < maxH.peek()) {
                    maxH.offer(nums[i]);
                    int a = maxH.poll();
                    int b = maxH.peek();
                    minH.offer(a);
                    result[i] = (a + b) / 2;
                } else {
                    minH.offer(nums[i]);
                    int a = minH.peek();
                    int b = maxH.peek();
                    result[i] = (a + b) / 2;
                }
            }
        }
        return result;
    }
}

