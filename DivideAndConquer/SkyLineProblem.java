//$Id$
package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SkyLineProblem {

	// https://www.youtube.com/watch?v=GSBLe8cKu0s&t=579s 
	// Instead of PriorityQueue here TreeSet is used 
	
	public List<List<Integer>> getSkyline(int[][] buildings) 
	{
	    List<List<Integer>> res = new ArrayList<>();
	    TreeSet<Integer> pq = new TreeSet<>(Collections.reverseOrder());
	    Map<Integer, Integer> freq = new HashMap<>();
	    List<Point> points = getPoints(buildings);
	    
	    pq.add(0);
	    freq.put(0, 1);
	    
	    for (Point p : points) 
	    {
	        int before = pq.first();
	       
	        if (p.isStart)   // If that point is start 
	        {
	            pq.add(p.y);
	            freq.put(p.y, freq.getOrDefault(p.y, 0) + 1);
	        } 
	        else 			 // If that point is end
	        {
	            freq.put(p.y, freq.getOrDefault(p.y, 0) - 1);
	            
	            if (freq.get(p.y) == 0) 
	            {
	                pq.remove(p.y);
	            }
	        }
	        
	        int after = pq.first();
	        if (after != before)   // If changes in priority queue , we have to add the result 
	        {
	            res.add(new ArrayList<>(Arrays.asList(p.x, after)));
	        }
	    }
	    
	    return res;
	}

	private List<Point> getPoints(int[][] buildings) 
	{
	    List<Point> points = new ArrayList<>();
	    
	    for (int[] p : buildings) 
	    {
	        points.add(new Point(p[0], p[2], true));
	        points.add(new Point(p[1], p[2], false));
	    }
	    
	    Collections.sort(points);
	    
	    return points;
	}

	class Point implements Comparable<Point> 
	{
	    int x, y;
	    boolean isStart;
	    
	    Point(int x, int y, boolean isStart) 
	    {
	        this.x = x;
	        this.y = y;
	        this.isStart = isStart;
	    }
	    
	    public int compareTo(Point o) 
	    {
	        if (this.x != o.x) 
	        {
	            return this.x - o.x;
	        } 
	        else 
	        {
	            // for both start points, first enqueue the taller
	            // for both end points, first dequeue the shorter
	            // for one start and one end points, first do enqueue
	            return (this.isStart ? -this.y : this.y) - (o.isStart ? -o.y : o.y);
	        }
	    }
	}
	
	
    
	public List<List<Integer>> getSkylineDivideAndConquerMethod(int[][] buildings) 
	{
		List<List<Integer>> res = new ArrayList<>();
		if (buildings.length == 0) return res;
		int n = buildings.length;
		return findSkyline(buildings, 0, n - 1);
	}

	private List<List<Integer>> findSkyline(int[][] buildings, int lo, int hi) 
	{
		List<List<Integer>> res = new LinkedList<>();
		
		if (lo == hi) 
		{
			res.add(Arrays.asList(buildings[lo][0], buildings[lo][2]));
			res.add(Arrays.asList(buildings[lo][1], 0));
			return res;
		}
		
		int mid = lo + (hi - lo) / 2;
		
		List<List<Integer>> skyline1 = findSkyline(buildings, lo, mid);
		List<List<Integer>> skyline2 = findSkyline(buildings, mid + 1, hi);
		
		return mergeSkyline(skyline1, skyline2);
	}

	private List<List<Integer>> mergeSkyline(List<List<Integer>> skyline1, List<List<Integer>> skyline2)
	{
		List<List<Integer>> res = new LinkedList<>();
		int i = 0, j = 0;
		int h1 = 0, h2 = 0;

		while (i < skyline1.size() && j < skyline2.size()) 
		{
			int x1 = skyline1.get(i).get(0);
			int x2 = skyline2.get(j).get(0);
			int x;
			
			if (x1 < x2) 
			{
				h1 = skyline1.get(i++).get(1);
				x = x1;
			}
			else if (x1 > x2) 
			{
				h2 = skyline2.get(j++).get(1);
				x = x2;
			} 
			else 
			{
				h1 = skyline1.get(i++).get(1);
				h2 = skyline2.get(j++).get(1);
				x = x1;
			}
			
			int h = Math.max(h1, h2);
			
			if (res.isEmpty() || h != res.get(res.size() - 1).get(1))
			{
				res.add(Arrays.asList(x, h));
			}
		}

		while (i < skyline1.size()) 
		{
			res.add(skyline1.get(i++));
		}
		
		while (j < skyline2.size())
		{
			res.add(skyline2.get(j++));
		}

		return res;
	}
}


