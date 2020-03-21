//$Id$
package arraysProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByFrequency {
	
	public static void main(String [] args) throws Exception
	{
		int [] arr = { 2, 5, 2, 6, -1, 999, 5, 8, 8, 8 };
		
		sortArray(arr);
	}
	
	private static void sortArray(int [] arr) throws Exception
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(int element : arr)
		{
			int count =  map.getOrDefault(element, 1);
			
			map.put(String.valueOf(element), count+1);
			
		}
		
		sortByValue(map);
 		
		System.out.println(map);
	}
	
	
	public static void sortHashMapByValues(HashMap<Integer, Integer> map) 
	{
		
	}
	
	
	// function to sort hashmap by values 
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
}




