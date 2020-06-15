//$Id$
package Graph.unionFind;

public class RedundantConnection 
{
	//Problem :: https://leetcode.com/problems/redundant-connection/

	public int[] findRedundantConnection(int[][] edges) 
	{
		int res [] = new int[2];
		if(edges.length == 0 || edges[0].length == 0){

			return res;
		}

		int m = edges.length;
		int n = edges[0].length;

		UnionFind unionfind = new UnionFind(m*n);

		for(int i=0;i<m;i++){

			if(!unionfind.union(edges[i][0], edges[i][1])){

				break;
			}
		}

		return unionfind.getIndices();
	}	
}

