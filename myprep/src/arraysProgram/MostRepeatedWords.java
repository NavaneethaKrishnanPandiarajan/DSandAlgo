//$Id$
package arraysProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class MostRepeatedWords {

	public static void main(String [] args)
	{
		Map<String,Integer> wordVsCount = new HashMap<String,Integer>();
		
		BufferedReader reader = null;
		
		try
		{
			String filePath ="";
			reader = new BufferedReader(new FileReader(filePath));
			
			String currentLine = reader.readLine();
			
			while( currentLine!= null)
			{
				String[] words = currentLine.split(" ");
				
				for(String word : words)
				{
					wordVsCount.put(word, wordVsCount.getOrDefault(word, 1));
				}
				
				currentLine = reader.readLine();
			}
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	
}


class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        
        if( nums1.length >  nums2.length)
        {
           return findMedianSortedArrays(nums2,nums1);
        }
        
        int low = 0;
        int high = nums1.length;
        
        int x = nums1.length;
        int y = nums2.length;
        
        double result = 0;    
        
        while ( low <= high)
        {
            int partitionx = (low + high)/2;
            int partitiony = (x+y+1)/2 - partitionx;
            
            int maxLeftx = (partitionx == 0 ) ? Integer.MIN_VALUE : (nums1[partitionx - 1]);
            int minRightx = ( partitionx == 0 ) ? Integer.MAX_VALUE : (nums1[partitionx ]);
            
            int maxLefty = (partitiony == 0 ) ? Integer.MIN_VALUE : (nums2[partitiony - 1]);
            int minRighty = (partitiony == 0 ) ? Integer.MAX_VALUE : (nums2[partitiony]);
            
            if( maxLeftx <= minRighty && maxLefty <= minRightx )
            {
                if( (x+y) %2 == 0 )
                {
                   result = ( Math.max(maxLeftx,maxLefty) + Math.min(minRightx,minRighty) ) / 2.0 ;
                }
                else
                {
                   result =  Math.max(maxLeftx,maxLefty);
                }
            }
            else if ( maxLeftx > minRighty )
            {
                high = partitionx - 1;
            }
            else
            {
                low = partitionx + 1;
            }
                     
        }
        
        return result;
    }
}
