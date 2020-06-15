//$Id$
package Tree;

public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) 
	{
		int start = 0;
		int end = nums.length-1;
		
		return helper(start,end,nums);
	}
	
	
	public TreeNode helper( int start , int end , int[] nums)
	{
		if( start > end)
		{
			return null;
		}
		
		int midIndex = start + ((end - start)/2);
		
		TreeNode headNode = new TreeNode(nums[midIndex]);
		
		headNode.left = helper(start,midIndex-1, nums);
		headNode.right = helper(midIndex+1,end, nums);
		
		return headNode;
	}
}
