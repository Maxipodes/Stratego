package main.game;

import main.game.Pieces.Marshal;
import main.game.Pieces.Piece;
import main.game.Pieces.Scout;
import main.game.Pieces.Spy;

public class AI
{
	public static void main(String[] args)
	{
		
	}

	public int gameTurn;
	public BoardGame board;
	
	public AI() 
	{
		int gameTurn = 0;
		board = BoardGame.getBoardGame();
	}
	
	private static AI instance = null;
	
	public static AI getAI() 
	{
		if(instance == null)
			instance = new AI();
		return instance;
	}
	


	public void sendScout()
	{
		Position p = new Position(0,0);
		for(int i=0; i < board.BOARD.length; i++)
		{
			for(int j=0; i< board.BOARD[0].length; j++)
			{
				if(board.BOARD[i][j] instanceof Scout)
				{	
					if(board.BOARD[i][j].TEAM == 1)
					{
						for(int k=0; k < board.BOARD.length; i++)
						{
							for(int l=0; l< board.BOARD[0].length; l++)
							{
								p.positionX = k;
								p.positionY = l;
								
								if(board.BOARD[p.positionX][p.positionY] != null)
								{
									if(board.isDirectionInLine(board.BOARD[i][j].position,p))
									{
										if(board.canMove(board.BOARD[i][j].position,p))
										{	
											attack(board.BOARD[i][j],p);
										}
									}	
								}			
							}
						}
					}
				}
			}
		}	
	}

	public Position[] isDefenseLess(Piece p)
	{
		Position[] list = new Position[4];
		Position o = new Position(0,0);
		int a = p.MOVE;
		p.MOVE = 2;
		int pos = 0;
		
		for(int i=0; i< board.BOARD.length; i++)
		{
			for(int j=0; i< board.BOARD[0].length; j++)
			{
				o.positionX = i;
				o.positionY = j; 
				if(board.BOARD[o.positionX][o.positionY] != null)
				{
					if(board.isDirectionInLine(board.BOARD[i][j].position,o))
					{
						if(board.canMove(board.BOARD[i][j].position,o))
						{	
							list[pos] = o;
							pos++;
						}
					}
				}						
			}
		}
		p.MOVE = a;
		return list;
	}
	
	public int numberInside(Piece[] list)
	{
		int res = 0;
		for(int i = 0; i<list.length ; i++)
		{
			if(list[i] != null)
				res++;
		}	
		return res;
	}
	
	public int numberInside(Position[] list)
	{
		int res = 0;
		for(int i = 0; i<list.length ; i++)
		{
			if(list[i] != null)
				res++;
		}	
		return res;
	}
	
	
	public void rushToWin()
	{
		
	}
	
	public void fleeToSurvive()
	{
		
	}
	public Position[] possibleMove(Position p)
	{
		Position[] list = new Position[((board.BOARD.length)-1)+((board.BOARD[0].length)-1)];
		int pos = 0;
		for(int k=0; k< board.BOARD.length; k++)
		{
					for(int j=0; j< board.BOARD[0].length; j++)
					{	
						Position x = new Position(k,j);
						if(board.canMove(p,x))
							list[pos] = x;
					}					
		}	
		int g = numberInside(list);
		Position[] list2 = new Position[g];
		for (int i = 0; i<list.length; i++)
		{
			if(list[i] != null)
				list2[i] = list[i];
			else
				break;	
		}	
		return list2;		
	}
	
	public void protectSpy()
	{
		for(int m=0; m < board.BOARD.length; m++)
		{
			for(int h=0; h < board.BOARD[0].length; h++)
			{
				if(board.BOARD[m][h] instanceof Marshal)
					return;
			}
		}			
		
		for(int i=0; i< board.BOARD.length; i++)
		{
			for(int j=0; i< board.BOARD[0].length; j++)
			{
				if(board.BOARD[i][j].TEAM == 1)
				{
					if(board.BOARD[i][j] instanceof Spy)
					{
						Position pos = new Position(i,j);
						Position[] list = isDefenseLess(board.BOARD[i][j]);
						if(numberInside(list) != 0)
						{
							Position[] list2 = possibleMove(pos);
							
							
						}
						break;	
							
					
					}	
				}	
			}
		}	
	}
	
	
	public Position attack(Piece piece, Position direction)
	{
			Position posSurvivor;
			
			if (piece.isStronger(board.BOARD[direction.positionX][direction.positionY]))
					posSurvivor=piece.position;
			
			else if(board.BOARD[direction.positionX][direction.positionY].isStronger(piece))
				posSurvivor = direction;
	
			else
				posSurvivor= null;
			
			return posSurvivor;
			
	}
	
}	

