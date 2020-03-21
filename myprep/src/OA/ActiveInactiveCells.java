//$Id$
package OA;


import java.util.*;

public class ActiveInactiveCells
{        

	public static List<Integer> cellCompete(int[] states, int days)
	{
		int length = states.length;
		int tempArray [] = new int[length]; 

		while(days > 0 ){

			days--;

			for(int i=0; i<length ; i++ )
			{
				if(i==0)
				{
					if(states[1] == 1)
					{
						tempArray[0] = 1;
					}
					else
					{
						tempArray[0] = 0;
					}
				}
				else if(i== length-1)
				{
					if(states[length-2] == 1)
					{
						tempArray[length-1] = 1;
					}
					else
					{
						tempArray[length-1] = 0;
					}
				}
				else
				{
					if(states[i-1] ==  states[i+1])
					{
						tempArray[i] = 0;
					}
					else
					{
						tempArray[i] = 1;
					}
				}
			}
			
			for(int i= 0 ; i< length; i++ )
			{
				states[i] = tempArray[i];
			}
	
		}

		List<Integer> arrayList = new ArrayList<Integer>();

		for(int i=0; i<length; i++)
		{
			arrayList.add(states[i]);
		}

		return arrayList;
	}
	
	public static void main(String [] args)
	{
		int states[] = {1 , 1 , 1 , 0 , 1 , 1, 1, 1 };
		int days = 2 ;
		List <Integer> res = cellCompete(states,days);
		System.out.print(res);
	}
}
