//$Id$
package arraysProgram;

/**
 * Find a majority element in an array of size 'n'
 * 
 * Boyer–Moore majority vote algorithm  - Time Complexity - o(n) , Space Complexity - o(1)
 * 
 * https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
 *
 *
 *  MAJORITY ELEMENT --- > A majority element in an array A[] of size n is an element that appears more than n/2 times
 *
 */


public class MajorElement 
{

	public static void main (String [] args)
	{
		int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		
		int m = findMajority(a);
		
		System.out.println(m);
	}

	private static int findMajority(int[] a) 
	{
		int m = -1;
		int i = 0;
		
		for (int x : a)
		{
			if( i == 0)
			{
				m = x;
				i = 1;
			}
			else
			{
				if( x == m)
				{
					i = i+1;
				}
				else
				{
					i = i-1;
				}
			}
		}
		
		return m;
	}
}
