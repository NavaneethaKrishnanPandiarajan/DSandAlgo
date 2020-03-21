//$Id$
package arraysProgram;

/**
 * 
 *  Time Complexity: O(n)
 * 
 *  Auxiliary Space: O(1)
 *
 */


public class findDuplicateNumbers {
	
	/***
	 * 
	 Example: A[] =  {1, 1, 2, 3, 2}
	
	i=0; 
	Check sign of A[abs(A[0])] which is A[1].  A[1] is positive, so make it negative. 
	Array now becomes {1, -1, 2, 3, 2}

	i=1; 
	Check sign of A[abs(A[1])] which is A[1].  A[1] is negative, so A[1] is a repetition.

	i=2; 
	Check sign of A[abs(A[2])] which is A[2].  A[2] is  positive, so make it negative. '
	Array now becomes {1, -1, -2, 3, 2}

	i=3; 
	Check sign of A[abs(A[3])] which is A[3].  A[3] is  positive, so make it negative. 
	Array now becomes {1, -1, -2, -3, 2}

	i=4; 
	Check sign of A[abs(A[4])] which is A[2].  A[2] is negative, so A[4] is a repetition.
	 **/
	 
	
	public static void main( String [] args )
	{
		int arr[] = {4, 2, 4, 5, 2, 3, 1}; 
		
		System.out.println("The duplicate elements are : "); 
		
		findDuplicates(arr);
		
	}

	private static void findDuplicates(int[] arr) 
	{
		int length = arr.length;
		
		for( int i = 0 ; i < length ; i++ )
		{
			
			if( arr[ Math.abs(arr[i])]  > 0)
			{
				arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])];
			}
			else
			{
				System.out.print( Math.abs(arr[i]) +  " " );
			}
		}
		
	}
}
