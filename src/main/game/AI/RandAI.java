package main.game.AI;

import main.game.Position;
import main.game.Team;
import main.game.Pieces.Piece;

public class RandAI extends AI implements Playable
{
	
	AI randAI ;
	static AI instance = null;
	
	private RandAI(){
		randAI  = super.getAI();
	}
	
	public static AI getAI(){
		if(instance == null)
			instance= new RandAI();
		return instance;
	}
	
	public int countContenant()
	{
		int count = 0;
		for(int i=0; i < randAI.board.BOARD.length; i++)
		{
			for(int j=0; j < randAI.board.BOARD[0].length;j ++)
			{
				if(randAI.board.BOARD[i][j] != null)
					count ++;
			}
		}
		return count;
	}
	
	public void play()
	{
		Piece[] list = new Piece[countContenant()];
		int pos = 0;
		for(int i=0; i < randAI.board.BOARD.length; i++)
		{
			for(int j=0; j < randAI.board.BOARD[0].length;j ++)
			{
				Position p = new Position(i,j);
				if(randAI.board.BOARD != null)
				{
					if(randAI.board.BOARD[i][j].TEAM == 1)
					{
						p.positionX = i;
						p.positionY = j;
						if(randAI.board.canMove(p))
						{	
							list[pos]=randAI.board.BOARD[i][j];
							pos ++;
						}	
					}
				}			
			}
		}
		Piece[] list2 = new Piece[randAI.numberInside(list)];
		for(int h = 0; h < list2.length ; h++) 
		{	
			if (list[h] != null)
						list2[h] = list[h];
		}			
		int randNum = (int) ((Math.random())*(list2.length+1));
		
		Position[] listPossiblePosition = randAI.possibleMove(list2[randNum].position);
		// listPossiblePosition contains possible directions 
		int numberPossiblePosition = listPossiblePosition.length;
		// numberPossiblePosition is the number of possible directions
		int randNum2 = (int) ((Math.random())*(numberPossiblePosition+1));
		
		if(listPossiblePosition[randNum2] != null) 
		{	
			randAI.gc.attack(list2[randNum].position,listPossiblePosition[randNum2]);
		}
		
		else
		{	
			randAI.gc.move(list2[randNum].position,listPossiblePosition[randNum2]);
		}	
			
	}





}
