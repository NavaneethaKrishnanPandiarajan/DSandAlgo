
//$Id$
package lowLevelDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeGame 
{
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 
	Player player1 = null;
	
	Player player2 = null;
	
	Player currentPlayer = null;
	
	int totalMoves = 0;
	
	void startGame()
	{
		int boardSize = 3;
		
		Board board = new Board();
		
		board.initialize(boardSize);
		
		player1 = new Player('X');
		
		player2 = new Player('O');
		
		currentPlayer = player1;
		
		while( !board.isGameFinished() )
		{
			System.out.print( currentPlayer.get() + " :: Please select position " ) ;
			
			int[] pos = getPosition();
			
			boolean isvalidMove = board.makeMove(currentPlayer, pos[0], pos[1]);
			
			if( !isvalidMove)
			{
				System.out.print( currentPlayer.get() + " :: Invalid Position Trying again" ) ;
			}
			else
			{
				currentPlayer = changePlayerMovement();
				totalMoves ++ ;
			}
			
			if( totalMoves == (boardSize * boardSize))
			{
				break;
			}
		}
		
		
		if( board.getWinner() == null )
		{
			System.out.print("Match Draw") ;
		}
		else 
		{
			System.out.print( "The winner is " + board.getWinner().get() + " ...... ") ;
		}
		
	}

	
	public Player changePlayerMovement()
	{
		if( currentPlayer.get() == 'X' )
		{
			return player2;
		}
		else
		{
			return player1;
		}
	}
	
	
	protected int[] getPosition() 
	{
		int pos [] = new int[2];
        String prompt = "";
        try {
            prompt = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        String arr[] = prompt.split(",");
        
        int i=0;
        for(String ele : arr)
        {
        	pos[i] = Integer.valueOf(ele);
        	i++;
        }
        
        return pos;
    }
	
}


class Board
{
	
	Player winner = null;
	
	private boolean isGameFinished;
	
	int boardSize ;
	
	Box[][] box = null;
	
	public void initialize( int boardSize)
	{
		box = new Box[boardSize][boardSize];
		
		for(int i=0 ; i< boardSize ; i++)
		{
			for(int j=0; j< boardSize ; j++)
			{
				box[i][j] = new Box(new Player('N'),i,j);
			}
		}
		
		this.boardSize = boardSize;
	}
	
	
	boolean makeMove(Player player , int row , int col)
	{
		boolean makeMove = false;
		
		if( player.get() != 'X' || player.get() != 'O' )
		{
			makeMove = false;	
		}
		
		if( box[row][col].getPlayer().get() == 'N')
		{
			box[row][col].setPlayer(player);
			
			makeMove = true;
		}
		else
		{
			makeMove = false;
		}
		
		if( makeMove)
		{
			//check for wins
			boolean rowCheck = true;
			boolean colCheck = true;
			boolean diaGonalCheck = true;
			boolean revDiagonalCheck = true;
			
			for(int i=0 ; i<boardSize ; i++)
			{
				if(box[row][i].getPlayer().get() != player.get())
				{
					rowCheck = false;
				}
				
				if(box[i][col].getPlayer().get() != player.get())
				{
					colCheck = false;
				}
				
				if(box[i][i].getPlayer().get() != player.get())
				{
					diaGonalCheck = false;
				}
				
			}
			
			if( rowCheck || colCheck || diaGonalCheck )
			{
				setWinner(player);
			}
		}
		
		return makeMove;
	}
	
	
	public boolean isGameFinished() 
	{
		return isGameFinished;
	}

	public void setGameFinished(boolean isGameFinished) 
	{
		this.isGameFinished = isGameFinished;
	}
	
	public Player getWinner()
	{
		return winner;
	}
	
	public void setWinner(Player player)
	{
		this.winner = player;
		
		setGameFinished(true);
	}

}

class Box
{
	int i;
	int j;
	
	Player player;
	
	Box (Player player , int i , int j)
	{
		this.player = player;
		this.i=i;
		this.j=j;
		
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}

class Player
{
	char c;
	
	Player(char c)
	{
		set(c);
	}
	char get()
	{
		return c;
	}
	
	void set(char c)
	{
		this.c =c;
	}
}

