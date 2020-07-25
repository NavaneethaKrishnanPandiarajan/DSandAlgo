//$Id$
package arraysProgram;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumSlidingWindow 
{
	public int[] maxSlidingWindow(int[] arr, int k) 
	{
        
		if ( arr == null || k <= 0 || arr.length == 0) 
		{
			return new int[0];
		}
		
		int n = arr.length;
		int ri = 0;
		int[] result = new int[n-k+1];
		
		
		/***  list.peekFirst always going to give the index of the maximum of the particular window **/
		
		/***  In order to achieve this every element adding we are checking two aspects **/
		
		/**    1)  Remove the elements from the list if the corresponding index of the element goes out of range **/
		
		/**    2)  Remove the elements that are smaller in the window while adding the elements index in the list
		 			i.e - >  For every element, the previous smaller elements are useless                        **/
		 		
		   				
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=0; i<k; i++)
		{
			int currElement = arr[i];
			
			while( !list.isEmpty() &&  arr[list.peekLast()] <= currElement )
			{
				list.removeLast();
			}
			
			list.addLast(i);
		}

		for( int i=k; i<n; i++ )
		{
			int maxElement = arr[list.peekFirst()];
			
			result[ri++] = maxElement;
			
			int currElement = arr[i];
			
			/**  this is the reason that we are storing the index instead of the element in the list   **/
			/**  remove the elements that are not belongs to this window **/
			while( !list.isEmpty() &&  list.peekFirst() <= i-k ) 
			{
				list.removeFirst();
			}
			
			while( !list.isEmpty() &&  arr[list.peekLast()] <= currElement )
			{
				list.removeLast();
			}
			
			list.addLast(i);	
		}
		
		
		int maxElement = arr[list.peekFirst()];
		result[ri++] = maxElement;
		
		return result;
	 
    }
}
