//$Id$
package AM;

public class SearchIn2DMatrix 
{
	
	public static void main(String [] args)
	{
		int [][] matrix = { {1,   4,  7, 11, 15},
							{2,   5,  8, 12, 19},
							{3,   6,  9, 16, 22},
							{10, 13, 14, 17, 24},
							{18, 21, 23, 26, 30}
						  };
		
		int target = 17;
		
		System.out.print( searchMatrix(matrix,target) );
		
	}
	
	private static boolean searchMatrix(int[][] matrix, int target) 
	{
        
        int m = matrix.length ;
        int n = matrix[0].length;
        
        int i = m - 1; 
        int j = 0; 
        
        
        while ( i >= 0  &&  j < n ) 
        {
            int num = matrix[i][j];
            
            if (num == target)
                return true;
            
            else if (num > target)        
            	i--;
        
            else
                j++;
        }
        
        return false;
    }
	
	
	//Time complexity is o ( m + n )  where m is row length and n is column length

	// we can't do binary search in both row and column  , because it is one way sorted in column and row . 
	
	// if searching element not present in the row , we can't (move mid of column) to below or above , because row and column sorted are mutually independent
	
	// so traversing from last column one by one  and choosing whether we can go with traverse based on that element
	
	// so only m + n is worst complexity 
	
	
	/*
	 * 
	    if the element is equal to target, return true;
		
	    if the element is greater than target, that means the whole row is greater than target, we can omit that row. ( i--) 
		
		else 
			 // either the element may be present in that row	
			 
			 we can move one step to j;
	 
	 	
	 	// NO need to initialise j=0 for row switch ( i = 5 to i = 4)		
	 			
	 			IMPORTANT ::   if element not present in previous j , then every row'th j element is lower than the target
	 			
	 */
	
}
