//$Id$
package arraysProgram;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Find a pair in an array of size 'n', whose sum is X
 * 
 *
 * Time Complexity - o(n)
 * 
 * Space Complexity o(n) 
 * 
 */

public class PairSum 
{
	public static void main(String [] args)
	{
		int a[] = {12, 4, 45, 6, 10, -8};
		int sum = 22;
	
		/**
		 * RESULT SHOULD BE
		 * The pair of elements :: 12 :: 4
		 * The pair of elements :: 6 :: 10
		 */
		
		int result [] = findPairsWithSum (a,sum);	
		
		for (int x : result)
		{
			System .out.println( "The indices are : " + x );
		}
	}

	private static int[] findPairsWithSum(int[] nums, int target) 
	{
		HashMap <Integer,Integer> valuesAndIndex  = new HashMap<Integer,Integer>();
		int [] result = new int [2];
		
		for(int i=0 ;i<nums.length ;i++)
		{
			int diff = target - nums[i];
			
			if( valuesAndIndex.containsKey(diff) )
			{
				System .out.println( "The pair of elements :: " + diff + " :: " + target );
				
				result[0] =  valuesAndIndex.get(diff);
				result[1] =	 i;	
				
				break;
			}
			
			valuesAndIndex.put(nums[i],i);		
		}
		
		return result ;
	}
}
