//$Id$
package AM;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 		 Given a 2D grid, each cell is either a zombie 1 or a human 0. 
 		 Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. 
 		 Find out how many hours does it take to infect all humans?

Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]


**/


/**
 * 	Analysis:
 *  
 *  If we consider a zombie in one iteration/time ( say first hour ,) , we don't need to consider that zombie in next hour . It did work
 *  
 *  we should consider the newly converted zombies in next hour , only that zombies can make humans to zombies 
 *  
 *
 */


public class ZombieMatrix 
{
	
	
	public static int minHours(int rows, int columns, int[][] grid) 
	{
		int humans  = 0 ;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<grid.length; i++)
		{
			for(int j=0; j<grid[0].length; j++)
			{
				if(grid[i][j] == 1)
				{
					humans ++;
				}
				else
				{
					queue.add(new int[]{i,j});
				}
			}
		}
		
		int days  = 0;
		int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		
		while( !queue.isEmpty()  && humans > 0)
		{
			
			int queueSize = queue.size();
			
			for( int i = 0; i < queueSize; i++ )
			{
				int[] zombie = queue.poll();
				
				for (int[] dir : dirs) 
				{
                    int x = zombie[0] + dir[0];
                    int y = zombie[1] + dir[1];
                    
                    // New coordinates in grid shouldn't exceed the boundaries & the new coordinate is a human, only then turn that to a zombie
                   
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) 
                    {   
                    	grid[x][y] = 1;
                        queue.offer(new int[]{x, y}); // newly converted zombie added added in queue
                        humans--;
                    }
                }
			}
		
			days++;
		}
		
		return days;
	}
}
