//$Id$
package myprep;

public class MinimumDistance {

/**	
 *	
 *	Given two strings str1 and str2 and below operations that can performed on str1. 
 *  Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

	Insert
	Remove
	Replace
	
	All of the above operations are of equal cost. 
	 **/
	
	// Defining  Min Edit Distance (Levenshtein) ----> minDistance(i,j)=min(minDistance(i-1,j),minDistance(i,j-1),minDistance(i-1,j-1))+1;
	
	// Refer this video https://www.youtube.com/watch?v=b6AGUjqIPsA 
	
	public  int minDistance(String word1, String word2) 
	{
		
		int row = 0;
		int col = 0;

		if (word1 != null)
			row = word1.length();
		if (word2 != null)
			col = word2.length();

		if (row == 0 || col == 0)
			return Math.max(row, col);

		int[][] matrix = new int[row+1][col+1];

		for (int i=0;i<=row;i++)
			matrix[i][0]=i;
		
		
		for (int i=0;i<=col;i++)
			matrix[0][i]=i;
		
		//Algorithm: minDistance(i,j)=min(minDistance(i-1,j),minDistance(i,j-1),minDistance(i-1,j-1))+1;
		
		for (int i=1;i<=row;i++)
		{
			
			for (int j=1;j<=col;j++)
			{
			    
				if (word1.charAt(i-1)==word2.charAt(j-1))
			        
					matrix[i][j]=matrix[i-1][j-1];         //Remove and Add operation are not applicable.
			    else 
			        
			    	matrix[i][j] = Math.min( Math.min( matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1] )   +  1;
			}			
		}
		
		return matrix[row][col];
	} 
}
