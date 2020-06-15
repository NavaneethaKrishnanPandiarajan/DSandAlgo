//$Id$
package arraysProgram;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortByFrequencyWords 
{

	public static void main(String [] args)
	{
		String s = "aaabccxxxz";
		
		String res = sortByFrequencey(s);
		
		System.out.print(res);
	}

	private static String sortByFrequencey(String s) 
	{
		int length = s.length();
		
		Map<Character,Integer> charVsCount = new HashMap<Character,Integer>();
		
		for(int i=0; i<length; i++)
		{
			charVsCount.put(s.charAt(i), (int)charVsCount.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		charVsCount = sortByValues(charVsCount);
		
		System.out.println(charVsCount);
		
		StringBuilder builder = new StringBuilder();
		
		Iterator <Entry<Character, Integer>> itr = charVsCount.entrySet().iterator();
		
		while( itr.hasNext())
		{
			Map.Entry<Character, Integer> entry = itr.next();
			
			Character c = entry.getKey() ;
			
			Integer count = entry.getValue() ;
		
			if( count.intValue() > 0)
			{
				for( int i = 0 ; i < count ; i++)
				{
					builder.append(c.charValue());
				}
			}
			
		}
		
		return builder.toString();
	}
	
	private static Map sortByValues(Map map)
	{

		Map<Character,Integer> sortedMap = new TreeMap<Character,Integer>(new ValueComparator(map));
		sortedMap.putAll(map);
		return sortedMap;
	
	}
	
}

class ValueComparator implements Comparator<Character> 
{
	Map<Character,Integer> map;
 
	public ValueComparator(Map<Character,Integer> map) {
		this.map = map;
	}
 
	public int compare(Character keyA, Character keyB) 
	{
		Integer x = (Integer) map.get(keyA);
		Integer y = (Integer) map.get(keyB);


		int freqCompare = x.compareTo(y);
		
		int valueCompare = keyA.compareTo(keyB);

		if (freqCompare == 0) 		 
		{
			return valueCompare;
		}
		else
		{
			return freqCompare;
		}
		
	}

	
}