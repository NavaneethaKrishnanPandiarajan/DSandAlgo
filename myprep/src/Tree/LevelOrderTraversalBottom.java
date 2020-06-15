//$Id$
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBottom {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null)
		{
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty())
		{
			int size = queue.size();

			List<Integer> levels = new ArrayList<Integer>();

			for(int i=0;i<size;i++)
			{
				TreeNode node = queue.poll();
				levels.add(node.val);

				if(node.left!=null)
				{
					queue.add(node.left);
				}

				if(node.right!=null)
				{
					queue.add(node.right);
				}
			}

			result.addFirst(levels);
		}

		return result;
	}

}
