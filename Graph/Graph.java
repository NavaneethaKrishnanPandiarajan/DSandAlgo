//$Id$
package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> 
{
	private List<Edge<T>> allEdges;
	private Map<T,Vertex<T>> allVertex;
	boolean isDirected = false;

	public Graph(boolean isDirected)
	{
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<T,Vertex<T>>();
		this.isDirected = isDirected;
	}

	public void addEdge(T data1, T data2)
	{
		addEdge(data1,data2,0);
	}

	public void addEdge(T data1 ,T data2, int weight)
	{
		Vertex<T> vertex1 = null;

		if(allVertex.containsKey(data1))
		{
			vertex1 = allVertex.get(data1);
		}
		else
		{
			vertex1 = new Vertex<T>(data1);
			allVertex.put(data1, vertex1);
		}

		Vertex<T> vertex2 = null;
		if(allVertex.containsKey(data2))
		{
			vertex2 = allVertex.get(data2);
		}
		else{
			vertex2 = new Vertex<T>(data2);
			allVertex.put(data2, vertex2);
		}

		Edge<T> edge = new Edge<T>(vertex1,vertex2,weight);
		allEdges.add(edge);
		
		vertex1.addAdjacentVertex(edge, vertex2);

		if(!isDirected)
		{
			vertex2.addAdjacentVertex(edge, vertex1);
		}
	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public void setAllEdges(List<Edge<T>> allEdges) {
		this.allEdges = allEdges;
	}

	public Map<T, Vertex<T>> getAllVertex() {
		return allVertex;
	}

	public void setAllVertex(Map<T, Vertex<T>> allVertex) {
		this.allVertex = allVertex;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}
	
	
}


class Vertex<T>
{
	T data;
	List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();
	List<Edge<T>> edges = new ArrayList<Edge<T>>(); // No of Incoming Edges Coming to this Vertex
	
	public Vertex(T data)
	{
		this.data = data;
	}
	
	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) 
    {
        edges.add(e);
        adjacentVertex.add(v);
    }

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<Vertex<T>> getAdjacentVertex() {
		return adjacentVertex;
	}
	public void setAdjacentVertex(List<Vertex<T>> adjacentVertex) {
		this.adjacentVertex = adjacentVertex;
	}
	public List<Edge<T>> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge<T>> edges) {
		this.edges = edges;
	}

}

class Edge<T> implements Comparable<Edge<T>> 
{
	int weight;
	Vertex<T> vertex1;
	Vertex<T> vertex2;

	
	public Edge( Vertex<T> vertex1 , Vertex<T> vertex2)
	{
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	
	public Edge( Vertex<T> vertex1 , Vertex<T> vertex2 , int weight)
	{
		this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Vertex<T> getVertex1() {
		return vertex1;
	}
	public void setVertex1(Vertex<T> vertex1) {
		this.vertex1 = vertex1;
	}
	public Vertex<T> getVertex2() {
		return vertex2;
	}
	public void setVertex2(Vertex<T> vertex2) {
		this.vertex2 = vertex2;
	}

	@Override
	public int compareTo(Edge<T> compareEdge) {
		return this.weight - compareEdge.weight;
	}
	
	
}