//$Id$
package myprep;

import java.util.Stack;

public class LongestValidParanthesis {

	public int lengthValidParenthesis(String s)
	{
		int result = 0 ;
		
		Stack<Integer> stack = new Stack<Integer>(); 
		
		stack.push(-1);
		
		int length = s.length();
		
		for( int i=0  ; i<length ; i++)
		{
			if( s.charAt(i) == '(' )
			{
				stack.push(i);
			}
			else
			{
				stack.pop();
				
				if( !stack.isEmpty())
				{
					int top = stack.peek();
					
					int len = i - top ;
					
					result = Math.max( result , len);
				}
				else
				{
					stack.push(i); 
					
					// Invalid ')'  , it doesn't have match of '(' in previous indexes of string , so we just inserting its index . 
					// The reason we are inserting , this index can be used to find out the length of next valid parenthesis followed by this 
					// take this case 
						
						//  ( ) ( ) ) ( )
						
						//  valid substring ( ) ( )  , upto this case , we will not encounter this case , 
						
						// after that ')' comes at 4th index and stack also empty . so we are inserting 4 into stack , stack will be { -1 , 4 }
						
						// next character '(' , so we are inserting the index 5 , stack will be  { -1, 4 , 5}
						
						// next character ')' so '(' ')' match found , we are poping the index , so stack will be { -1 , 4 }
						
						// for finding out the length     6(current index ')') - 4(top of stack)   = 2 , ( so for this the index 4 used )
				}
			}		
		}
		
		
		// why -1 is used to inserted previously in stack 
			
			// take this case  // ()
		
			// stack contains {-1}
			
			// so findout the length --->    1 ( current Index ')' )  - (-1)  = 2
		
		return result;
	}
}
