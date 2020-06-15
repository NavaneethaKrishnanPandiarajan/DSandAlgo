//$Id$
package myprep;

import java.util.Stack;

public class NumberOfvalidSubString 
{
	/**
	 * https://www.geeksforgeeks.org/walmart-labs-interview-experience-java-developer-for-4-5-years-experienced/?ref=rp
	 * 
	 * Given a string containing only R and L. 
	 * 
	 * Find the number of balanced substrings(equal number of L’s and R’s) 
	 * 
	 * you will encounter where you can traverse only in the left-right direction.

		Example 1: RLRRLLRLRL  Answer: 4 (RL, RRLL, RL, RL)
		
		Example 2: LLLLRRRR  Answer:1 (LLLLRRRR)

		Example 3: RLLLLRRRLR  Answer:3 (RL, LLLRRR, LR)

	 * 
	 * 
	 */
	public static int numberOfValidSubString(String s)
	{
		Stack<Character> stack = new Stack<Character>(); 
		int length = s.length();
		int count = 0;
		
		for( int i=0 ; i<length;)
		{
			if(stack.isEmpty()  ||    ( s.charAt(i) == stack.peek() ) )
			{
				stack.push(s.charAt(i));
				i++;
			}
			else
			{
				count ++;		
				int j=i;
				while( !stack.isEmpty() )
				{
					Character temp = stack.peek();
					if( s.charAt(j) != temp )
					{
						stack.pop();
						j++;
					}
					else
					{
						break;
					}
				}
				
				if( j>i)
				{
					i=j;
				}
				else
				{
					i++;
				}
			}
		}
		
		return count;
	}
	
	
	public static void main(String [] args)
	{
		System.out.println(numberOfValidSubString("RLRRLLRLRL"));
		System.out.println(numberOfValidSubString("LLLLRRRR"));
		System.out.println(numberOfValidSubString("RLLLLRRRLR"));
	}
}
