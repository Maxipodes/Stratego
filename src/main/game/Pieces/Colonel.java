package main.game.Pieces;


public class Colonel extends Piece 
{
	public Colonel() 
	{	
		NAME = "Colonel";
		RANK = 8;
		NUMBER = 2;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		ref =7;
	}

	public Colonel construct()
	{
		return new Colonel();
	}
}
	
