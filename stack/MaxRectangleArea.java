//$Id$
package stack;

import java.util.Stack;

public class MaxRectangleArea {

	
	public int findMaxArea(int [] arr)
	{
		int maxArea = 0;
		Stack<Integer> s = new Stack<Integer>();
		
		int i = 0 ;
		
		for(  i = 0 ; i < arr.length ; i++ )
		{
			if( s.isEmpty() ||   arr[s.peek()] <= arr[i])
			{
				s.push(i);
			}
			else
			{
				int top = s.pop();
				
				if( s.isEmpty())
				{
					int area = arr[top] * i;
					
					maxArea = Math.max(maxArea, area);
					
				}
				else
				{

					int area = arr[top] * ( i - s.peek() - 1);
					
					maxArea = Math.max(maxArea, area);
				
				}
			}
		}
		
		
		while( !s.isEmpty())
		{

			int top = s.pop();
			
			if( s.isEmpty())
			{
				int area = arr[top] * i;
				
				maxArea = Math.max(maxArea, area);
				
			}
			else
			{

				int area = arr[top] * ( i - s.peek() - 1);
				
				maxArea = Math.max(maxArea, area);
			
			}
		}
	
		return maxArea;
	}
}
