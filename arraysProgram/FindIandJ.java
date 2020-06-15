//$Id$
package arraysProgram;

/**
 * Algorithm to find the maximum difference of j - i such that a[j] > a[i], for a given an array of 'n' elements.
 * 
 * 
 *
 */
	/*  Create 2 Auxilary Arrays say Lmin[] and Rmax[] of the same size as main array
		
		Put Lmin[0]=arr[0] and Rmax[Rmax.length-1] =arr[arr.length-1]
		
		Traverse the main array and fill the Lmin array with the index position which has the minimum value so far
		
		Traverse the main array backwords and fill the Rmax array with the index position which has the maximun value so far
		
		Initialize distance_so_far = -1
		
		Navigate through the main array and if (Lmin[i]<Rmax[i])
		
		Then check if (Rmax[i]-Lmin[i])>distance_so_far then distance_so_far = Rmax[i]-Lmin[i]
		
		Return distance_so_far
	 * 
	 */

public class FindIandJ 
{

	public static void main(String [] args)
	{
		int [] arr = { 12, 3, 1, 5, 6, 4, 10, 9, 8, 0 };
		
		findIandJ(arr);
	}

	private static void findIandJ(int[] arr) 
	{
		
		int lmin[] = new int[arr.length];
		int rmax[] = new int[arr.length];
		
		
		int leftMinValue = arr[0];
		int rightMaxValue = arr[arr.length - 1];
		
		
		
		for(int i=0 ; i<arr.length; i++)
		{
			if(leftMinValue > arr[i])
			{
				leftMinValue = arr[i];
			}
			
			lmin[i] = leftMinValue;
		}
		
		for(int j=arr.length - 1; j>=0 ; j--)
		{
			if( rightMaxValue < arr[j])
			{
				rightMaxValue = arr[j];	
			}
			
			rmax[j] = rightMaxValue;
		}
		
		
		int i=0 , j=0 , distance_so_far = -1 ;
		
		int index_i = -1;
		int index_j = -1;
		
		
		while ( i < arr.length && j < arr.length)
		{
			if( lmin[i] < rmax[j])
			{
				if( j - i  >  distance_so_far)
				{
					distance_so_far = j - i ;
					
					index_i = i;
					index_j = j;
				}
				
				j++;
			}
			else
			{
				i++;
			}
		}
		
		System.out.println("ith Index " +index_i );
		System.out.println("jth Index " +index_j   );
		System.out.println(distance_so_far);
	}
	
}
