//$Id$
package coding;

import java.util.Stack;

public class RemoveAdjacentDuplicates 
{
	public static void removeDuplicates(int a[])
	{
		Stack<Integer> s = new Stack<Integer>();
		int length = a.length;
		
		int ctrlVariable = 0;
		
		for (int i=0; i<length; i++)
		{
			if( s.isEmpty() )
			{
				s.push(a[i]);
			}
			
			else
			{
								
				if( ctrlVariable == 1)
				{
					if(s.peek() != a[i])
					{
						s.pop();
						
						ctrlVariable = 0;
					}
				}
						
				if(s.peek() == a[i])
				{
					s.pop();
					
					ctrlVariable=1;
					
					if( i < length -1)
					{
						s.push(a[i]);
					}
				}
				else
				{
					s.push(a[i]);
				}
				
			}
			
		}
		
		System.out.println(s);
	}
	
	public static void main(String [] args)
	{
		int a[] = {1,5,6,8,8,8,0,1,1,0,6,5};
		
		int b[] = {1,9,6,8,8,8,0,1,1,0,6,5};
		
		removeDuplicates(a);
		
		removeDuplicates(b);
	}
}
