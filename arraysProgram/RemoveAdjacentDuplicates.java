//$Id$
package coding;

import java.util.Stack;

public class RemoveAdjacentDuplicates 
{
	
	public static String removeDuplicates(String s) 
	{
		if(s == null || s.isEmpty())
		{
			return s;
		}

		Deque <Character> deque = new LinkedList<Character>();
		int length = s.length();
		char a[] = s.toCharArray();

		for (int i=0; i<length; i++)
		{
			if( !deque.isEmpty() && deque.peekLast() == a[i])
			{
				while(  !deque.isEmpty() && deque.peekLast() == a[i] )
				{
					deque.removeLast();
				}
			}
			else
			{
				deque.addLast(a[i]);
			}
		}

		StringBuilder builder = new StringBuilder();

		while(!deque.isEmpty())
		{
			builder.append(deque.peekFirst());
			deque.removeFirst();
		}

		return builder.toString();
	}
	
	public static void main(String [] args)
	{
		String a = "abbaca";
		System.out.print(removeDuplicates(a));
	}

}
