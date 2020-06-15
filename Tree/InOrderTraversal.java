//$Id$
package Tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

	
	public List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> list = new ArrayList<Integer>();
		 
        if(root == null)
        {
            return list;
        }

        helper(list,root);
        
        return list;
    }
    
    public void helper(List<Integer> list , TreeNode root)
    {
        if(root == null )
        {
            return ;
        }
        
        helper(list , root.left);
        list.add(root.val);
        helper(list , root.right);
    }
}
