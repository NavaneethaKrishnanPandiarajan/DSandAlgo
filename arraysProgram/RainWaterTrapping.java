//$Id$
package GS;

public class RainWaterTrapping {

	public static int totalWaterTrapped(int arr[])
	{
		
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		
		left[0]=0;
		
		for(int i=1 ; i<arr.length; i++)
		{
			left[i] = Math.max(left[i-1] , arr[i]);
		}
		
		right[arr.length-1] = arr[arr.length-1];
		
		for(int i=arr.length-2 ; i>0 ; --i)
		{
			right[i] = Math.max(right[i+1], arr[i]);
		}
		
		
		int water = 0;
		
		for(int i=0 ;i<arr.length ; i++)
		{
			int currentWater = Math.min(left[i], right[i]) - arr[i];
			water = water + currentWater;
		}
		
		return water;
	}
}
