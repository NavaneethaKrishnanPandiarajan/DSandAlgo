//$Id$
package GoldManSachs;


/**
 *  a/b + c/d
 * 
 *  
 * 
**/
public class AddFraction 
{
	
	
	public static void main( String [] args )
	{
		int numerator1 = 5;
		int denominator1 = 4;
		
		int numerator2 = 7;
		int denominator2 = 8;
		
		
		int numerator = ( numerator1 * denominator2 ) + (  numerator2 * denominator1  ) ;
		int denominator = denominator1 * denominator2;
		
		int gcd = getGcd( numerator, denominator);
	
		numerator = numerator/gcd;
		denominator = denominator/gcd;
		
		System.out.print( "The added and reduced fraction is " + numerator + "/" + denominator);
	}
	
	
	public static int getGcd(int a , int b)
	{
		if(a == 0 )
		{
			return b;
		}
		
		return getGcd(b%a , a);
	}
	

	
}
