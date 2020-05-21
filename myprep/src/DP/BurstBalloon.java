//$Id$
package myprep;

import java.util.List;

public class BurstBalloon 
{	
	private int[][] dp;
	
	// dp[i][j]   = ( nums[i-1] * num[k] * num[j+1] )  +  dp[i,k-1]  + dp[k+1,j] 
	
	//					 i	<= k <= j
	
	// Max coins between i to j
	
	
	public int maxCoins(int[] nums) 
	{
		int[] newCoinArr = new int[nums.length + 2];
		newCoinArr[0] = 1;
		newCoinArr[newCoinArr.length - 1] = 1;   // handling for left-> -1 and right -> n+1  
		
		for (int i = 0; i < nums.length; i++)
		{
			newCoinArr[i + 1] = nums[i];
		}
		
		dp = new int[newCoinArr.length][newCoinArr.length];
		
		return maxCoins(newCoinArr , 1 , newCoinArr.length - 2);
	}
	
	private int maxCoins(int[] nums, int i, int j) 
	{
        if (i > j) 
        	return 0;
        
        
        if (dp[i][j] != 0) 
        	return dp[i][j];
        
        int res = 0;
        
        for (int k = i; k <= j; k++) 
        {
        	int currentvalAtk = nums[i-1] * nums[k] * nums[j + 1] + maxCoins(nums, i, k - 1) + maxCoins(nums, k + 1, j);
            
        	res = Math.max( res, currentvalAtk );
        }
        
        dp[i][j] = res;
        return res;
    }
}
