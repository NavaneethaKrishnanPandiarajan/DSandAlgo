//$Id$
package Graph.unionFind;

public class FriendCircle 
{	 
	
	 // Problem : https://leetcode.com/problems/friend-circles/
	 // UnionFind : http://www.goodtecher.com/union-find/
	 // Problem Explanation : https://www.youtube.com/watch?v=C3ZK3RRNZtc&t=55s
	
	 public int findCircleNum(int[][] M) 
	 {
		 if(M.length == 0 || M[0].length == 0)
		 {
			 return 0;
		 }
		 
		 int m = M.length; 
		 int n = M[0].length;
		 
		 UnionFind unionFind = new UnionFind(m);
		 unionFind.setCircleCount(m);
		 
		 
		 for(int i=0 ; i<m ;i++)
		 {
			 for(int j=0 ; j<n ;j++)
			 {
				 if(M[i][j] == 1 && i!=j)
				 {
					 unionFind.union(i, j);
				 }
			 }
		 }
		 
		 
		 return unionFind.getCircleCount();
	 }
}

