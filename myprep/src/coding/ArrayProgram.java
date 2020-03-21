//$Id$
package coding;

public class ArrayProgram {
	
	public static void main(String [] args)
	{
		int a[][] = new int[3][2];
		int b[][] = new int[4][3];
		int c[][] = new int[2][3];
		int d[][] = new int[3][4];
		
		a = intializeArray(a);
		b = intializeArray(b);
		c = intializeArray(c);
		d = intializeArray(d);
		
		
		int md [][][] = {a,b,c,d};
		
		
		
	}
	
	public static int[][] intializeArray(int a[][])
	{
		for(int row = 0; row < a.length ; row ++)
		{	
			for ( int col=0 ; col < a[row].length; col ++)
			{
				a[row][col] = 0;
			}
		}
		
		return a;
	}
	
	
	class Seating 
	{
		int arr[][];
		boolean isFirst = false;
		boolean isLast =  false;
		
		
		public void seating (int arr[][] , boolean isFirst , boolean isLast)
		{
			this.arr = arr;
		}
		
		public int [][] getArray()
		{
			return arr;
		}
		
		public void setArray(int arr[][])
		{
			this.arr = arr;
		}
	}

}


