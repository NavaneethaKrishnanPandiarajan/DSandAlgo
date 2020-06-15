//$Id$
package arraysProgram;

/**
 *  Algorithm to reverse an array
 * 
 *
 */

public class ReverseArray {

	 public static void main(String [] args)
	 {
		 int arr [] = {1, 2, 3, 4, 5, 6}; 
		 int end = arr.length - 1;
		 int start = 0;
		 
		 reverseArray (arr , start , end );
		 
		 for(int x : arr)
		 {
			 System.out.print(" " +x);
		 }
	 }

	private static void reverseArray(int[] arr, int start, int end) 
	{
		while (start < end)
		{
			
			int temp = arr [start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end --;
		}
		 
	}
}
