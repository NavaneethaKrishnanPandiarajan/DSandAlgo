//$Id$
package myprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordBreakProblem2 
{
	
	private Set<String> set;
	
	public List<String> wordBreak2(String s, List<String> wordDict)
	{
		List<String> result = new ArrayList(); 
        set = new HashSet<String>(wordDict); 
        
        dfs(s, result, 0, null);
        
        return result;
	}
	
	public void dfs(String s, List<String> result , int start , String curr)
	{
		if(start >= s.length())
		{
			result.add(curr); 
			return; 
		}

		for(int i = start; i < s.length(); i++)
		{
			String sub = s.substring(start, i + 1); 
			if(set.contains(sub))
			{
				
				curr = (curr == null ? sub : curr + " " + sub);
				dfs(s,result, i+1 , curr); 
			}

		}
	}
	
		
	 public List<String> wordBreak(String s, List<String> wordDict)
	 {
		 List<String> index = new ArrayList<String>();
	
		 HashMap<Integer,Node> map = new HashMap<Integer,Node>();
		 boolean dp[]= new boolean[ s.length() + 1 ] ;
		 dp[0] =  true ;
		 
		 
		 for(int i=0 ; i<s.length() ; i++)
		 {
			 if( dp[i])
			 {		 
				 for( String word  : wordDict)
				 {
					 int j = i + word.length();
					 
					 if( j<= s.length() && s.substring(i, j).equals(word))
					 {
						 dp[j] = true;
						  
						 Node node = map.getOrDefault(i, new Node(i));
						 Node childnode = map.getOrDefault(j, new Node(j));
						 
						 node.addChild(childnode);
					 
						 map.put(i, node);
						 map.put(j, childnode);
					 }
				 }
				 
			 }
		 }
		 
		 List<String> result = new ArrayList<String>();
		 
		 if(dp[s.length()])
		 {
			 getWords(map.get(0) , s , result , "");
		 }

		 System.out.print(result);
		 
		 return result;
	 }
	 
	 private void getWords(Node head , String s, List<String> result , String wordSofar)
	 {
		 if( head.getChildNode().isEmpty())
		 {
		
			 if( head.data == s.length() )
			 {
				 result.add(wordSofar.trim());
			 }
			 
			 return;
		 }
		 else
		 {
			 int start = head.data;
			 
			 Iterator<Node> itr = head.getChildNode().iterator();
			
			 while(itr.hasNext())
			 {
				 Node child = itr.next();
				 
				 String subString  = s.substring(start, child.data);
				 
				 getWords(child , s , result , wordSofar + subString+" " );
			 }
		 } 
	 }
	 
	 
	 public static void main(String [] args)
	 {
		 String s = "abcd";
		 
		 List<String> dict = new ArrayList<String> ();
		 dict.add("a");
		 dict.add("abc");
		 dict.add("b");
		 dict.add("cd");
		 
		 WordBreakProblem2 p = new WordBreakProblem2();
		 p.wordBreak(s, dict);
	 }
	 
}

class Node  
{ 
    int data; 
    List<Node> childNodes = new ArrayList<Node>(); 
   
    Node(int item)  
    { 
        data = item; 
    } 
    
    public void addChild(Node child )
    {
    	childNodes.add(child);
    }
    
    public List<Node> getChildNode()
    {
    	return childNodes;
    }
}
