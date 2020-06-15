//$Id$
package OA;

public class ClusterTruckProblem 
{
	
	public static int count = 0;
	public static final int rows = 4;
	public static final int columns = 4;
	public static boolean[][] alreadyVisited;
	
	public static void main(String [] args)
	{
		
		int m[][] = { {1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1} };
		
		alreadyVisited =  new boolean[rows][columns];
		
		for(int i=0 ;i<rows ; i++)
		{
			for(int j=0; j<columns ; j++)
			{
				alreadyVisited[i][j] = false;
			}
		}
		
		for(int i=0 ;i<rows ; i++)
		{
			for(int j=0; j<columns ; j++)
			{
				boolean isAlreadyvisited = alreadyVisited[i][j] ;
				
				if( !isAlreadyvisited )
				{
					boolean status = checkIfOne(m, i ,j );
					
					if(status)
					{
						count ++ ;
					}
				}
			}
		}
		
		System.out.println(count);
		
	}
	
	
	private static boolean checkIfOne(int m[][] , int i , int j )
	{
		boolean currentstatus = false;
		boolean right = false;
		boolean left = false;
		boolean down = false;
		boolean up  = false;
		
	
		if( i!=-1  && j!=-1 && i < rows && j < columns && !alreadyVisited[i][j])
		{
			int currentelement = m[i][j];
			
			if( currentelement == 1 )
			{
				alreadyVisited[i][j] = true;
				
				currentstatus = true;
				
				right = checkIfOne(m, i , j+1  );
				left = checkIfOne(m , i , j-1  );
				down = checkIfOne(m , i+1 ,j  );
				up = checkIfOne(m , i-1 , j);
				
			}
		}
	
		return currentstatus || right || left || down || up ;
	}
		
		
	
}
