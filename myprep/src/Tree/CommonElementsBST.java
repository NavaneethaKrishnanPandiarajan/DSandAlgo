//$Id$
package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class CommonElementsBST {
	
	
	private static  void getCommonElementsBST(TreeNode root1 , TreeNode root2)
	{
		
		HashSet<Integer> elements = new HashSet<Integer>();
		
		traversal( root1 , elements);
		
		traversal2( root2 , elements);

	}
	
	static void traversal(TreeNode root1 , HashSet<Integer> elements)
	{
		if(root1 == null)
		{
			return ;
		}
		
		traversal(root1.left,elements);
		
		elements.add(root1.val);
		
		traversal(root1.right,elements);
	}
	
	
	static void traversal2(TreeNode root2 , HashSet<Integer> elements)
	{
		if(root2 == null)
		{
			return ;
		}
		
		traversal2(root2.left,elements);
		
		int data = root2.val;
		
		if( elements.contains(data) )
		{
			System.out.println(data);
		}
		
		traversal2(root2.right,elements);
	}
	
	
	
	
	
	
	
	static TreeNode insert(TreeNode node, int data)  
	{  
	    /* If the tree is empty, return a new TreeNode */
	    if (node == null) 
	    	return new TreeNode(data);  
	  
	    /* Otherwise, recur down the tree */
	    if (data < node.val)  
	        node.left = insert(node.left, data);  
	    else if (data > node.val)  
	        node.right = insert(node.right, data);  
	  
	    /* return the (unchanged) TreeNode pointer */
	    return node;  
	} 
	
	
	
	public static void main(String [] args)
	{
		TreeNode root1 = null;  
	    root1 = insert(root1, 5);  
	    root1 = insert(root1, 1);  
	    root1 = insert(root1, 10);  
	    root1 = insert(root1, 0);  
	    root1 = insert(root1, 4);  
	    root1 = insert(root1, 7);  
	    root1 = insert(root1, 9);  
	  
	    // Create second tree as shown in example  
	    TreeNode root2 = null;  
	    root2 = insert(root2, 10);  
	    root2 = insert(root2, 7);  
	    root2 = insert(root2, 20);  
	    root2 = insert(root2, 4);  
	    root2 = insert(root2, 9); 
	    
	    
	    getCommonElementsBST(root1,root2);
	    
	}
}
