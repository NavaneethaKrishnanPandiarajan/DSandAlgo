//$Id$
package AM;

public class MergeSortedLinkedList 
{
	
	public Node mergeList(Node p , Node q)
	{
		Node start = null;
		
		Node s = null;
		
		if(q == null)
		return p;
		
		
		if(p == null)
		return q;
		
		
		if( p.data <= q.data)
		{
			s = p;
			p = p.next;
		}
		else
		{
			s = q;
			q = q.next;
		}
		
		start = s;
		
		while( p!=null && q!=null )
		{
			if(p.data <= q.data)
			{
				s.next = p;
				s = p;
				
				p = p.next;
			}
			else
			{
				s.next = q;
				s = q;
				
				q = q.next;
			}
		}
		
		if( p == null)
		{
			s.next = q;
		}
		
		if( q == null)
		{
			s.next = p;
		}
		
		return start;
	}

	class Node 
	{ 
		int data; 
		Node next,random; 
		
		Node(int x) 
		{ 
			data = x; 
			next = random = null; 
		} 
	}
}



