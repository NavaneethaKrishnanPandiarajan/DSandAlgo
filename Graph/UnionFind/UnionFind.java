//$Id$
package Graph.unionFind;

public class UnionFind
{
		
	int parents[];
	private int circleCount ;
	int indices [] = new int [2];
	
	public UnionFind(int size)
	{
		parents = new int[size];
		
		for(int i=0 ;i<size ;i++)
		{
			parents[i] = i;
		}
	}
		
	
	public int find(int x)
	{
		if(parents[x] == x)
		{
			return parents[x];
		}
		
		parents[x] = find(parents[x]);
		
		return parents[x];
	}
	
	public boolean union(int a , int b)
	{
		int groupA = find(a);
		int groupB = find(b);
		
		if( groupA!=groupB)
		{
			parents[groupA]= groupB;
			circleCount --;
			return true;
		}
		else  		// already in loop , we found loop
		{
			indices[0] = a;
            indices[1] = b;
            
			return false;
		}
	}
	
	public void setCircleCount(int circleCount)
	{
		this.circleCount = circleCount;
	}
	
	public int getCircleCount()
	{
		return circleCount;
	}
	
	public int[] getIndices()
	{  
        return indices;
    }
}
