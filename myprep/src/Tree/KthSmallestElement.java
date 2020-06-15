//$Id$
package Tree;

public class KthSmallestElement 
{	
	//230. Kth Smallest Element in a BST

	private int result; 
	private int count;
	
	public int kthSmallest(TreeNode root, int k) 
	{
		count = 0;
		helper(root, k);
		return result;
    }
	
	
	public void helper(TreeNode root, int k)
	{
		if(root == null)
		{
			return;
		}
		
		helper(root.left,k);
		count++;
		
		if(count == k)
		{
			result = root.val;
			return;
		}
	
		helper(root.right,k);
	}
}
