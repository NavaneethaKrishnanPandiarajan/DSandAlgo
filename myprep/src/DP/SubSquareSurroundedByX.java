//$Id$
package DP;
/*
 *  * 
 * Find maximum subsquare in a matrix made up of Xs and Os such that all four sides of subsquare are Xs. It does not matter what is inside
 * the subsquare. All 4 sides should be made up entirely of Xs
 * 
 * e.g 
 * 0 0 0 0 0 X         0,0  0,0  0,0  0,0  0,0  1,1
 * 0 X 0 X X X         0,0  1,1  0,0  1,1  1,2  2,3 
 * 0 X 0 X 0 X         0,0  2,1  0,0  2,1  0,0  3,1
 * 0 X X X X X         0,0  3,1  1,2  3,3  1,4  4,5
 * 0 0 0 0 0 0         0,0  0,0  0,0  0,0  0,0  0,0   
 * 
 * Output of above program should be 3
 * 
 * Solution
 * Have another matrix which is capable of holding 2 values hori and ver. 
 * Ver stores how far vertically you can see Xs. Hori stores how far horizontally you can see Xs.
 * Once this matrix is build look for biggest subsquare by getting min of hori and ver at each point and checking
 * if subsquare can be formed from value min to 1.
 * 
 * Test cases:
 * Matrix entirely made up of Xs
 * Matrix entirely made up of Os
 * Matrix with Xs and Os but maximum subsquare is length 1
 
 */
 
public class SubSquareSurroundedByX 
{
	class Cell
	{
        int ver;
        int hori;
    }
	
	
	 public int findSubSquare(char input[][])
	 {
		 int max = 1;
		 
		 Cell T[][] = new Cell[input.length][input[0].length];
		 
		 
		 // Inserting cell objects into array 
		
		 for( int i=0; i<input.length; i++)
		 {
			 for( int j=0; j< input[0].length ; j++)
			 {
				 Cell obj = new Cell();
				 
				 T[i][j] = obj;
			 }	 
		 }
		  
		 for( int i=0; i<input.length; i++)
		 {
			 for( int j=0; j< input[0].length ; j++)
			 {
				char element = input [i] [j] ; 
				
				if( element == 'X')
				{
					if( i ==0 && j == 0)
					{
						T[i][j].ver=1;
						T[i][j].hori=1;
					}
					else if( i == 0)
					{
						T[i][j].hori = T[i][j-1].hori + 1;
						T[i][j].ver = 1;
					}
					else if( j == 0)
					{
						T[i][j].ver = T[i-1][j].ver + 1;
						T[i][j].hori = 1;
					}
					else
					{
						T[i][j].hori = T[i][j-1].hori + 1;
						T[i][j].ver = T[i-1][j].ver + 1;
					}
				}
				else
				{
					 T[i][j].hori = 0;
					 T[i][j].ver = 0;					 
				}
				 
			 }	 
		 }
		 
		 
		 for(int i=T.length -1; i>=0 ;i--)
		 {
			 for(int j= T[0].length-1;  j>=0 ; j--)
			 {
				 if( T[i][j].ver == 0 || T[i][j].ver == 1 || T[i][j].hori ==1  )
				 {
	                    continue;
	             }
				 
				 int min = Math.min( T[i][j].ver,  T[i][j].hori );
				 int k =0;
				 
				 for ( k = min ; k >=0 ; k--)
				 {
					 if(T[i][j-k+1].ver >= k && T[i-k+1][j].hori >= k)
					 {
	                        break;
	                 }
				 }
				 
				 if(max < k)
				 {
	                    max = k;
	             }
			 }
		 }
		 
		 
		 
		 return max;
	 }
}
