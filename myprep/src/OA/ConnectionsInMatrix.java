//$Id$
package OA;

public class ConnectionsInMatrix 
{

	public static final int rows = 3;
	public static final int columns = 4;
	public static boolean[][] alreadyVisited;
	
	public static void main(String [] args)
	{
		
		int m[][] = { {1,0,0,1},{0,1,1,1},{1,0,0,1} };
		
		alreadyVisited =  new boolean[rows][columns];
		
		for(int i=0 ;i<rows ; i++)
		{
			for(int j=0; j<columns ; j++)
			{
				alreadyVisited[i][j] = false;
			}
		}
		
		int connections = 0;
		
		for(int i=0 ;i<rows ; i++)
		{
			for(int j=0; j<columns ; j++)
			{
				boolean isAlreadyvisited = alreadyVisited[i][j] ;
				
				if( !isAlreadyvisited && m[i][j] == 1)
				{
					connections = check(m, i, j, connections);
				}
			}
		}
		
		System.out.println(connections);
		
	}
	
	
	private static int check(int m[][] , int i , int j ,  int connections)
	{
	
		if( j+1 < columns && !alreadyVisited[i][j+1])
		{
			int rightElement =  m[i][j+1];
			
			if( rightElement == 1)
			{
				connections ++;
			}
		}
		
		if( j-1 >= 0 && !alreadyVisited[i][j-1])
		{
			int leftElement = 	m[i][j-1];
			
			if( leftElement == 1)
			{
				connections ++;
			}
		}
		
		if( i-1 >= 0 && !alreadyVisited[i-1][j] )
		{
			int aboveElement =  m[i-1][j];
			
			if( aboveElement == 1)
			{
				connections ++;
			}
		}
			
		if( i+1 < rows && !alreadyVisited[i+1][j] )
		{
			int belowElement =  m[i+1][j];
			if( belowElement == 1)
			{
				connections ++;
			}
		}
		
		if( i-1 >=0 && j-1 >= 0 && !alreadyVisited[i-1][j-1])
		{
			int diagonalElement1 = m[i-1][j-1];
			if( diagonalElement1 == 1)
			{
				connections ++;
			}
		}
	
		if( i+1 < rows && j+1 < columns && !alreadyVisited[i+1][j+1])
		{
			int diagonalElement2 = m[i+1][j+1];
			if( diagonalElement2 == 1)
			{
				connections ++;
			}
		}
		
		if( i+1 < rows && j-1 >= 0 && !alreadyVisited[i+1][j-1])
		{
			int diagonalElement3 = m[i+1][j-1];
			if( diagonalElement3 == 1)
			{
				connections ++;
			}
		}
		
		if( i-1 >=0 && j+1<columns && !alreadyVisited[i-1][j+1])
		{
			int diagonalElement4 = m[i-1][j+1];
			if( diagonalElement4 == 1)
			{
				connections ++;
			}
		}
		
		alreadyVisited[i][j]=true;
		
		return connections;
	}
		
		
	

}
