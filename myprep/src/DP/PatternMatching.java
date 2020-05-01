//$Id$
package myprep;

public class PatternMatching 
{
	/**
	 *  ***Analysis***

		
		The problem should be simplified to handle 2 basic cases:

		case1 : the second char of pattern is "*"
	        case2 : the second char of pattern is not "*"

		For the 1st case, if the first char of pattern is not ".", the first char of pattern and string should be the same. 
		Then continue to match the remaining part.

		
		For the 2nd case, if the first char of pattern is "." or first char of pattern == the first i char of string, 
		continue to match the remaining part.
	 
	 * 
	 * 
	 */
	public static void main(String [] args)
	{
		String text = "aab";
		
		String pattern = "c*a*b";
		
		boolean isRegMatch = isPatternMatches(text,pattern);
		
		System.out.print(isRegMatch);
	}

	private static boolean isPatternMatches(String text, String pattern) 
	{
		System.out.println("text " + text + " , " + "pattern " + pattern);
		
		if(pattern.isEmpty()) //base case
		{
			return text.isEmpty();
		}
		
		boolean isFirstMatch = !text.isEmpty() &&  ( text.charAt(0) == pattern.charAt(0) ) || ( pattern.charAt(0) == '.');
		
		
		if(pattern.length() > 1 && pattern.charAt(1) == '*')
		{
			return isPatternMatches( text, pattern.substring(2) ) ||  ( isFirstMatch && isPatternMatches( text.substring(1) ,pattern ) );
		}
		else
		{
			return isFirstMatch && isPatternMatches(text.substring(1), pattern.substring(1));
		}
	}
	
	//constructing the same concept in dp 
	public static boolean isMatch(String text, String pattern) 
	{
	    
	    boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	    
	    dp[text.length()][pattern.length()] = true;

	    
	    for (int i = text.length(); i >= 0; i--) 
	    {
	        for (int j = pattern.length(); j >= 0; j--) 
	        {
	            
	            if(i==text.length() &&j==pattern.length() ) 
	            continue;

	            boolean first_match = (i < text.length() && j < pattern.length()  && ( pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.') );
	            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') 
	            {
	                dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
	            } 
	            else 
	            {
	                dp[i][j] = first_match && dp[i + 1][j + 1];
	            }
	        }
	    }
	    return dp[0][0];
	}

}
