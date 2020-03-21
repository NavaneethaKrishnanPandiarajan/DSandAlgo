//$Id$
package arraysProgram;

/**
 * 
 * Algorithm to merge an array of size 'n' into another array of size 'm+n'
 *
 * There are two sorted arrays. First one is of size m+n containing only m elements. 
 * Another one is of size n and contains n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.
 * 
 * 
 */

public class MergeArray 
{

	public static void main(String[] args)
	{
		int mPlusN [] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		
		int N [] = {5, 7, 9, 25};
		
		int mandn = mPlusN.length;
		
		int n = N.length;
		
		moveToEnd (mPlusN,mandn);
		
		merge(mPlusN, N, mandn - n , n); 
		
		printArray(mPlusN, mandn); 
		
	}
	
	public static void moveToEnd(int mPlusN[], int size)  
    { 
        int i, j = size - 1; 
        for (i = size - 1; i >= 0; i--)  
        { 
            if (mPlusN[i] != -1)  
            { 
                mPlusN[j] = mPlusN[i]; 
                j--; 
            } 
        } 
    } 
	
	
	public static void merge(int mPlusN[], int N[], int m, int n)  
    { 
        int i = n; 
          
        /* Current index of i/p part of mPlusN[]*/
        int j = 0; 
          
        /* Current index of N[]*/
        int k = 0; 
          
        /* Current index of of output mPlusN[]*/
        while (k < (m + n))  
        { 
            /* Take an element from mPlusN[] if 
            a) value of the picked element is smaller and we have 
                not reached end of it 
            b) We have reached end of N[] */
            if ((i < (m + n) && mPlusN[i] <= N[j]) || (j == n))  
            { 
                mPlusN[k] = mPlusN[i]; 
                k++; 
                i++; 
            }  
            else // Otherwise take element from N[] 
            { 
                mPlusN[k] = N[j]; 
                k++; 
                j++; 
            } 
        } 
    }
	
	public static void printArray(int arr[], int size)  
    { 
        int i; 
        for (i = 0; i < size; i++)  
            System.out.print(arr[i] + " "); 
  
        System.out.println(""); 
    } 
  
}
