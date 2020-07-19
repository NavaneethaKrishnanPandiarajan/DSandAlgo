//$Id$
package LeetcodeHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection 
{
    
    List<Integer> userValues = null;
    Map<Integer,Set<Integer>> userValuesVsArrayListIndex = null;
    java.util.Random rand = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
        userValues = new ArrayList<Integer>();
        userValuesVsArrayListIndex = new HashMap<Integer,Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        if( userValuesVsArrayListIndex.containsKey(val)) // Already Element is there 
        {
            
            Set<Integer> indexes = userValuesVsArrayListIndex.get(val);
            indexes.add(userValues.size());
            userValues.add(val); 
            
            userValuesVsArrayListIndex.put(val,indexes);
            return false;
        }
        else
        {
            Set<Integer> indexes = new LinkedHashSet<Integer>();
            indexes.add(userValues.size());
            userValues.add(val);
            
            userValuesVsArrayListIndex.put(val,indexes);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) 
    {
    
        if( userValuesVsArrayListIndex.containsKey(val)) // Already Element is there 
        {
        	// Get arbitary index of the ArrayList that contains val
            Set<Integer> valSet = userValuesVsArrayListIndex.get(val);
            int indexToReplace = valSet.iterator().next();
            
            // Obtain the set of the number in the last place of the ArrayList
            int numAtLastPlace = userValues.get(userValues.size() - 1);
            Set<Integer> replaceWith = userValuesVsArrayListIndex.get(numAtLastPlace);
            
            // Replace val at arbitary index with very last number
            userValues.set(indexToReplace, numAtLastPlace);
            
            // Remove appropriate index
            valSet.remove(indexToReplace);
            
            // Don't change set if we were replacing the removed item with the same number
            if(indexToReplace != userValues.size() - 1) {
                replaceWith.remove(userValues.size() - 1);
                replaceWith.add(indexToReplace);
            }
            
            userValues.remove(userValues.size() - 1);
            
            if(userValuesVsArrayListIndex.get(val).isEmpty())
            {
            	userValuesVsArrayListIndex.remove(val);
            }
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
 // Get linearly random item
    public int getRandom() 
    {    
        return userValues.get((int)(Math.random() * userValues.size()));
    }
    
    
    public static void main(String [] args)
    {
    	RandomizedCollection obj = new RandomizedCollection();
    	
    	boolean param_1 = obj.insert(0);
    	boolean param_2 = obj.remove(0);
    	boolean param_3 = obj.insert(-1);
    	boolean param_4 = obj.remove(0);
//    	int param_4 = obj.getRandom();
//    	boolean param_5 = obj.remove(-1);
//    	boolean param_6 = obj.insert(-2);
//    	int param_7 = obj.getRandom();
    	
    	
    	System.out.println(param_1);
    	System.out.println(param_2);
    	System.out.println(param_3);
//    	System.out.println(param_4);
//    	System.out.println(param_5);
//    	System.out.println(param_6);
//    	System.out.println(param_7);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */