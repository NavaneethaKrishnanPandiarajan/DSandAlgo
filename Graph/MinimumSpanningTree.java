//$Id$
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MinimumSpanningTree 
{
	
	// Kruskal’s Minimum Spanning Tree Algorithm
	
	// https://www.youtube.com/watch?v=EjVHtpWkIho
	
	// Prim's Minimum Spanning Tree Algorithm
	
	// https://www.youtube.com/watch?v=ZtZaR7EcI5Y
	
	// DisjointSet or UnionFind - Explanation by Tushor roy : https://www.youtube.com/watch?v=ID00PMy0-vE&t=860s
	
	// DisjointSet is being used here to find cycle 
	
	public static void main(String [] args)
	{
		Graph<Integer> graph = new Graph<Integer>(false);

		graph.addEdge(0,1,10);
		graph.addEdge(0,2,6);
		graph.addEdge(0,3,5);
		graph.addEdge(1,3,15);
		graph.addEdge(2,3,4);
		
		MinimumSpanningTree obj = new MinimumSpanningTree();
		
		obj.kruskalMST(graph);
		
		System.out.println("-----");
		
		obj.primsMST(graph);
	}
	
	
	public void primsMST(Graph<Integer> graph)
	{
		DisjointSet set  = getDisJointSet(graph);
		
		List<Edge<Integer>> edgesInPrims = new ArrayList<Edge<Integer>>();
		
		for(  Vertex<Integer> vertex : graph.getAllVertex().values())
		{
			List<Edge<Integer>> edges = vertex.getEdges();
			
			Collections.sort(edges);
			
			Edge<Integer> edge = edges.get(0);
			
			if( edgesInPrims.isEmpty())
			{
				set.union(edge.getVertex1().getData(), edge.getVertex2().getData());
				
				edgesInPrims.add(edge);
			}
			else
			{
				int parent1 = set.findSet(edge.getVertex1().getData());
				int parent2 = set.findSet(edge.getVertex2().getData());
				
				if( parent1 != parent2)
				{
					set.union(edge.getVertex1().getData(), edge.getVertex2().getData());
					edgesInPrims.add(edge);
				}
			}
		}
		
		
		Iterator<Edge<Integer>> itr = edgesInPrims.iterator();
		
		while(itr.hasNext())
		{
			Edge<Integer> edge = itr.next();
			
			System.out.println(edge.getVertex1().getData()+" -- " +  edge.getVertex2().getData()+" == " + edge.weight); 
		}
	}
	
	
	
	
	
	public void kruskalMST(Graph<Integer> graph) 
	{
		DisjointSet set  = getDisJointSet(graph);
		
		List<Edge<Integer>> edges =  graph.getAllEdges();
		
		Collections.sort(edges);
		
		Iterator<Edge<Integer>> itr = edges.iterator();
		
		List<Edge<Integer>> edgesInMST = new ArrayList<Edge<Integer>>();
		
		while(itr.hasNext())
		{
			Edge<Integer> edge = itr.next();
			
			if( edgesInMST.isEmpty())
			{
				set.union(edge.getVertex1().getData(), edge.getVertex2().getData());
				
				edgesInMST.add(edge);
			}
			else
			{
				int parent1 = set.findSet(edge.getVertex1().getData());
				int parent2 = set.findSet(edge.getVertex2().getData());
				
				if( parent1 != parent2)
				{
					set.union(edge.getVertex1().getData(), edge.getVertex2().getData());
					edgesInMST.add(edge);
				}
			}
		}
		
		itr = edgesInMST.iterator();
		
		while(itr.hasNext())
		{
			Edge<Integer> edge = itr.next();
			
			System.out.println(edge.getVertex1().getData()+" -- " +  edge.getVertex2().getData()+" == " + edge.weight); 
		}
	}
	
	public DisjointSet getDisJointSet(Graph<Integer> graph)
	{
		DisjointSet set = new DisjointSet();

		for( int data : graph.getAllVertex().keySet() )
		{
			set.makeSet(data);
		}
		
		return set;
	}
}
