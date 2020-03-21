//$Id$
package arraysProgram;

import java.util.Arrays;

public class minimumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] { 0,3,3,7,5,3,11,1 };
		
		int result = minSum(arr);
		
		System.out.println(result);
		

	}
	
	public static int minSum(int[] A)
	{
		
		
		Arrays.sort(A);
		int[] result = new int[A.length];
		
		int minDiff=Integer.MAX_VALUE;
		int currDiff=0;
		
		for (int i= 0;i<A.length-1;i++ )
		{
			currDiff=A[i+1]-A[i];
			if(minDiff>currDiff)
				minDiff=currDiff;				
			
		}
		if (minDiff==Integer.MAX_VALUE)
		return -2;
		else if(minDiff>100000000)
		return -1;
		else
		return minDiff;
	}

}
