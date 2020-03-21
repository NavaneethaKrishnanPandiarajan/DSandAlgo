//$Id$
package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find a Median in a stream of integers
 * 
 *
 */
public class MedianOfStream 
{
	
	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;
	
	
	
	public void MedianOfStream()
	{
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>( Comparator.reverseOrder());
	}
	
	public void addNumber(int element)
	{
		minHeap.offer(element);
		maxHeap.offer(minHeap.poll());
		
		if( minHeap.size() < maxHeap.size())
		{
			minHeap.offer(maxHeap.poll());
		}
	}
	
	public double findMedian()
	{
		if(minHeap.size() > maxHeap.size())
		{
            return minHeap.peek();
        }
		else 
		{
            return ( minHeap.peek() + maxHeap.peek() ) / 2.0 ;
        }
	}
	
	public static void main(String [] args )
	{
		
	}
}



