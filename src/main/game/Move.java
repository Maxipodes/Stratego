package main.game;

public class Move 
{

	public static boolean isNextTo(BoardGame board, Position p)
	{
		if (!(board.BOARD[p.positionX+1][p.positionY] == null))
			return true;
		if (!(board.BOARD[p.positionX-1][p.positionY] == null))
			return true;
		if (!(board.BOARD[p.positionX][p.positionY+1] == null))
			return true;
		if (!(board.BOARD[p.positionX][p.positionY-1] == null))
			return true;
		else;
			return false;
	}
















}
