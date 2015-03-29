package main.game;

public class Scout extends Piece 
{
	public Scout() 
	{	
		NAME = "Scout";
		RANK = 2;
		NUMBER = 8;
		WEAKNESS = 0;	
		MOVE = BoardGame.boardGame.length;		
		currentNumber = 0;
	}

	public Scout construct()
	{
		return new Scout();
	}	
}
