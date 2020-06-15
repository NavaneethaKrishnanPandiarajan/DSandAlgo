//$Id$
package Example;

import java.util.ArrayList;
import java.util.List;


/**
 
A string S of lowercase letters is given. We want to partition this string into as many parts as possible 

so that each letter appears in at most one part, 

and return a list of integers representing the size of these parts.


Input: S = "ababcbacadefegdehijhklij"

Output: [9,7,8]

Explanation:
			The partition is "ababcbaca", "defegde", "hijhklij".
			This is a partition so that each letter appears in at most one part.
			A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 
 
 * 
 *
 */
public class PartitionLabels {
	
	public static void main(String [] args)
	{
		String s = "ababcbacadefegdehijhklij";
		
		System.out.print( partitionLabels (s) );
	}
	
	public static List<Integer> partitionLabels(String S) 
	{
        List<Integer> res= new ArrayList<>();
        int[] last= new int[26];
        int len=S.length();
        char[] sc= S.toCharArray();
        
        for(int i=0;i<len;i++)
        {
            last[sc[i]-'a']=i;   //find the each letter's last occurrence at store them in an array 
        }
        
        int start=-1,end=-1;
        
        for(int i=0;i<len;i++)
        {
        	if(start==-1) 
        	start=i;
        	
        	end= Math.max(end,last[sc[i]-'a']);
        	
        	if(end==i)
        	{ 
        		res.add(end-start+1);
        		start=-1;
        	}
        }
        
        return res;
    }
}
