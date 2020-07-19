//$Id$
package LeetcodeHard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculator 
{
	
	// refer : https://www.youtube.com/watch?v=C_jxn1hTn6Q
	
	public int calculate(String s) 
	{
		Queue<Character> q = new ArrayDeque<>();
		
		for (char c : s.toCharArray()) 
		{
			if (c != ' ') 
			{
				q.offer(c);
			}
		}

		q.offer(' ');
		return helper(q);
	}

	private int helper(Queue<Character> q) 
	{
		int num = 0;
		int prev = 0;
		int sum = 0;
		char prevOp = '+';

		while (!q.isEmpty()) 
		{
			char c = q.poll();

			if (c >= '0' && c <= '9') 
			{
				num = num * 10 + c - '0';
			} 
			else if (c == '(') 
			{
				num = helper(q);  // If we 
			} 
			else 
			{
				switch (prevOp) 
				{
				case '+':
					sum += prev;
					prev = num;
					break;
				case '-':
					sum += prev;
					prev = -num;
					break;
				case '*':
					prev *= num;
					break;
				case '/':
					prev /= num;
					break;
				}

				if (c == ')') 
					break; 	//if we encounter ')' , we are terminating the the inner recursion 
							// and it goes parent method function call , with calculated result   

				num = 0;    // the flow comes here means , we visited non digit char so reinitialising num to 0
							// num is being used in this case  123+4
							// here for 123 continous multiple digit case , the num variable used. 
							// so once we encounter operator character , we are resetting this.
				prevOp = c; // Here operator will store
			}
		}

		return sum + prev;
	}
	
	public static void main(String [] args)
	{
		String s = "335";
		
		BasicCalculator obj = new BasicCalculator();
		System.out.println(obj.calculate(s));
	}
}
