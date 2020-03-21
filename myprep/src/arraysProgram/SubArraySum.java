package arraysProgram;
//$Id$

import java.util.HashMap;

/**
 * Algorithm to find a sub array whose sum is X
 * 
 *
 */


/**
 * The program not completed
 * @
 *
 */
public class SubArraySum {

	
	public static void main(String [] args)
	{
		int arr[] = {10, 2, -2, -20, 10}; 
		int sum = -10;
		
		printSubArray(arr, sum);
		
	}

	private static void printSubArray(int[] arr, int sum) 
	{
		int length = arr.length;
		
		int curr_sum = 0;
		
		HashMap < Integer, Integer > map = new HashMap < > ();
		
		
		
		for(int i=0; i < length ; i++)
		{
			curr_sum = curr_sum + arr[i];
			
			
		}
		
	}
}
