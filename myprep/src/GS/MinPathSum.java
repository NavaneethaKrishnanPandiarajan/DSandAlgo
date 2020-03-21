//$Id$
package GoldManSachs;

public class MinPathSum {

	
	public static int minPathSum(int [][] grid)
	{
		
		if( grid == null || grid.length == 0 )
		{
			return 0;
		}
		
		int m = grid.length;   //row length
		int n = grid[0].length; // column length 
		
		int dp[][] = new int [m][n];
	
		int temp =0;
		
		for(int i=0 ; i<m ; i++)   //Oth column will be 
		{
			temp += grid[i][0];
			dp[i][0] = temp;
		}
		
		temp=0;
		for(int j=0 ; j<n ; j++)   //Oth row will be 
		{
			temp += grid[0][j];
			dp[0][j] =temp;
		}
		
		
		for(int i=1 ;i<m ;i++)
		{
			for(int j=1 ; j<n ; j++)
			{
				int fromUp = dp[i-1][j] + grid[i][j];
				int fromLeft = dp[i][j-1] + grid[i][j];
				
				int minimum = Math.min(fromUp, fromLeft);
				dp[i][j] = minimum;
			}
		}
		
		
		return dp[m-1][n-1];
	}
}
