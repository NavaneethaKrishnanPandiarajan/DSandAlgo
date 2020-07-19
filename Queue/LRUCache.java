//$Id$
package Queue;

import java.util.HashMap;
import java.util.Map;

// Need to redesign this code for better handling of multithreaded environment
public class LRUCache 
{
        class DNode 
    	{
             int key;
             int value;
             DNode prev;
             DNode next;
    	}
    
	private int maxCapacity;

	private Map<Integer, DNode> hashtable = null; 
	private DNode head = null;
        private DNode tail = null;
	private int totalItemsInCache = 0;


	public LRUCache(int capacity)
	{
		this.maxCapacity = capacity;
		totalItemsInCache = 0;

		head = new DNode();
		tail = new DNode();
		hashtable = new ConcurrentHashMap<Integer, DNode>();
		
		head.prev = null;
		tail.next = null;
		
		head.next = tail;
		tail.prev = head;
	}

	public int get( int key)
	{
		DNode node = hashtable.get(key);

		if( node != null)
		{
			moveToFront(node);

			return node.value;
		}
		else
		{
			return -1;	
		}
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

	private synchronized void addNode(DNode node) 
	{
		// Wire the node being inserted
		node.prev = head;
		node.next = head.next;

		// Re-wire the head's old next
		head.next.prev = node;

		// Re-wire the head to point to the inserted node
		head.next = node;

	}

	private synchronized void removeNode(DNode node) 
	{

		// Grab reference to the prev and next of the node
		DNode savedPrev = node.prev;
		DNode savedNext = node.next;

		// Cut out going forwards
		savedPrev.next = savedNext;

		// Cut out going backards
		savedNext.prev = savedPrev;
	}
	
	
	public static void main(String [] args)
	{
		
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);          	        // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    			// evicts key 1
		System.out.println(cache.get(1));	// returns -1 (not found)
		System.out.println(cache.get(3));	// returns 3
		System.out.println(cache.get(4));	// returns 4
	}
}
