//$Id$
package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseAndDeserialise 
{
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if (root == null)
        {
            return "X,";
        }
        
        String leftSubtree = serialize(root.left);
        String rightSubTree = serialize(root.right);
        
        return root.val+","+ leftSubtree + rightSubTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        Queue<String> nodesLeft = new LinkedList<String>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }
    
    public TreeNode deserializeHelper(Queue<String> nodesLeft) {
        String valueOfCurrentNode =  nodesLeft.poll();
        
        if(valueOfCurrentNode.equals("X"))
        {
            return null;
        }
        else
        {
             TreeNode newNode = new TreeNode(Integer.valueOf(valueOfCurrentNode));
        
             newNode.left = deserializeHelper(nodesLeft);
             newNode.right = deserializeHelper(nodesLeft);
        
             return newNode;
        }
       
    }
}


