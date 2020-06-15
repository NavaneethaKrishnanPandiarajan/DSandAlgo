//$Id$
package arraysProgram;

/**
 * 
 * Maximum difference between two elements such that larger element appears after the smaller number
 *
 */

 /**
	Lets say we have array arr[] of stock prices.
		We will track two variable :minElementTillNow and maxDifference.

			minElementTillNow will be initialise to arr[0].
			Iterate over  arr[]
			If current element is greater than minElementTillNow
			calculate difference.
			If difference is greater than maxDifference then update the maxDifference.
			If current element is lesser than minElementTillNow
			update minElementTillNow with current element.
			We will get maxDifference in the end.

  **/

public class MaximumDiff {

	public static void main(String [] args)
	{
		int[] arr = {14, 12, 70, 15, 95, 65, 22, 30};
		
		int maxDiff = findMaxDiff(arr);
		
		System.out.println(maxDiff);
				
	}

	private static int findMaxDiff(int[] arr) 
	{
		int minElementTillNow = arr[0];
		
		int maxDifference = Integer.MIN_VALUE;
		
		for (int currentValue : arr)
		{
			if ( currentValue > minElementTillNow ) // such that larger element appears after the smaller number
			{
				int diff = currentValue - minElementTillNow ;
				
				if( diff  > maxDifference )
				{
					maxDifference = diff;
				}
			}
			else
			{
				minElementTillNow = currentValue;
			}
		}
		
		
		return maxDifference;
	}
}
