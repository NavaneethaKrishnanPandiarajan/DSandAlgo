//$Id$
package myprep;

public class EggDropProblem {

	
	//https://medium.com/@parv51199/egg-drop-problem-using-dynamic-programming-e22f67a1a7c3
	private int dp[][];

	public int superEggDrop(int eggs , int floors )
	{
		dp = new int[eggs+1][floors+1] ;
		
		for(int i=0; i<=eggs ; i++)
		{
			for(int j=0; j<=floors ; j++)
			{
				dp[i][j]= Integer.MAX_VALUE;
			}
		}
		
		return minimumEggDrops(eggs,floors);
	}
	
	private int minimumEggDrops(int eggs , int floors )
	{
		if (floors == 1 || floors == 0) {
			return floors;
		}

		if (eggs == 1) 
		{
			return floors;
		}

		int min = floors;

		for(int k=1 ; k<=floors ; k++)
		{
			int worstCaseAtNextDrop = Math.max( minimumEggDrops( eggs-1, k-1 ) , minimumEggDrops( eggs, floors-k) ) ;

			int minimumEggDropsAtK = 1 + worstCaseAtNextDrop ;

			min = Math.min( min , minimumEggDropsAtK );
		}

		dp[eggs][floors] = min;

		return dp[eggs][floors];
	}
	
	
	public static void main(String [] args)
	{
		EggDropProblem p = new EggDropProblem();
		System.out.print(p.superEggDrop(6, 10000));
	}
	
	
	
	 //https://leetcode.com/problems/super-egg-drop/discuss/159055/Java-DP-solution-from-O(KN2)-to-O(KNlogN)
	 private int helper(int K, int N, int[][] memo) 
	 {
	        if (N <= 1) {
	            return N;
	        }
	        if (K == 1) {
	            return N;
	        }
	        if (memo[K][N] > 0) {
	            return memo[K][N];
	        }
	        
	        int low = 1, high = N, result = N;
	        
	        while (low < high) 
	        {
	            int mid = low + (high - low) / 2;
	            int left = helper(K - 1, mid - 1, memo);
	            int right = helper(K, N - mid, memo);
	           
	            result = Math.min(result, Math.max(left, right) + 1);
	            
	            if (left == right) 
	            {
	                break;
	            } 
	            else if (left < right) 
	            {
	                low = mid + 1;
	            } 
	            else 
	            {
	                high = mid;
	            }
	        }
	        memo[K][N] = result;
	        return result;
	    }
	
}
