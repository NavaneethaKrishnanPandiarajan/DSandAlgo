//$Id$
package myprep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakProblem 
{
	
	 /**
	  *       dp[i] = {  
	  *       			 true    , dp[k]  = true && subString[k,i] is present in dictionary 
	  *       			 false   ,  otherwise 
	  *               }	
	  *  
	  *  	  Example 
	  *  		
	  *  		word : leetcode
	  *  
	  *  		dictionary 	- [ leet , code ]
	  *  
	  *  		
	  *  		0 1 2 3 4 5 6 7					leet
	  *         l e e t c o d e        dp[8] = dp[4] && SubString[4,8] (code) is present in dictionary 
	  * 
	  * 		0 1 2 3 4 5 6 7 8	   dp[4] = dp[0] && substring[0,4] (leet) is present in dictionary	
	  * dp[] =  T F F F T F F F T 							
	  *  							    
	  */
	

	 public boolean wordBreak(String s, List<String> wordDict) 
	 {
		  return checkWordOptimised(s, wordDict);
	 }
	 
	 
	 
	 private boolean checkWord(String s, List<String> wordDict)
	 {
		 Set<String> dictionary = new HashSet<String>(wordDict);
		 
		 boolean dp[] = new boolean[ s.length() + 1 ] ;
		 dp[0] =  true ;
		 
		 for(int i=0 ; i<s.length() ; i++)
		 {
			 if( dp[i])
			 {
				 for( int j=i+1 ; j<=s.length() ; j++ )
				 {
					 String subString = s.substring(i, j);
					 
					 if( dictionary.contains(subString))
					 {
						 dp[j] = true;
					 }
				 }
				 
			 }
		 }
		 
		 return dp[s.length()];
	 }
	 
	 
	 
	 private boolean checkWordOptimised(String s, List<String> wordDict)
	 {
		 
		 boolean dp[] = new boolean[ s.length() + 1 ] ;
		 dp[0] =  true ;
		 
		 for(int i=0 ; i<s.length() ; i++)
		 {
			 if( dp[i])
			 {		 
				 // we are iterated over the word dictionary and put it into the set already in previous case , 
				 //we can use that iteration . This will save lot of time  
				 
				 for( String word  : wordDict)
				 {
					 int j = i + word.length();
					 
					 if( j<= s.length() && s.substring(i, j).equals(word))
					 {
						 dp[j] = true;
					 }
				 }
				 
			 }
		 }
		 
		 return dp[s.length()];
	 }
	 	 
}
