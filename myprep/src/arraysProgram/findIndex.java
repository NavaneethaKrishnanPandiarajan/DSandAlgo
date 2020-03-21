//$Id$
package arraysProgram;

/**
 * 
 * Find the index in an array such that the sum of elements at lower indices
 * 
 * is equal to the sum of elements at higher indices.
 * 
 * 
 * 
	1) Initialize leftsum  as 0

	2) Get the total sum of the array as sum

	3) Iterate through the array and for each index i, do following.
    
    	a)  Update sum to get the right sum.  
           sum = sum - arr[i] 
       	// sum is now right sum
   
    	b) If leftsum is equal to sum, then return current index. 
   
    	c) leftsum = leftsum + arr[i] // update leftsum for next iteration.

	4) return -1 // If we come out of loop without returning then
         
         // there is no equilibrium index
 * 
 * 
 */


public class findIndex {
	
	public static void main(String [] args)
	{
		int arr [] = { -7, 1, 5, 2, -4, 3, 0 };
		
		printIndexes(arr);
	}

	private static void printIndexes(int[] arr) 
	{
		int rightSum = 0;
		
		for(int x : arr)
		{
			rightSum = rightSum + x ;
		}
		
		int leftSum  = arr[0];
		
		for(int i = 1 ; i < arr.length ; i++)
		{
				
			rightSum = rightSum - arr[i]  ;
			
			if( leftSum == rightSum )
			{
				System.out.println( "index :: "+ (i + 1) + " and the element is " + arr[i+1]);
			}
			
			leftSum  = leftSum + arr[i];
		}
		
	}
	
}
