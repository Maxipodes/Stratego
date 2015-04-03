package main.game;

public class AI
{
	public static void main(String[] args)
	{
		
	}
	public static Piece[][] memorize = BoardGame.createBoardGame(10,10);
	
	
	public static boolean isNextTo(Piece[][] board, Position p)
	{
		if (!(board[p.positionX+1][p.positionY] == null))
			return true;
		if (!(board[p.positionX-1][p.positionY] == null))
			return true;
		if (!(board[p.positionX][p.positionY+1] == null))
			return true;
		if (!(board[p.positionX][p.positionY-1] == null))
			return true;
		else;
			return false;
	}	
	public static int numberFriendsNextTo(Piece[][] board, Position p)
	{
		int i = 0;
		if (isNextTo(board, p) == false)
			return i;

		if (isNextTo(board, p) == true)
		{
			if (Piece.sameTeam(board[p.positionX][p.positionY],board[p.positionX + 1][p.positionY]))
				i++;
			if (Piece.sameTeam(board[p.positionX][p.positionY],board[p.positionX - 1][p.positionY]))
				i++;
			if (Piece.sameTeam(board[p.positionX][p.positionY],board[p.positionX][p.positionY + 1]))
				i++;
			if (Piece.sameTeam(board[p.positionX][p.positionY],board[p.positionX][p.positionY - 1]))
				i++;
		}
		return i;
	}	
		
	public static boolean isDirectionInLine(Piece[][] board, Position p, Position d)
	{
		if ((p.positionX == d.positionX) || (p.positionY == d.positionY))
			return true;
		else; 
			return false;
	}
			
	public static int returnDirection(Piece[][] board, Position p, Position d)
	{
		if (p.positionX == d.positionX)
		{
			if (p.positionX > d.positionX)
			{	
				int left = 1;					
				return left;
			}
			else;
			{	
				int right = 2;
				return right;
			}	
		}
		else if(p.positionY == d.positionY)
		{	
			if(p.positionY > d.positionY)
			{
				int down = 3;
				return down;
			}
			else;
			{
				int up = 4;
				return up;
			}
		}
		return 0;
	}
	public static boolean canMove(Piece[][] board, Position p, Position d)
	{
		if (board[p.positionX][p.positionY].MOVE == 0)
			return false;		
		else if(board[p.positionX][p.positionY].MOVE == 1)
		{
			if (numberFriendsNextTo(board, p) == 4)
				return false;
			
		}
		else;
		{
			if (isDirectionInLine(board, p, d)==false)
				return false;
			else;
			{
				if (returnDirection(board, p, d) == 1)
				{
					for(int i = p.positionX; i == d.positionX; i--)
					{						
						if (board[i-1][p.positionY]==null)
						{
							if (i == d.positionX)
								return true;
						
						else if (Piece.sameTeam(board[i][p.positionY],board[i-1][p.positionY]))
							return false;
						else;
							return false;
						}
					}
				}
				else if (returnDirection(board, p, d) == 2)
				{
					for(int i = p.positionX; i == d.positionX; i++)
					{		
						if (board[i+1][p.positionX]==null)
						{
							if (i == d.positionX)
								return true;
							else if (Piece.sameTeam(board[i][p.positionY],board[i-1][p.positionY]))
								return false;
							else;
								return false;
						}
					}
				}
				else if (returnDirection(board, p, d) == 3)
				{
					for(int i = p.positionY; i == d.positionY; i++)
					{		
						if (board[p.positionX][i+1]==null)
						{
							if (i == d.positionY)
								return true;
							else if (Piece.sameTeam(board[p.positionX][i],board[p.positionX][i+1]))
								return false;
							else;
								return false;
						}
					}
				}
				else if (returnDirection(board, p, d) == 4)
				{
					for(int i = p.positionY; i == d.positionY; i--)
					{		
						if (board[p.positionX][i-1]==null)
						{
							if (i == d.positionY)
								return true;
						}
						else if (Piece.sameTeam(board[p.positionX][i],board[p.positionX][i-1]))
							return false;
						else;
							return false;
					}
				}
			}
		}
	return false;	
	}
	

	
	

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
	
	public static void attack(Piece[][] board, Piece piece, Position direction)
	{
		if (canMove(board, piece.position, direction))
		{
			if (Piece.isStronger(piece,board[direction.positionX][direction.positionY]))
			{
					board[direction.positionX][direction.positionY] = null;
					BoardGame.setMoveCharacter(board, piece.position, direction);		
			}
			else;
			{
				board[piece.position.positionX][piece.position.positionY] = null; 
				memorize[direction.positionX][direction.positionY] = board[direction.positionX][direction.positionY];
			}
		}
	}
	
}	

