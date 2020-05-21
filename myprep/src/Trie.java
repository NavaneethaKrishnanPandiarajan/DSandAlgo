import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Trie 
{
	private TrieNode root;

	public Trie() 
	{
		root = new TrieNode();
	}

	public boolean isEmpty() 
	{
		return root == null;
	}

	public void insert(String word) 
	{
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) 
		{
			if(  current.getChildren().get(word.charAt(i))  == null  )
			{
				current.getChildren().put(word.charAt(i), new TrieNode());
			}

			current = current.getChildren().get(word.charAt(i));
		}

		current.setEndOfWord(true);
	}

	
	public boolean isWordPresent(String word)
	{			
		return search( word,true );
	}
	
	
	public boolean isPrefixPresent(String prefix)
	{			
		return search( prefix,false );
	}
	
	
	private boolean search( String word , boolean isWholeWordSearch )
	{
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++)
		{
			current = current.getChildren().get(word.charAt(i)) ;

			if ( current == null )
			{
				return false;
			}	
		}
		
		if( isWholeWordSearch )
		{
			return current.isEndOfWord();
		}
		else
		{
			return true;
		}
	}
	
	
	public List<String> getPrefixMatchedWords(String prefix)
	{
		List<String> res = new ArrayList<>();
		
		TrieNode current = root;

		for (int i = 0; i < prefix.length(); i++)
		{
			current = current.getChildren().get(prefix.charAt(i)) ;
			
			if( current == null)
			{
				return res;
			}
		}
		
		
		if(current.isEndOfWord())
		{
			res.add(prefix);
		}

		getPrefixMatchedWords(res, prefix , current);
		
		return res;
	}

	
	
	private void getPrefixMatchedWords( List<String> results, String cur, TrieNode curNode )
	{
		if( curNode == null)
		{
			return ;
		}
		
		Map<Character, TrieNode> childMap = curNode.getChildren();
		
		for( Character character : childMap.keySet())
		{
			
			TrieNode node = childMap.get(character);
			String newchar = cur+character;
			
			if(node.isEndOfWord())
			{
				results.add(newchar);
			}
			
			getPrefixMatchedWords(results,newchar,node);
		}
	}
}

class TrieNode 
{
	private final Map<Character, TrieNode> children = new LinkedHashMap<>();
    private boolean endOfWord;
    
    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
