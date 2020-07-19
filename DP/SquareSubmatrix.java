//$Id$
package dp;

public class SquareSubmatrix {



	public int maximalSquare(char[][] arr) 
	{
		if(arr.length==0) return 0;
		
		// Initialize cache. Don't need to initialize // to -1 because the only cells that will be // 0 are ones that are false and we want to // skip those ones anyway
		int[][] cache = new int[arr.length][arr[0].length];
		
		int max = 0;
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < arr[0].length; j++) 
			{ 
				if (arr[i][j] == '1') 
					max = Math.max(max,squareSubmatrix(arr, i, j, cache)); 
			}
		}
		
		
		return max * max; 
	}
	
	
	 
	// Overloaded recursive function
	private int squareSubmatrix(char[][] arr, int i, int j, int[][] cache) 
	{
		if (i == arr.length || j == arr[0].length)
			return 0;
		if (arr[i][j] == '0') return 0;
		
		// If the value is set in the cache return // it. Otherwise compute and save to cache if (cache[i][j] > 0) return cache[i][j]; cache[i][j] = 1 + Math.min(Math.min(
		if (cache[i][j] > 0) return cache[i][j]; 
			
			// why minimum is used :: if any of the part of the sub square is 0 Then , we should take the count of sub Square it as 0 
			
			cache[i][j] = 1 + Math.min( Math.min(
				squareSubmatrix(arr, i+1, j, cache),
				squareSubmatrix(arr, i, j+1, cache)),
				squareSubmatrix(arr, i+1, j+1, cache));
		
	   return cache[i][j];
	}
}
