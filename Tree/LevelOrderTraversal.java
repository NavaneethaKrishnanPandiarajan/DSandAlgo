//$Id$
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) 
	{

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null)
		{
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		
		while( !queue.isEmpty() )
		{
			int size = queue.size();
			
			List<Integer> levelNodes = new ArrayList<Integer>();
			
			for( int i=0 ; i<size; i++ )
			{
				TreeNode sameLevelNode = queue.poll();
				levelNodes.add(sameLevelNode.val);
				
				if(sameLevelNode.left!=null)
				{
					queue.add(sameLevelNode.left);
				}
				if(sameLevelNode.right!=null)
				{
					queue.add(sameLevelNode.right);
				}
			}
			
			result.add(levelNodes);
		}
			
		return result;
	}

}
