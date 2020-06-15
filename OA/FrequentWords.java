//$Id$
package AM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 *  
 * Given a list of reviews, a list of keywords and an integer k. 
 * Find the most popular k keywords in order of most to least frequently mentioned.

	The comparison of strings is case-insensitive.
	Multiple occurrences of a keyword in a review should be considered as a single mention.
	If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 * 
 * 
 */

/**
	
	Input:
	k = 2
	keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
	
	reviews = [
  				"I love anacell Best services; Best services provided by anacell",
  				  "betacellular has great services",
  				  "deltacellular provides much better services than betacellular",
  				  "cetracular is worse than anacell",
  				  "Betacellular is better than deltacellular.",
  			  ]
	Output:
  			  ["betacellular", "anacell"]
	
	Explanation:
		
		"betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.

	

**/

public class FrequentWords 
{
	
	private List<String> getMostPopularWords(String[] reviews , String[] keywords , int k)
	{
		List<String> result  =new ArrayList<>();
		
		Map<String,Integer> hm =new HashMap<>();
		
		for( String w :keywords)
		{
			w = w.toLowerCase(); 
			hm.put(w, 0);
		}
		
		
		for( String word :reviews)
		{
			word = word.toLowerCase();
			
			String splittedWords[] = word.split("");
			
			for( String s: splittedWords)
			{
				if(hm.containsKey(s))
				{
					hm.put(s, hm.get(s)+1);
				}
			}
		}
		
		PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<>
			
				( (a, b)-> a.getValue()==b.getValue()  ?  b.getKey().compareTo(a.getKey())  :  b.getValue() -a.getValue()  );
        
		
		pq.addAll(hm.entrySet());
		
        
        while( k > 0)
        {
        	k--;
        	
        	result.add(pq.poll().getKey());
        }
        
        
		return result;
	}	
}


