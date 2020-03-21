//$Id$
package coding;

public class LinkedList 
{
	
	static class Node
	{
		Object data;
		Node next;
		
		Node(Object data)
		{
			this.data = data; 
		}
	}
	
	/**
	 * Add a node before the previous node
	 * @param refNode
	 * @param data
	 */
	public static Node insert_before(Node refNode , Object data)
	{
		Node new_node = new Node (data);

		new_node.next = refNode;

		refNode = new_node;

		return refNode;


	}
	
	/**
	 * Add a node after the previous node
	 * @param refNode
	 * @param data
	 */
	
	public static void insert_after(Node refNode , Object data)
	{
		Node new_node = new Node (data);
		
		new_node.next = refNode.next;
			
		refNode.next = new_node;
	}
	
	
	public static void main(String []args)
	{
		int arr[] = {1,2,3,4,5};
		
		Node ref = null;
		
		for (int a : arr)
		{
			ref = insert_before (ref , a);
		}
		
		while(ref != null)
		{
			System.out.println(ref.data);
			
			ref= ref.next;
		}
		
		
	}
	
}
