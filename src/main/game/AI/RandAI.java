package main.game.AI;

import main.game.BoardGame;
import main.game.GameController;
import main.game.Position;
import main.game.Team;
import main.game.Pieces.Piece;

public class RandAI extends AI implements Playable
{
	static AI instance = null;
	GameController gc;
	Piece[][] board;
	
	private RandAI(){

		board=BoardGame.getBoardGame().BOARD;
		gc = GameController.getGameController();
	}
	
	public static AI getAI(){
		if(instance == null)
			instance= new RandAI();
		return instance;
	}
	
	public int countContenant()
	{
		int count = 0;
		for(int i=0; i < board.length; i++)
		{
			for(int j=0; j < board[0].length;j ++)
			{
				if(board[i][j] != null)
					count ++;
			}
		}
		return count;
	}
	
	public void play()
	{
		Piece[] list = new Piece[countContenant()];
		int pos = 0;
		for(int i=0; i < board.length; i++)
		{
			for(int j=0; j < board[0].length;j ++)
			{
				if(board[i][j] != null)
				{
					if(board[i][j].TEAM == Team.RED)
					{
						if(BoardGame.getBoardGame().canMove(board[i][j].position))
						{	
							list[pos]=board[i][j];
							
							pos ++;
						}	
					}
				}			
			}
		}
		Piece[] list2 = new Piece[super.numberInside(list)];
		//list which contains pieces of AI which can move;
		for(int h = 0; h < list2.length ; h++) 
		{	
			if (list[h] != null)
						list2[h] = list[h];

		}			
		int randNum = (int) ((Math.random())*(list2.length));
		Position[] listPossiblePosition = super.possibleMove(list2[randNum].position);
		// listPossiblePosition contains possible directions 
		int numberPossiblePosition = listPossiblePosition.length;
		// numberPossiblePosition is the number of possible directions
		int randNum2 = (int) ((Math.random())*(numberPossiblePosition));
		

			if(board[listPossiblePosition[randNum2].positionX][listPossiblePosition[randNum2].positionY] != null) 
			{	
				gc.attackWithoutAI(list2[randNum].position,listPossiblePosition[randNum2]);
			}
		
			else
			{	
				gc.moveWithoutAI(list2[randNum].position,listPossiblePosition[randNum2]);
			}
			gc.changeTurn();
	}





}
