//$Id$
package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class ShortestPathAlgorithms 
{
	final static int INF = Integer.MAX_VALUE;
	
	public static void main(String [] args)
	{
		Graph<Integer> g = new Graph<Integer>(true);
		
		g.addEdge(0, 1, 4); 
	    g.addEdge(0, 7, 8); 
	    g.addEdge(1, 2, 8); 
	    g.addEdge(1, 7, 11); 
	    g.addEdge(2, 3, 7); 
	    g.addEdge(2, 8, 2); 
	    g.addEdge(2, 5, 4); 
	    g.addEdge(3, 4, 9); 
	    g.addEdge(3, 5, 14); 
	    g.addEdge(4, 5, 10); 
	    g.addEdge(5, 6, 2); 
	    g.addEdge(6, 7, 1); 
	    g.addEdge(6, 8, 6); 
	    g.addEdge(7, 8, 7);
	    
	    
	    ShortestPathAlgorithms obj = new ShortestPathAlgorithms();
	    
	    Vertex<Integer> sourceVertex = g.getAllVertex().get(0);
	    
	    HashMap<Vertex<Integer>,Integer> distanceMap =  obj.dijkstraAlgo(g, sourceVertex);
	    
	    Iterator<Entry<Vertex<Integer>,Integer>> itr = distanceMap.entrySet().iterator();
	    
	    while(itr.hasNext())
	    {
	    	Entry<Vertex<Integer>,Integer> entry = itr.next();
	    	
	    	System.out.println(" " + entry.getKey().getData()  + "  ---> " + entry.getValue() );
	    }
	    
	    
	    
	    
	    
	    int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
	    
	    
	   
	    obj.floydWarshall(graph);
	}
	
	public HashMap<Vertex<Integer>,Integer> dijkstraAlgo( Graph<Integer> graph , Vertex<Integer> v1 )
	{
		
		HashMap<Vertex<Integer>,Integer> distanceMap = new HashMap<Vertex<Integer>,Integer>();
		
		for( Vertex<Integer> vertex : graph.getAllVertex().values())
		{
			distanceMap.put(vertex, Integer.MAX_VALUE);
		}
		
		distanceMap.put(v1, 0);
		
		Queue<Vertex<Integer>> q = new LinkedList<Vertex<Integer>>();
		
		q.offer(v1);
		
		while(!q.isEmpty())
		{
			Vertex<Integer> u = q.poll();

			for( Vertex<Integer> v : u.getAdjacentVertex()) 
			{
				int localWeight = distanceMap.get(u) + getWeight(u,v);

				if( localWeight < distanceMap.get(v))
				{
					
					distanceMap.put(v, localWeight);
					
					q.offer(v);
				}
			}
		}
	
		return distanceMap;
	}
	
	
	public int getWeight(Vertex<Integer> u , Vertex<Integer> v)
	{
		int weight = 0;
		
		for( Edge<Integer> edge  : u.getEdges() )
		{
			if( v.equals(edge.getVertex2()) )
			{
				weight = edge.getWeight();
				break;
			}
		}
		
		//System.out.println( "weight of "+ u.getData() + " & "  + v.getData() + " is :" + weight);
		
		return weight;
	}
	
	

	// https://www.youtube.com/watch?v=Gc4mWrmJBsw&t=152s
	// Implementing floyd warshall algorithm
	void floydWarshall(int graph[][]) 
	{
		int nV = graph[0].length;
		
		int matrix[][] = new int[nV][nV];
		
		int i, j, k;

		for (i = 0; i < nV; i++)
			for (j = 0; j < nV; j++)
				matrix[i][j] = graph[i][j];

		// Adding vertices individually
		for (k = 0; k < nV; k++) 
		{
			for (i = 0; i < nV; i++) 
			{
				for (j = 0; j < nV; j++) 
				{
					if (matrix[i][k] + matrix[k][j] < matrix[i][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}
		printMatrix(matrix);
	}

	void printMatrix(int matrix[][]) 
	{
		int nV = matrix[0].length; 
		
		for (int i = 0; i < nV; ++i) 
		{
			for (int j = 0; j < nV; ++j) 
			{
				if (matrix[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(matrix[i][j] + "  ");
			}
			
			System.out.println();
		}
	}
}
