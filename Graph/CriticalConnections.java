//$Id$
package Graph;

import java.util.*;

public class CriticalConnections {


	//https://leetcode.com/discuss/interview-question/372581
	
	//https://www.youtube.com/watch?v=RYaakWv5m6o - Tarjan's Algorithm
	
	int disc[];
    int low[];
    List<Integer> adj[];
    
    List<List<Integer>> ans = new LinkedList();
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        disc=new int[n];
        low=new int[n];
        adj=new List[n];
       
        for(List<Integer> list: connections) 
        {
            if(adj[list.get(0)]==null) adj[list.get(0)] = new ArrayList();
            if(adj[list.get(1)]==null) adj[list.get(1)] = new ArrayList();
            
            adj[list.get(0)].add(list.get(1));
            adj[list.get(1)].add(list.get(0));
            
        }
       
        dfs(0,-1,1);
        return ans;
    }
    
   
    public void dfs(int node, int parent, int time) 
    {
        disc[node]=time;
        low[node]=time;
        
        for(Integer neigh: adj[node]) 
        {
            if(neigh==parent)
                continue;
            
            if(disc[neigh]==0) // if node not visited already 
            {
                dfs(neigh,node,++time);  
            }
            
            low[node]=Math.min(low[node],low[neigh]);
            
            if(disc[node]<low[neigh])
            {
            	ans.add( Arrays.asList(node,neigh));
            }
               
        }
    } 
    
 
}
	
	
	

