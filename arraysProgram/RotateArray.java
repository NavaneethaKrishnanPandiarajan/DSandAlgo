//$Id$
package arraysProgram;

/**
 * 
 * Algorithm to rotate array of size 'n' by 'd' elements
 * 
 * reversal algorithm
 * For a[] = [1, 2, 3, 4, 5, 6, 7], d = 3 and n = 7
   A1 = [1, 2, 3] and A2 = [4, 5, 6, 7]
   Reverse A1, we get A1′B = [3, 2, 1, 4, 5, 6, 7]
   Reverse A2, we get A1′B1′ = [3, 2, 1, 7, 6, 5, 4]
   Reverse complete set, we get (A1′B1′)’ = [4, 5, 6, 7, 1, 2, 3]

 */


public class RotateArray {
	
	public static void main ( String [] arg)
	{
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 3;
		int n = arr.length;
		
		rotateArray(arr, d, n);
		
		for(int x : arr)
		{
			 System.out.print(" " +x);
		}
		
		// OUTPUT --  4 5 6 7 1 2 3
	}
	
	private static void rotateArray(int[] arr, int d, int n)
	{
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, n-1);
		reverseArray(arr, 0, n-1);

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
