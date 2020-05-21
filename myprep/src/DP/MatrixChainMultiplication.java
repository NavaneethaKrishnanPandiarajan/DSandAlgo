//$Id$
package myprep;

public class MatrixChainMultiplication 
{
	
	static char name = 'A';
	
	private static int MatrixChainOrder(int d[], int i, int j , int dp[][] , int K[][]) 
	{
		if(i==j)
		{
			dp[i][j] = 0;
			return dp[i][j];
		}
		
		if(dp[i][j] != -1)
		{
			return dp[i][j];
		}
		
		
		int min = Integer.MAX_VALUE;
		int s = -1;
		
		for (int k=i; k<j; k++) 
		{ 
			int count = MatrixChainOrder(d, i, k , dp , K) +   MatrixChainOrder(d, k+1, j , dp , K) +  d[i-1] * d[k] * d[j] ; 

			if (count < min) 
			{
				min = count;
				s = k;
			}
				 
		} 

		dp[i][j] = min;
		K[i][j] = s;
				
		return dp[i][j]; 
	}

	
	public static void main(String [] args) 
	{ 
	    int arr[] = { 3 , 2 , 4, 2 , 5}; 
	    
	    int n = arr.length;
	    int i = 1; 
	    int j = n - 1;
	    
	    int dp[][] = new int[n][n]; 
	    int K[][] = new int[n][n];
	    
	    
	    
	    for(int a = 0; a < n; a++)
	    {
	    	for (int b = 0; b < n; b++) 
	    	{
	    		dp[a][b] = -1;
	    		K[a][b] = -1;
	    	}
	    }
	    
	    int result = MatrixChainOrder(arr, i, j, dp, K);
	    
	    System.out.println(result);
	   
	    printParenthesis(1, n-1, K);
	    
	}
	
	static void printParenthesis(int i, int j , int[][] K )  
    { 
        if (i == j) 
        { 
            System.out.print( name ++ ); 
            return; 
        } 
  
        System.out.print('('); 
  
        printParenthesis(i, K[i][j], K ); 
  
        
        printParenthesis( K[i][j] + 1, j, K ); 
  
        System.out.print(')'); 
    } 
}
