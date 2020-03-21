//$Id$
package coding;

public class FindAandB {

	
	public static void main(String [] args )
	{
		int arr[] = {1,2,3,5,5};
		
		int pre = arr[0];
		
		int a = 0;
		int b = 0;
		
		for(int i=1; i< arr.length; i++)
		{			
			if(pre + 1 == arr[i])
			{
				pre = arr[i];
				continue;
			}
			else
			{
				a = arr[i];
				b = pre +1;	
				break;
			}			
		}
		
		System.out.println("A would be ---- > " + a);
		System.out.println("B would be ---- > " + b);
	}
}
