//$Id$
package Tree;

public class RecoverTree {
	// problem ::  https://leetcode.com/problems/recover-binary-search-tree/
	
	
	 TreeNode []swapNodes = new TreeNode[2];
	 TreeNode prev = null;
	 
	 public void recoverTree(TreeNode root) 
	 {
		 inOrderHelper(root);
		 
		 if(swapNodes[0]!=null && swapNodes[1]!=null)
		 {
			 int temp = swapNodes[0].val;
			 swapNodes[0].val = swapNodes[1].val;
			 swapNodes[1].val = temp;
		 }
	 }
	 
	 public void inOrderHelper(TreeNode curr)
	 {
		 if(curr == null)
		 {
			 return;
		 }
		 
		 inOrderHelper(curr.left);
		 
		 if( prev!= null &&  curr.val < prev.val )
		 {
			 if(swapNodes[0] == null)
			 {
				 swapNodes[0] = prev;
			 }
			 
			 swapNodes[1] = curr;
			 
		 }
		 
		 prev = curr;
		 
		 inOrderHelper(curr.right);
	 }
}
