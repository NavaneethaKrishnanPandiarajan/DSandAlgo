//$Id$
package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstructBTFromTraversals {
	
	// 105. Construct Binary Tree from Preorder and Inorder Traversal
	//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	//https://www.youtube.com/watch?v=PoBGyrIWisE
	 	
	 HashMap<Integer,Integer> inorderMap;
	 int index;
	 
	 public TreeNode buildTree(int[] preorder, int[] inorder) 
	 {
		 inorderMap = new HashMap<Integer,Integer>();
		 
		 for(int i=0;i<inorder.length;i++)
		   inorderMap.put(inorder[i],i);
		
		 int start = 0;
		 int end  = inorder.length - 1;
		 index = 0;
		 
		 return findRootNode(0,end,preorder,inorder);
	 }

	 
	 public TreeNode findRootNode(int start, int end , int[] preorder,int[] inorder)
	 {	 
		 if( start > end )
		 {
			 return null;
		 }
		 
		 int var = preorder[index++];
		 	
		 TreeNode rootNode = new TreeNode(var);
		 
		 int rootIndex = inorderMap.get(var);
		 
		 int newleftStartIndex = start;
		 int newleftEndIndex  =  rootIndex-1; 		 
		 
		 int newrightStartIndex = rootIndex+1;
		 int newrightEndIndex = end;
		 
		 rootNode.left = findRootNode(newleftStartIndex,newleftEndIndex,preorder,inorder);
		 rootNode.right = findRootNode(newrightStartIndex,newrightEndIndex,preorder,inorder);
		 
		 return rootNode;
	 }
	 
	 
	 public static void main(String [] args)
	 {
		 int inorder[] = {9,3,15,20,7};
		 int preorder[] = {3,9,20,15,7};
		 
		 ConstructBTFromTraversals obj = new ConstructBTFromTraversals();
		 
		 TreeNode node = obj.buildTree(preorder, inorder);
		 
		 System.out.print(node);
	 }
	 
}

