//$Id$
package myprep;

public class LongestPalindromicSubString {

	private static int [][] dp ;
	
	public static void main(String [] args)
	{
		String s = "ccc";
		//String s = "aaaabbaa";
		
		int n = s.length();
		
		dp = new int[n][n];
		
		for(int i = 0 ; i<n  ; i++)
		{
			dp[i][i] = 1;
			
			if( i+1 != n && ( s.charAt(i) == s.charAt(i+1)) )
			{
				dp[i][i+1] = 1;
			}
		}
		
		
		for(int k=2 ; k<n ; k++)
		{
			for(int i=0 ; i+k <n ; i++ )
			{
				int j = i+k;
				
				if( dp[i+1][j-1] == 1 && ( s.charAt(i) == s.charAt(j) ) )
				{
					dp[i][j] = 1;
				}
				
			}
		}
		
		
		int max = 0 ;
		int start = 0;
		int end  = 0;
		
		for(int i=0; i<n ;i++)
		{
			for(int j=i+1; j<n; j++)
			{
				if(dp[i][j] == 1)
				{
					int length = j-i;
					
					if(max < length)
					{
						max = length;
						start = i;
						end = j;
					}
				}
			}
		}
		
		String longestPalindromicSubString = s.substring(start, end+1); //if (end + 1) not and end only presents , then it prints geeksskee
		
		System.out.println(longestPalindromicSubString);
		System.out.println("Length of longest palindromic substring " + longestPalindromicSubString.length());
		
	}
	
	
}
