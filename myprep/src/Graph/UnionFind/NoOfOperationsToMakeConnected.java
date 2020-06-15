//$Id$
package Graph.unionFind;

public class NoOfOperationsToMakeConnected {
	
	
	//problem : https://leetcode.com/problems/number-of-operations-to-make-network-connected/
	
	 public int makeConnected(int n, int[][] connections) 
	 {

		 UnionFind unionFind = new UnionFind(n);


		 int redundantConnections = 0;

		 for( int [] connection : connections )
		 {
			 int a = connection[0];
			 int b = connection[1];

			 if( !unionFind.union(a, b) ) //loop found
			 {
				 redundantConnections ++;
			 }
		 }

		 int numberOfGroups = 0;
		
		 for(int i = 0; i < n; i++)
		 {
			 //if parent and element same , it is not assoicated with any loop
			 if(i == unionFind.find(i))   // How many single group present  
			 {
				 numberOfGroups++;
			 }	 
		 }

		 if(numberOfGroups - 1 > redundantConnections)   // ( numberOfGroups-1 ---> means we are removing one main group count )  
		 {
			 return -1;
		 }
		 else
		 {
			 return numberOfGroups - 1; 
		 }
	        
	 }
	
	
}

