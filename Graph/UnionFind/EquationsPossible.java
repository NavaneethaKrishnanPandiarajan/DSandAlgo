//$Id$
package Graph.unionFind;

public class EquationsPossible {

	//problem :: https://leetcode.com/problems/satisfiability-of-equality-equations/

	public boolean equationsPossible(String[] equations) 
	{
		if (equations == null || equations.length == 0) 
		{
			return false;
		}
		
		UnionFind unionFind = new UnionFind(26);
		
		
		for( String s : equations )
		{
			char symbol = s.charAt(1);
			
			if( symbol == '=')
			{
				int a = s.charAt(0) - 'a' ;
				int b = s.charAt(3) - 'a' ;
				
				unionFind.union(a, b);
			}
		}
		
		
		
		for( String s : equations )
		{
			char symbol = s.charAt(1);
			
			if( symbol == '!')
			{
				int a = s.charAt(0) - 'a' ;
				int b = s.charAt(3) - 'a' ;
				
				if( unionFind.find(a) ==  unionFind.find(b) )       // if both are present in union ( united by equation == , but now != present so equation fails )
				{
					return false;
				}
			}
		}
	
		return true;	
	}
	
}



