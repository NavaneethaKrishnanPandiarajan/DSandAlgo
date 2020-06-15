//$Id$
package Tree;

public class TreeNode 
{	   
	public TreeNode left, right;
	public Integer val; 
	 
	 public TreeNode(int data)
	 {
		 this.val = data;
		 this.left = this.right = null;
	 }

}
