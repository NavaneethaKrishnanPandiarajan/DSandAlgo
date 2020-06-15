//$Id$
package arraysProgram;
/**
 * 
 * Find the number occuring odd number of times in a given array of size 'n' 
 * 
 * 
 * 
 *
 *
 *  The Best Solution is to do bitwise XOR of all the elements. XOR of all elements gives us odd occurring element.
 *  Please note that XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
 *  
 */


public class OddOccurance {

	public static void main ( String [] args)
	{
		int[] arr = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2}; 
		
		int result = find_Number_Of_OddOccurance(arr);
		
		System.out.println(result);
	}

	private static int find_Number_Of_OddOccurance(int[] arr) 
	{
		int result = 0;
		
		for (int x : arr)
		{
			result = result ^ x;
		}
		
		return result;
	}
}
