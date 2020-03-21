//$Id$
package LeetCodeProblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Input: 
	paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
	banned = ["hit"]
	Output: "ball"
	
	Explanation: 
	"hit" occurs 3 times, but it is a banned word.
	"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
	 Note that words in the paragraph are not case sensitive,
	 that punctuation is ignored (even if adjacent to words, such as "ball,"), 
	 and that "hit" isn't the answer even though it occurs more because it is banned.
 * 
 *
 */

class Solution {
    
	public String mostCommonWord(String paragraph, String[] banned) {
        
		HashMap <String, Integer> countMap = new HashMap<String,Integer>();
		
		String[] allWords = paragraph.replaceAll("[!|?|'|,|;|.]", " ").toLowerCase().split("\\s+");

		for(String word : allWords)
		{
			if( !isBannedword(word.toLowerCase() ,banned ))
			{
				int value = countMap.getOrDefault(word, 0);
				countMap.put(word.toLowerCase(), value + 1 );
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		String mostCommonword = "";
		
		
		Iterator<Entry<String, Integer>> itr = countMap.entrySet().iterator();
		
		while( itr.hasNext())
		{
			Entry<String, Integer> entry = itr.next();
			String word = entry.getKey();
			int value = entry.getValue();
			
			if( maxValue < value)
			{
				maxValue = value;
				mostCommonword = word;
			}
		}
		
		return mostCommonword;
    }
	
	public boolean isBannedword(String word , String[] banned)
	{
		boolean status = false;
		for(String s : banned)
		{
			status = s.toLowerCase().equals(word);
		}
		return status;
	}
	
		
	public static void main(String [] args )
	{
			
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String [] banned = {"hit"};
		
		Solution s = new Solution();
		String word = s.mostCommonWord(paragraph, banned);
		System.out.print(word);
		
		
	}
}
