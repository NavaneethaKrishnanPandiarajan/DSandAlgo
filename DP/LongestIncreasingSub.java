//$Id$
package DP;

import java.util.Arrays;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence 
 * 
 * such that all elements of the subsequence are sorted in increasing order. 
 * 
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * 
 *
 */

public class LongestIncreasingSub 
{

		public static int getLengthOfLIS(int arr[])
		{
			int maximumSofar = 1;
			
			int[] maxLength = new int[arr.length];
			
			Arrays.fill(maxLength, 1);
			
			for(int i=1; i < arr.length; i++)
			{
				for( int j=0; j < i ; j++)
				{
					if( arr[i] > arr[j])
					{
						maxLength [i] = Math.max( maxLength[i], maxLength[j]+1);
					}
				}
				
				maximumSofar = Math.max(maximumSofar, maxLength[i]);
			}
			
			return maximumSofar;
		}
		
		public static void main(String args[]) 
	    { 
	        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
	        
	        System.out.println("Length of Longest Increasing Subsequence is " + getLengthOfLIS(arr) + "\n"); 
	    } 
}
