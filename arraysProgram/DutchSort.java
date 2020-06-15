//$Id$
package arraysProgram;

/**
 * segregate 0's and 1's and 2's 
 * 
 *
 */

public class DutchSort 
{

	public static void main( String [] args )
	{
		int arr[] = {2,0,0,1,2,1,2} ;
		sortArray(arr);

		for(int x : arr)
		{
			System.out.print(" " +x);
		}
	}
	
	private static void sortArray(int [] arr)
	{
		int low = 0;
		int high = arr.length -1;
		int start = 0;
		
		while (start < high)
		{
			if( arr[start] == 2)
			{
				swap(arr , start , high);
				high --;
			}
			else if (  arr[start] == 1 )
			{
				start ++;
			}
			else 
			{
				swap(arr , start , low);
				start ++;
				low ++;
			}
		}
	}
	
	private static void swap(int [] arr , int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
