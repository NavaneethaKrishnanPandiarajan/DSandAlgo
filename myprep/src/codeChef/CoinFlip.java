//$Id$
package codeChef;

// Find the no .of Heads in given coins after performing K operations
// N - number of coins 
// K - number of opertaions
// a  - given coins 

// Operation is nothing but
		/*
		 * remove right most coin
		 * 		if removed coin is Head , then flip all the coins before them ( Head means it turns out to be tail after flipping and vice versa )
		 * 		
		 * 
		 */

/*
 * Example  
 * 
 *  Given coins H T T H T
	N - 5 ( total coins 
	K - 3 ( number of operations )
 * 
 *  after 1st operation coins will be 
 *  	  H T T H    - ( removed coin is 'T' , so flipping not happened )
 *  
 *  after 2nd operation coins will be 
 *  	  T H H      - ( removed coin is 'H' , flipping remaining coins)
 *  
 *  after 3rd operation coins will be 
 *        H T 		 - ( removed coin is 'H' , flipping remaining coins)
 */

/*
 *   after performing operations no of Heads present 1 
 */

public class CoinFlip 
{
	

	public static void main(String [] args)
	{
			
	}
	
	private int findResult(int n , int k , char a[])
	{
		
		//process coin from last 
		//Performing K operations
		// If 7 coins 3 Operations , we should processed until 4th coin ( from i=7 to 6,5, .. i=4 ) , no need to go 0th coin
		
		for(int i = n-1 ; i>= n-k  ; --i )
		{
			if(a[i] == 'H')
			{
				//flip coin from 0 to n-1 flipping the coins except the last coin 
				for(int j=0; j<n ; j++)
				{
					if(a[j] == 'H')
					{
						a[j] = 'T';
					}
					else
					{
						a[j] = 'H';
					}
				}
			}
		}
		
		
		//finding how many coins remaining as Head
		int result = 0;
		
		for(int i=0 ; i<n-k ; i++)
		{
			if(a[i] == 'H')
			{
				result ++ ;
			}
		}
		
		return result;
		
		//This method takes  o( n^2 )
	}
	
}
