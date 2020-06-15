//$Id$
package myprep;

import java.util.PriorityQueue;

public class MergeKSortList {

	// problem :  https://leetcode.com/problems/merge-k-sorted-lists/

	public ListNode mergeKLists(ListNode[] lists) {

		if(lists.length<=0)
		{
			return null;
		}


		PriorityQueue<ListNode> pq = new PriorityQueue<>( (l1, l2) -> l1.val - l2.val );

		for( ListNode headNodeIneachList  :  lists )
		{
			pq.offer(headNodeIneachList);
		}

		if(pq.isEmpty())
		{
			return null;
		}

		
		ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
		while (!pq.isEmpty() ) 
		{
			ListNode node = pq.poll();
			
			if (node.next != null) 
			{
				pq.offer(node.next);
				node.next = null;
			}
			p.next = node;
			p = p.next;
		}

		return dummy.next;
		
	}
	

}



class ListNode 
{
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
