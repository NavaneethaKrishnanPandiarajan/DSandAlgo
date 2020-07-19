//$Id$
package LeetcodeHard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne 
{

	DLLNode head;

	DLLNode tail;

	Map<Integer, DLLNode> countVsDLLNodeMap;

	// keep track of count of keys
	Map<String, Integer> keyVsCountMap;

	/** Initialize your data structure here. */

	public AllOne() 
	{

		head = new DLLNode(Integer.MIN_VALUE);
		tail = new DLLNode(Integer.MAX_VALUE);

		head.next = tail;
		tail.prev = head;

		countVsDLLNodeMap = new HashMap<Integer, DLLNode>();
		keyVsCountMap = new HashMap<String, Integer>();

	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) 
	{
		int count = keyVsCountMap.getOrDefault(key, 0);
		DLLNode node = countVsDLLNodeMap.getOrDefault(count, null);

		int newcount= count + 1;
		DLLNode newNode = countVsDLLNodeMap.getOrDefault(newcount, null);

		if( node != null)  
		{
			Set<String> keySet = node.keySet;
			keySet.remove(key);

			if(keySet.isEmpty())
			{
				removeNode(node);
				countVsDLLNodeMap.remove(count);
				keyVsCountMap.remove(key);
			}
		}

		if( newNode == null)
		{
			newNode = new DLLNode(newcount);			
		}

		newNode.keySet.add(key);
		nodeHandling(newNode);
		countVsDLLNodeMap.put(newcount,newNode);
		keyVsCountMap.put(key, newcount);

	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) 
	{
		if( !keyVsCountMap.containsKey(key) )
		{
			return;
		}

		int count = keyVsCountMap.get(key);
		DLLNode node = countVsDLLNodeMap.get(count);
		int newCount = count - 1;

		Set<String> keyset = node.keySet;
		keyset.remove(key);

		if( keyset.isEmpty())
		{
			removeNode(node);
			countVsDLLNodeMap.remove(count);
			keyVsCountMap.remove(key);
		}

		if( newCount != 0) 
		{
			DLLNode newNode = countVsDLLNodeMap.getOrDefault(newCount, null);

			if( newNode == null )
			{
				newNode = new DLLNode(newCount);
			}

			newNode.keySet.add(key);
			nodeHandling(newNode);
			countVsDLLNodeMap.put(newCount,newNode);
			keyVsCountMap.put(key, newCount);
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {

		return tail.prev == head ? "" : tail.prev.keySet.iterator().next();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {

		return head.next == tail ? "" : head.next.keySet.iterator().next();
	}


	private void nodeHandling( DLLNode newNode)
	{
		DLLNode maxNode = tail.prev;
		DLLNode minNode = head.next;

		if( maxNode == head) // First Time insertion
		{
			addNodeAtFront(newNode); // Both minimum & maximum same node 
		}
		else
		{
			if( maxNode.count <  newNode.count)
			{
				addNodeAtEnd(newNode);
			}
			else if( minNode.count > newNode.count)
			{
				addNodeAtFront(newNode);
			}
		}
	}

	private void addNodeAtEnd(DLLNode newNode) 
	{
		DLLNode node1 = tail.prev;
		DLLNode node2 = tail;

		node1.next = newNode;
		newNode.prev = node1;
		newNode.next = node2;
		node2.prev = newNode;
	}

	private void addNodeAtFront(DLLNode newNode) 
	{
		DLLNode node1 = head;
		DLLNode node2 = head.next;

		node1.next = newNode;
		newNode.prev = node1;
		newNode.next = node2;
		node2.prev = newNode;
	}

	private void removeNode(DLLNode node) 
	{
		DLLNode node1 = node.prev;
		DLLNode node2 = node.next;

		node1.next = node2;
		node2.prev = node1;
	}

	public static void main(String [] args)
	{
		AllOne obj = new AllOne();

		for(int i=1 ; i<=2; i++)
		{
			obj.inc("a");
		}

		for(int i=1 ; i<=5; i++)
		{
			obj.inc("b");
			obj.dec("b");
		}

		System.out.println(obj.getMaxKey());
		System.out.println(obj.getMinKey());

	}
}

class DLLNode
{
	int count;
	DLLNode prev;
	DLLNode next;
	Set<String> keySet;
	
	DLLNode(int count)
	{
		this.count = count;
		keySet = new HashSet<>(); // ( what are the strings are having same count )
	}
}