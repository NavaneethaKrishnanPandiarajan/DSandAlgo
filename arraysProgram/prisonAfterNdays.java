//$Id$
package arraysProgram;

/**
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

 * 
 * 	Input: cells = [0,1,0,1,1,0,0,1], N = 7
	Output: [0,0,1,1,0,0,0,0]
	
	Explanation: 
	
	The following table summarizes the state of the prison on each day:
	
	Day 0: [0, 1, 0, 1, 1, 0, 0, 1]	
	Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
	Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
	Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
	Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
	Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
	Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
	Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 
 * 
 *
 */


public class prisonAfterNdays {
	
	
	
	
	/**
	 * why 14?
	The intuition comes from the fact that the first and last cell never change 
	their values after the first day. In effect, this makes it 6 cells, 
	each one could be occupied or not, that gives us 6C2 = 15.
	Since the first and last cell don't change and will always be 0 regardless of their initial value, 
	that means that the 2nd and 7th cell will flip their state if and only if the 3rd and 6th cells are zero 
	i.e. 0001000, or so that's a combination that will never happen (2nd and 6th cell with value 1 and 2nd and 5th cell with value 1) 
	which gives us in total 6C2 - 1 = 14 combination. After 14 days, the combination will just repeat over and over again, 
	which leads to the following optimized constant time solution.

	 * @param cells
	 * @param N
	 * @return
	 */
	public int[] prisonAfterNDays(int[] cells, int N) 
	{
		int cellSize = 8; 

		for ( N = (N-1) % 14 + 1; N>0; N--) {
			int temp[] = new int [cellSize];

			for ( int i= 1; i< cellSize-1; i++){
				temp[i] = (cells[i-1] == cells[i+1]) ? 1: 0;
			}
			cells = temp;
		}
		return cells;
	}

}
