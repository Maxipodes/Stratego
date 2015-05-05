package main.game.AI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import main.game.BoardGame;
import main.game.GameController;
import main.game.Position;
import main.game.Pieces.Marshal;
import main.game.Pieces.Piece;
import main.game.Pieces.PieceTest;
import main.game.Pieces.Scout;
import main.game.Pieces.Spy;

public class AI implements Playable, Serializable
{
	public int gameTurn;
	public BoardGame board;
	public GameController gc;
	
	public AI() 
	{
		int gameTurn = 0;
		board=BoardGame.getBoardGame();
	}
	
	private static AI instance = null;
	
	public static AI getAI() 
	{
		if(instance == null)
			instance = new AI();
		return instance;
	}
	
	public void detectScout()
	{
		
	}

	public void sendScout()
	{
		for(int i=0; i < board.BOARD.length; i++)
		{
			for(int j=0; j< board.BOARD[0].length; j++)
			{
				if(board.BOARD[i][j] instanceof Scout)
				{											
					if(board.BOARD[i][j].TEAM == 1 && board.canMove(board.BOARD[i][j].position))
					{
						for(int k=0; k < board.BOARD.length; k++)
						{
							for(int l=0; l < board.BOARD[0].length; l++)
							{
								if(board.BOARD[k][l] != null)
								{											
									if(board.BOARD[k][l].SEEN == false);
									{				
										if(board.canMove(board.BOARD[i][j].position, board.BOARD[k][l].position))
										{	
											/*
											like board.BOARD[k][l].position is not empty and 
											the scout can move until this one, it is necessarily
											an enemy
											*/
											attack(board.BOARD[i][j],board.BOARD[k][l].position);
											return;
										}																							
									}
								}	
								
							}
						}
						
					}
				}
			}
		}
		return;
	}
	
	
	public Position[] listPositionResizing(Position[] list)
	{
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
	
	
	public Position[] isDefenseLess(Position p)
	{
		Position[] list = new Position[(board.BOARD.length)*(board.BOARD.length)];
		int a = board.BOARD[p.positionX][p.positionY].MOVE;
		board.BOARD[p.positionX][p.positionY].MOVE = 2;
		//reset the MOVE of the piece to two 
		int pos = 0;
		//initialize a counter of position
		
		for(int i=0; i< board.BOARD.length; i++)
		{
			for(int j=0; j< board.BOARD[0].length; j++)
			{
				Position h = new Position(i,j);
				if(board.BOARD[i][j] != null && board.canMove(p,h))	
				{
					/*
					by having reseted the Move of the piece to two, 
					we can see if our piece is directly exposed to an attack 
					*/		
							
					list[pos] = h;
					//add the position of vulnerability in list 
					pos++;
				}									
			}
		}
		Position[] list2 = listPositionResizing(list);
		
		board.BOARD[p.positionX][p.positionY].MOVE = a;
		//reset Move to its first value
		
		return list2;
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
	
	public int calcProbability(int team, Position p)
	{
		int count = 0;		
		int numberPiece = 0;		
		for(int k=0; k< board.BOARD.length; k++)
		{
			for(int j=0; j < board.BOARD[0].length; j++)
			{
				if(board.BOARD[k][j].TEAM != team)
				{
					numberPiece++;					
					if(board.BOARD[p.positionX][p.positionY].isStronger(board.BOARD[k][j]) && board.BOARD[k][j].RANK != 0)
						count++;
				}
			}
		}
		int probability = count/numberPiece;
		return (probability*100);
	}	
			
	
	/*public Position[] getArround(Position p)
	{
		
	}*/	
	
	public boolean CanMoveNearer(Position p, Position d)
	{
		Position[] list = possibleMove(p);
		if(board.canMove(p))
		{
			for(int i = 0; i < list.length ; i++)
			{
				if(Math.abs(p.positionX-d.positionX) > Math.abs(list[i].positionX-d.positionX)) 
					return true;
				else if(Math.abs(p.positionY-d.positionY) > Math.abs(list[i].positionY-d.positionY))
					return true;
			}
		}
		return false;
	}
	
	/*public Position[] pathFinder(Position p, Position d)
	{
		int diff = 0;
		int min = 0;
		Position nextPos;
		Position[] road = new Position[(board.BOARD.length)*3];
		//list which will contain the the path to hit the piece d 
		Position[] list = possibleMove(board.BOARD[p.positionX][p.positionX].position); 
		PieceTest pieceTest = new PieceTest();
		for(int i = 0; i < list.length; i++)
		{*/
			/*
			 for each possible move, we will construct a pieceTest to test the path and 
			 to avoid problems with graphic interface
			 */
			/*board.BOARD[list[i].positionX][list[i].positionY] = pieceTest.construct();
			board.BOARD[list[i].positionX][list[i].positionY].setTeam(1);
			board.BOARD[list[i].positionX][list[i].positionY].position = list[i];
			
			if(((list[i].positionY-d.positionY) + (list[i].positionX-d.positionX)) !=0)
			{	
				
				}
				
				
				
				try
				{
					Position g = list[i];
					Position h = list[i];
					g.positionY++;
					h.positionY--;
					board.canMove(list[i], g);
				}
				catch(IndexOutOfBoundsException e)
				{
					
				}
			}	
				
		}*/
	

	/*
	public void rushToWin()
	{
		for(int i = 0; i<board.BOARD.length; i++)
		{
			for(int j = 0 ; j < board.BOARD.length; j++)
			{
				if(board.BOARD[i][j] != null && board.BOARD[i][j].TEAM == 1  && board.canMove(p))
			}
		}
	}
	
	public void fleeToSurvive()
	{
		for(int i = board.BOARD.length ; i > 0; i--)
		{
			for(int j = board.BOARD[9].length ; j > 0; j--)
			{
				if(board.BOARD[i][j].TEAM == 1)
				{
					for(int k = board.BOARD.length		}
			}
		}
	}
*/

	public Position[] possibleMove(Position p)
	{
		Position[] list = new Position[((board.BOARD.length)-1)+((board.BOARD[0].length)-1)];
		
		int pos = 0;

		for(int k=0; k< board.BOARD.length; k++)
		{
			for(int j=0; j < board.BOARD[0].length; j++)
			{	
				Position x = new Position(k,j);
				if(board.canMove(p,x))
				{
					list[pos] = x;
					pos++;
				}	
			}					
		}	
		
		Position[] list2 = listPositionResizing(list);
		
		return list2;		
	}
	
	public void spyBehavior()
	{
		int o = 0;		
		for(int m=0; m < board.BOARD.length; m++)
		{
			for(int h=0; h < board.BOARD[0].length; h++)
			{
				if(board.BOARD[m][h]!=null)
				{
					if(board.BOARD[m][h] instanceof Marshal && board.BOARD[m][h].TEAM == 0)
					{		
						o++;
						break;
					}
						
					/* 
					if the marshal of enemy team dies, 
					the spy of AI will becomes useless
					and there will has no interest to protect
					it
					*/
						
				}
			}			
		}
		if(o == 0)
			return;
		for(int i=0; i< board.BOARD.length; i++)
		{
			for(int j=0; j< board.BOARD[0].length; j++)
			{
				// is looking for a spy
				if(board.BOARD[i][j] != null)
				{	
					if(board.BOARD[i][j].RANK == 1 && board.BOARD[i][j] instanceof Spy)
					{
						// looks if the spy is in the same team than AI 
						Position[] list = isDefenseLess(board.BOARD[i][j].position);
						// looks where spy would be defenseless
						
						Position[] list2 = possibleMove(board.BOARD[i][j].position);
						
						if(numberInside(list) != 0)
						{
							for(int g=0; g < board.BOARD.length; g++)
							{
								for(int p=0; p < board.BOARD[0].length; p++)
								{
									if(board.BOARD[g][p] != null)
									{
										if(board.BOARD[g][p].TEAM == 1 && board.BOARD[g][p] instanceof Spy == false)
										{
											if(board.canMove(board.BOARD[g][p].position))
											{
												for(int d = 0; d < list.length ; d++)
												{
													if(board.canMove(board.BOARD[g][p].position, list[d]))
													{
														//looks if a piece of the same team of spy can move between this one and the threatening piece
														board.setMoveCharacter(board.BOARD[g][p].position, list[d]);
														return;
													}	
												}
											}	
										}
									}								
								}
							}
							
							Piece pieceTest = new PieceTest();
							// we create an instance of PieceTest to use method(s) inside
							pieceTest.setTeam(board.BOARD[i][j].TEAM);
							pieceTest.position = new Position(0,0);
							
							for(int u = 0; u < list2.length ; u++)
							{		
								/*	
								for each possible movement a instance of PieceTest will be created. 
								Then a test will be done to compare several isDefenseLess lists and find 
								the best place for spy
								*/
								board.BOARD[list2[u].positionX][list2[u].positionY] = pieceTest.construct();
								board.BOARD[list2[u].positionX][list2[u].positionY].position = list2[u];
									
								Position[] list3 = isDefenseLess(board.BOARD[list2[u].positionX][list2[u].positionY].position);
								
								if(list3.length < list2.length)
								{
									//the spy would take a risk and would have more chances to die	
									board.BOARD[list2[u].positionX][list2[u].positionY] = null;
									continue;
								}
								else if(list3.length < list2.length)
								{
									//interesting situation, there are less risks for spy to be killed	
									Position h = board.BOARD[list2[u].positionX][list2[u].positionY].position;
									board.BOARD[list2[u].positionX][list2[u].positionY] = null;
									board.setMoveCharacter(board.BOARD[i][j].position,list2[u]);
									return;
								}		
								else if (list3.length == list2.length)
								{
									continue;
								}
								return;	
							}	
						}
						return;
					}
				}	
			}
		}
	}
	
	public void gamePlay()
	{
		
	}
		
	public Position attack(Piece piece, Position d)
	{
		if (board.canMove(piece.position, d))
		{
			if(board.BOARD[d.positionX][d.positionY].isEquals(piece))
			{
				return null;	
			}
			else if (piece.isStronger(board.BOARD[d.positionX][d.positionY]))
			{	
				return piece.position;
					
			}
			else if(board.BOARD[d.positionX][d.positionY].isStronger(piece)) 
			{
				return d;
			}
		}
		return null;
	}
	


	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	private void readObject(ObjectInputStream ois)throws IOException
	, ClassNotFoundException{
		gameTurn = ois.readInt();
		board = (BoardGame)ois.readObject();
		gc= (GameController) ois.readObject();
	}
	
	private void writeObject(ObjectOutputStream oos)throws IOException
	, ClassNotFoundException{
		oos.writeInt(gameTurn);
		oos.writeObject(board);
		oos.writeObject(gc);
	}
	
}	

