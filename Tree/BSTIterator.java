//$Id$
package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {

	//https://leetcode.com/problems/binary-search-tree-iterator/
	
	// Idea:  InOrder Traversal of tree always gives sorted order
	
	
	Queue<Integer> elements = new LinkedList<Integer>();
	
	public BSTIterator(TreeNode root) 
	{
		populateElements(root);
    }
    
	
	public void populateElements(TreeNode root)
	{
		if(root == null)
		{
			return ;
		}
		else
		{
			populateElements(root.left);
			
			elements.add(root.val);
			
			populateElements(root.right);
		}
		
	}
	
    /** @return the next smallest number */
    public int next() 
    {
        return elements.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
    	return !elements.isEmpty();
    }
}
