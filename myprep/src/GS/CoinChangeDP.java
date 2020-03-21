//$Id$
package GoldManSachs;

public class CoinChangeDP {

	
	public static int numberOfways(int amount , int coins[])
	{
		int m = coins.length + 1;
		int n = amount + 1;
		
		int dp[][] = new int[m][n];
		
		
		for(int i=0; i<=coins.length ; i++)
		{
			dp[i][0] = 1;
		}
		
		for(int j=1 ; j<=amount ; j++)
		{
			dp[0][j] = 0;
		}
		
		for(int i=1 ; i<=coins.length ; i++)
		{
			for(int j=1 ; j<=amount ; j++)
			{
				int coin = coins[i-1];
				
				if( coin > j)
				{
					dp[i][j] = dp[i-1][j];
				}
				else
				{
					dp[i][j] = dp[i-1][j] + dp[i][j-coin];
				}
			}
		}
		
		return dp[m-1][n-1];
	}
	
	
	public static void main(String [] args)
	{
		 int amount = 5;
	     int coins[] = {1,2,5};
	     
	     int result = numberOfways(amount,coins);
	     
	     System.out.print(result);
	}
}
