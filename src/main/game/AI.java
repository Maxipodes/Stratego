package main.game;

public class AI
{
	public static void main(String[] args)
	{
		
	}
	public static Piece[][] memorize = BoardGame.createBoardGame(10,10);
	
	

	public static void synchronize(Piece[][] board, Piece[][] list2)
	{
		for(int i = 0; i < board.length ; i++ )
		{
			for(int j = 0; j < board[0].length ; j++)
			{
				if (list2[i][j] != null)
					list2[i][j] = board[i][j];
			}
		}
	
	}
	
	public static void attack(BoardGame board, Piece piece, Position direction)
	{
		if (board.canMove(piece.position, direction))
		{
			if (board.BOARD[direction.positionX][direction.positionY].isStronger(piece))
			{
					board.BOARD[direction.positionX][direction.positionY] = null;
					board.setMoveCharacter(piece.position, direction.positionX, direction.positionY);		
			}
			else;
			{
				board.BOARD[piece.position.positionX][piece.position.positionY] = null; 
				memorize[direction.positionX][direction.positionY] = board.BOARD[direction.positionX][direction.positionY];
			}
		}
	}
	
}	

