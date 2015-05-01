package main.game.AI;

import main.game.Position;
import main.game.Team;
import main.game.Pieces.Piece;
import main.game.GameController;

public class RandAI extends AI implements Playable
{
	
	AI randAI ;
	static AI instance = null;
	GameController gc;
	
	private RandAI(){
		randAI  = super.getAI();
		//gc = getGameController();
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
				if(randAI.board.BOARD[i][j] != null)
				{
					if(randAI.board.BOARD[i][j].TEAM == Team.RED)
					{
						if(randAI.board.canMove(randAI.board.BOARD[i][j].position))
						{	
							list[pos]=randAI.board.BOARD[i][j];
							
							pos ++;
						}	
					}
				}			
			}
		}		
		
		Piece[] list2 = new Piece[randAI.numberInside(list)];
		//list which contains pieces of AI which can move;
		for(int h = 0; h < list2.length ; h++) 
		{	
			if (list[h] != null)
						list2[h] = list[h];
		}			
	
		int randNum = (int) ((Math.random())*(list2.length));
		
		Position[] listPossiblePosition = randAI.possibleMove(list2[randNum].position);
		// listPossiblePosition contains possible directions 
		int numberPossiblePosition = listPossiblePosition.length;
		// numberPossiblePosition is the number of possible directions
		int randNum2 = (int) ((Math.random())*(numberPossiblePosition));
		
		System.out.println("before attack or move");
		System.out.println("check");
		if(randAI.board.BOARD[listPossiblePosition[randNum2].positionX][listPossiblePosition[randNum2].positionY] != null) 
		{	
			System.out.println("check attack1");
			randAI.gc.attackWithoutAI(list2[randNum].position,listPossiblePosition[randNum2]);
			System.out.println("check att2");
		}
		
		else
		{	
			System.out.println("check move1");
			randAI.gc.moveWithoutAI(list2[randNum].position,listPossiblePosition[randNum2]);
			System.out.println("check move 2");
		}	
			
	}





}
