//$Id$
package OA;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class nonRepeatingDigitProductCount {



    // Complete the nonRepeatingDigitProductCount function below.
    static int nonRepeatingDigitProductCount(int x, int y, int z) {

      int count = 0;  
      
      for(int i=y ; i<=z ; i++)
      {
          int product = x * i;
          if( isValid(product , i) )
          {
        	 System.out.println(product);
        	 System.out.println(i);
        	 
             count ++; 
          }
      } 

      return count;
    }

    static boolean isValid(int product , int i)
    {
        boolean isValid = true;
        
        if( product==0 && i==0)
        {
            return false;
        }

        Set<Integer> productDigits = getDigitsAsSet(product);
        Set<Integer> multiplierDigits = getDigitsAsSet(i);

        Iterator<Integer> itr = multiplierDigits.iterator();

        while(itr.hasNext())
        {
            int digit = itr.next();
            if(productDigits.contains(digit))
            {
                isValid = false;
                break;
            }
        }
        
        return isValid;
    }

    static Set getDigitsAsSet(int number)
    {
        Set<Integer> s = new HashSet<Integer>();

        while(number > 0)
        {
            int digit = number % 10;
            s.add(digit);
            number = number/10;
        }

        return s;
    }


    public static void main(String[] args) throws IOException 
    {

    	int x = 1; 
    			
    	int y = 0;
    	
    	int z = 99;
    	
        int res = nonRepeatingDigitProductCount(x, y, z);

        System.out.print(res);
    }
}
