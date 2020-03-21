//$Id$
package OA;


public class MinimumCostPath {
	
	public static final int rows = 5;
	public static final int columns = 5;
	public static boolean[][] alreadyVisited;
	
	public static void main(String [] args )
	{
		int m[][] = { {31, 100, 65, 12, 18}, {10, 13, 47, 157, 6}, { 100 ,113, 174, 11, 33} ,{88, 124, 41, 20, 140}, {99, 32, 111, 41, 20}};
		
		
		alreadyVisited =  new boolean[rows][columns];
		
		for(int i=0 ;i<rows ; i++)
		{
			for(int j=0; j<columns ; j++)
			{
				alreadyVisited[i][j] = false;
			}
		}
		
		int cost = 0;
		
		MinElement currElement = new MinElement(0,0);
		currElement.setPrevious(null);
		currElement.setMinCost(m[0][0]);
		alreadyVisited[0][0]=true;
			
		while(true)
		{
			System.out.print(m[currElement.getX()][currElement.getY()]);
			MinElement nextElement = getNextMinElement( m , currElement );
			currElement = nextElement;
			
			if(currElement.getX() == (rows - 1)  && currElement.getY() == (columns -1))
			{
				break;
			}
		}
		
		System.out.println("");
		System.out.println(currElement.getCost());
	}
	

	
	private static MinElement getNextMinElement(int[][] m, MinElement currElement) 
	{
	
		int i = currElement.getX();
		int j = currElement.getY();
		
		int minCostSofar = Integer.MAX_VALUE;
		
		int x = rows;
		int y = columns;
		
		if( i+1<rows && !alreadyVisited[i+1][j])
		{
			int element = m[i+1][j];
			
			if( element < minCostSofar)
			{
				x = i+1;
				y = j;
				
				minCostSofar = element;
			}
		}
		
		
		if( j+1 < columns && !alreadyVisited[i][j+1])
		{
			int element = m[i][j+1];
			
			if( element < minCostSofar)
			{
				x = i;
				y = j+1;
				
				minCostSofar = element;
			}
		}

		if( j-1 >=0 && !alreadyVisited[i][j-1])
		{
			int element = m[i][j-1];
			
			if( element < minCostSofar)
			{
				x = i;
				y = j-1;
				
				minCostSofar = element;
			}
		}
		
		
		if(i-1 >=0 && !alreadyVisited[i-1][j])
		{
			int element = m[i-1][j];
			
			if( element < minCostSofar)
			{
				x = i-1;
				y = j;
				
				minCostSofar = element;
			}
		}
		
		alreadyVisited[x][y] = true;
		
		MinElement nextElement = new MinElement(x,y);
		nextElement.setMinCost(currElement.getCost()+m[x][y]);
		nextElement.setPrevious(currElement);
		
		return nextElement;
	}

}


class MinElement
{
	MinElement prev;
	
	int cost;
	int i;
	int j;
	
	MinElement( int i , int j )
	{
		this.prev = null;
		this.i = i;
		this.j = j;
	}
	
	public void setPrevious( MinElement prev)
	{
		this.prev = prev;
	}
	
	public void setMinCost( int cost)
	{
		this.cost = cost;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public MinElement getPreviousElement()
	{
		return prev;
	}
	
	public int getX()
	{
		return i;
	}

	public int getY()
	{
		return j;
	}
}
