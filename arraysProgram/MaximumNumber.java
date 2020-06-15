//$Id$
package arraysProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given an array of numbers, arrange them in a way that yields the largest value. For example, if
 * the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
 *
 */

public class MaximumNumber 
{
	public static void main( String [] args )
	{
		ArrayList <Integer>list = new ArrayList<Integer>();
		
		list.add(54);
		list.add(546);
		list.add(548);
		list.add(60);
		
		findMaximum( list);
	
	}

	private static int findMaximum(ArrayList<Integer> a) 
	{
		int result  = 0;
		
		MyComparator comparator = new MyComparator();
		
		Collections.sort(a,comparator);
		
		for (Integer i : a)
		{
			System.out.print(i);
		}
		
		
		return result;
	}
	
}


class MyComparator<T> implements Comparator<Integer>
{

	@Override
	public int compare(Integer num1, Integer num2)    // if number comes as 60 , 548
	{
		String n1 = String.valueOf(num1) +  String.valueOf(num2); // then here s1 - > 60548
		String n2 = String.valueOf(num2) +  String.valueOf(num1); // then here s2 - > 54860
		
		return n1.compareTo(n2) > 0 ? -1 : 1;
		
	}
}