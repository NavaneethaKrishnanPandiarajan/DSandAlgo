//$Id$
package arraysProgram;


/***
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n. 
 * 
 * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
 * 
 * For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
 * 
 * The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.
 * 
 * Time Complexity: O(n)
 * 
 * Auxiliary Space: O(1)
 *
 */


public class findTwoRepeatElements {
	
	public static void main(String [] args)
	{
		int arr[] = {4, 2, 4, 5, 2, 3, 1};
		
		findRepeating(arr);
	}

	private static void findRepeating(int[] arr) 
	{
		int x = 0;
		int y = 0;
		 
		int n = arr.length - 2; // Two repeating numbers and given array starts from 1 to n + 2 elements
		
		int sum = 0;
		int product = 1;
		
		for (int i : arr)
		{
			sum = sum + i;
			product = product * i;
		}
		
		
		//formula construction
		
		int x_plus_y = sum - (n*(n+1))/2 ;
		
		int x_and_y = product / (fact(n)) ;
		
		int x_minus_y = (int) Math.sqrt( ( x_plus_y * x_plus_y ) - 4 * x_and_y );
		
		x =  ( x_plus_y + x_minus_y ) / 2;     // x + y + x - y = 2x 
		
		y = x_plus_y - x;
		
		System.out.println( "The number x is " + x + " and the number y is " + y );
	}

	private static int fact(int n) {
		
		if( n == 0)
		{
			return 1;
		}
		else
		{
			return n * fact (n-1);
		}
		
	}
}
