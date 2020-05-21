//$Id$
package Example;

public class UniqueCharacterInString 
{	
	
	//Refer ::
	// https://medium.com/@shashankmohabia/bitwise-operators-facts-and-hacks-903ca516f28c
	
	// Idea is to  
	//				set the n'th bit in the number 
	
	public static boolean uniqueCharacters(String str) 
    { 
        // Assuming string can have characters a-z 
        // this has 32 bits set to 0 
        int checker = 0; 
  
        for (int i = 0; i < str.length(); i++) 
        { 
            int bitAtIndex = str.charAt(i) - 'a'; 
  
            // if that bit is already set in checker, 
            // return false 
            if (  (checker & (1 << bitAtIndex)  ) > 0 ) 
                return false; 
  
            // otherwise update and continue by 
            // setting that bit in the checker 
            checker = checker | (1 << bitAtIndex); 
        } 
  
        // no duplicates encountered, return true 
        return true; 
    } 
	
	public static void main(String args[]) 
    { 
        
        String input = "gks"; 
  
        if ( uniqueCharacters(input) ) 
            System.out.println("The String " + input 
                               + " has all unique characters"); 
        else
            System.out.println("The String " + input 
                               + " has duplicate characters"); 
        
        
        System.out.println(1<<1);
        
        System.out.println(1<<2);
        
        System.out.println(1<<3);
         
        System.out.println(1<<4);
        
        System.out.println(1<<5);
        
        
        System.out.println( 4 & 8);
        
        System.out.println( 29 | 1);
    } 
}
