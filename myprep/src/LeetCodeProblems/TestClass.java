//$Id$
package LeetCodeProblems;

public class TestClass {

	public static void main(String [] args)
	{
		String paragraph = "word two";
		String [] splittedwords = paragraph.split("\\s");
		
		for(String s : splittedwords)
		{
			System.out.println (s);
		}
	}
}
