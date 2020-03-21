//$Id$
package Queue;

import java.util.HashMap;
import java.util.Map;

public class LRUCache 
{
	private int maxCapacity;

	private Map<Integer, DNode> hashtable = new HashMap<Integer, DNode>();
	private DNode head, tail;
	private int totalItemsInCache;


	public LRUCache(int capacity)
	{
		this.maxCapacity = capacity;
		totalItemsInCache = 0;

		head = new DNode();
		tail = new DNode();

		head.prev = null;
		tail.next = null;


		head.next = tail;
		tail.prev = head;
	}

	public int get( int key) throws Exception
	{
		DNode node = hashtable.get(key);

		if( node == null)
		{
			throw new Exception ("Item Not Found in Cache");
		}

		moveToFront(node);

		return node.value;
	}



	public void put( int key , int value)
	{

		DNode node = hashtable.get(key);

		if( node!= null ) //If item already present in cache
		{
			node.value = value;  //updating value

			moveToFront(node);    // Moving that to front
		}

		else
		{
			DNode newNode = new DNode();

			newNode.key = key;

			newNode.value = value;

			hashtable.put(key, newNode);

			addNode(newNode);

			totalItemsInCache ++;

			if( totalItemsInCache > maxCapacity)
			{
				removeLRUEntryFromStructure();
			}
		}

		totalItemsInCache ++;
	}

	/*
    Remove the least used entry from the doubly linked
    list as well as the hashtable. Hence it is evicted
    from the whole LRUCache structure
	 */
	private void removeLRUEntryFromStructure() 
	{
		DNode tail = popTail();
		
		hashtable.remove(tail.key);
		
		--totalItemsInCache;
	}

	/*
    Pop the last item from the structure
	 */
	
	private DNode popTail(){
		DNode itemBeingRemoved = tail.prev;
		removeNode(itemBeingRemoved);
		return itemBeingRemoved;
	}
	
	
	
	/*
    Move a node to the head of the doubly linked lsit
	 */
	private void moveToFront(DNode node)
	{
		removeNode(node);
		addNode(node);
	}

	private void addNode(DNode node) 
	{
		// Wire the node being inserted
		node.prev = head;
		node.next = head.next;

		// Re-wire the head's old next
		head.next.prev = node;

		// Re-wire the head to point to the inserted node
		head.next = node;

	}

	private void removeNode(DNode node) 
	{

		// Grab reference to the prev and next of the node
		DNode savedPrev = node.prev;
		DNode savedNext = node.next;

		// Cut out going forwards
		savedPrev.next = savedNext;

		// Cut out going backards
		savedNext.prev = savedPrev;
	}


}




class DNode 
{
    int key;
    int value;
    DNode prev;
    DNode next;
}