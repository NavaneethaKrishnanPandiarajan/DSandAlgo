//$Id$
package arraysProgram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 
	In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

	There is at least one empty seat, and at least one person sitting.

	Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

	Return that maximum distance to closest person.
 	
 	
 	Input: [1,0,0,0,1,0,1]
	
	Output: 2
	
	Explanation: 
	
	If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
	
	If Alex sits in any other open seat, the closest person has distance 1.
	
	Thus, the maximum distance to the closest person is 2.
 *
 */

public class Seating {

	public static void main(String [] args)
	{
		int arr[] = {1,0,0,0,1,0,1};
		int position = findPosition(arr,arr.length);
		
		System.out.print(position);
	}

	private static int findPosition(int[] arr, int length) 
	{
		Integer dist = Integer.MIN_VALUE;
		
		Integer prev = null;
		
		for(int i=0; i<length ; i++)
		{
			if( arr[i] == 1)
			{
				if(prev == null)
				{
					prev = i;	//for cases [0001]
					dist = Math.max(dist, i );
				}
				else
				{
					dist = Math.max(dist, (i - prev)/2);
					prev = i;
				}
			}
		}
		
		if(prev != null)
		{
			//for cases [100]
			dist = Math.max(dist, length - 1 - prev);
		}
		
		return dist;
	}
}
