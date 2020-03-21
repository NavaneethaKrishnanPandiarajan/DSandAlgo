//$Id$
package coding;
import java.util.*;

public class LongestWord {

	public static void main(String[] args) 
	{
		String s ="Today is the happiest day of my life";
		System.out.println( Arrays.stream( s.split(" ") ).max(Comparator.comparingInt(String::length)).orElse(null));
	}


}