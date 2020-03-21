//$Id$
package coding;


import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class GuessNumber {
	
	public static int no_of_retry = 0;
	
    public static void main(String args[] ) throws Exception {
      
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());    // NO OF TEST CASES;
        
        
        while( t!=0 )
        {
        	t --;
        	 	
        	int a = Integer.parseInt(br.readLine());
        	
        	int b = Integer.parseInt(br.readLine());
        	
        	no_of_retry = Integer.parseInt(br.readLine());
        	       	
        	int arr[] = new int[b+1];
        	
        	int j=0;
        	
        	for(int i=a; i<=b; i++)
        	{
        		arr[j] = i;
        		j++;
        	}
        	
        	int n = arr.length; 
        	
        	binarySearch(arr,0,n);
        	
        }
              
        
    }
    
    
    static void binarySearch(int arr[], int l, int r) throws Exception
    { 
        if (r >= l) 
        { 
        	if( no_of_retry == 0)
        	{
        		return;
        	}
        	
        	no_of_retry --;
        	
            int mid = l + (r - l) / 2; 
      
            System.out.println(arr[mid] );
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String state = br.readLine();    // NO OF TEST CASES;
            
            if (state.equals("CORRECT")) 
               return; 
      
            
            if (state.equals("TOO_BIG")) 
                binarySearch(arr, l, mid - 1); 
      
           
             binarySearch(arr, mid + 1, r); 
        } 
          
    } 
}
