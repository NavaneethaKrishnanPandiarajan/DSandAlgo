//$Id$
package Tree;

public class ValidBST {
	
	public boolean isValidBST(TreeNode root) 
	{
		return helper(root, null , null);
	}
	
	
	public boolean helper (TreeNode root , Integer min, Integer max)	
	{
		if(root == null)
		{
			return true;
		}
		
		if( ( min!=null &&  root.val < min )  ||  ( max!=null &&  root.val > max ) )
		{
			return false;
		}
		
		return helper(root.right , root.val+1 , max) && helper(root.left , min , root.val-1);
	}

}
