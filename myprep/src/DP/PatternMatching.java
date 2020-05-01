public class PatternMatching 
{
	/**
	 *  ***Analysis***

		First of all, this is one of the most difficulty problems. It is hard to think through all different cases. 
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
		String text = "c";
		
		String pattern = "c*a*";
		
		boolean isRegMatch = isPatternMatches(text,pattern);
		
		System.out.print(isRegMatch);
	}

	private static boolean isPatternMatches(String text, String pattern) 
	{
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

}
