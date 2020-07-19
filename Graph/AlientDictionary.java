//$Id$
package Graph;

import java.util.Deque;

public class AlientDictionary 
{
	/**
	 * 
	 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
	 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
	 * Derive the order of letters in this language.

			For example,
			Given the following words in dictionary,

			[
			   "wrt",
			   "wrf",
			   "er",
			   "ett",
			   "rftt"
			]

			The correct order is: "wertf".
	 **/



	public static void main(String args[]) 
	{
		AlientDictionary ad =  new AlientDictionary();
		String[] words1 = {"zy","zx"};
		String[] words = {"wrt","wrf","er","ett","rftt"};
		String[] words2 = {"wrtkj","wrt"};
		
		String result = ad.alienOrder(words);
		
		System.out.print(result);


		//w -> e
		// e -> r
		//t -> f
		//r -> t
		//
	}

	private String alienOrder(String[] words) 
	{
		Graph<Character> graph = buildGraph(words); 
		
        TopologicalSort<Character> sort = new TopologicalSort<Character>();
        Deque<Vertex<Character>> result = sort.topSort(graph);
		
        StringBuilder builder = new StringBuilder();
        
        while(!result.isEmpty())
        {
        	builder.append(result.poll().getData());
        }
        
		return builder.toString();
	}

	
	private Graph<Character> buildGraph(String[] words) 
	{
		Graph<Character> graph = new Graph<Character>(true);
		
		for( String word : words)
		{
			char[] chars = word.toCharArray();
		
			for(int i=0 ; i<chars.length - 1; i++)
			{
				char currentWord = chars[i];
				char nextWord = chars[i+1];
				
				graph.addEdge(currentWord, nextWord);
			}
		}
		
		return graph;
	}
}
