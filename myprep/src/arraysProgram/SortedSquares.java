//$Id$
package arraysProgram;

import java.util.Arrays;

/**
 * 
 * Given an array of integers A sorted in non-decreasing order, 
 * return an array of the squares of each number, also in sorted non-decreasing order.
 * 
 * Input: [-4,-1,0,3,10]
 * 
 * Output: [0,1,9,16,100]
 *
 */


public class SortedSquares {

	
	public static void main(String [] args)
	{
		int arr[] = {-4,-1,0,3,10};
		
		int squareArray[] =new int[arr.length];
		
		for(int i=0 ; i< arr.length ;i++)
		{
			squareArray [i] = arr[i] * arr[i];
		}
		
		Arrays.sort(squareArray);
		
		
	}
}
