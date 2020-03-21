//$Id$
package arraysProgram;

public class gcdOftwoStrings {
	
	
	/**
	 * 
	  	Main idea:
	  	
		The main edge case is when the GCD appears more than once in both strings. 
		For example str1="ABABABAB" and str2="ABAB". The rest is straight forward. 
		In this example, the GCD is "AB", which also appears twice in str2. 
		So, we need to find a solution that could search for the GCD in both strings, not only in str1. 
		This looks like a recursive problem. Note that as soon as we know that str1 starts with str2, 
		we can then focus on the remaining letters of str1 and keep calling our recursive function. 
		This is true because we've already confirmed that the begining of str1 was equals to str2. 
		So if str2 contains the GCD multiple times, so did str1!

		Algorithm:
		
		The solution to this exercise requires the use of language specific methods such as substring() and equals (in Java for example).

		The main idea is to check if str1 starts with str2 and to repeat the same operation with the remaining portion of str1.
		
		It looks like a great candidate for a recursive solution where we stop when we've exhausted str2 (str2 equals to " ").
		
		In your recursive function, make sure to have str1.length() always greater or equal to str2.length()
		
		That means you need to swap the 2 parameters when str1.length() < str2.lentgh()
	
		When str2 is equal to " ", that means we found the GCD which is str1.
	 
	 * 
	 */
	
	public static void main(String [] args)
	{
		String str1 = "ABABAB";
		String str2 = "ABAB";
		String  gcd = gcdOfStrings(str1,str2);
		
		System.out.print(gcd);
		
	}

	public static String gcdOfStrings(String str1, String str2) 
	{
        // Swap the paramters when needed
        if (str1.length() < str2.length())
            return gcdOfStrings(str2, str1);
        
        // Since we swap
        if (str2.length() == 0)
            return str1;

        // Check if str1 starts with str2
        if (!str1.substring(0, str2.length()).equals(str2)) {
            return "";
        }
        
        // Call the function with remaining part of str1
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}
