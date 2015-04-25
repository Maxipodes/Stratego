package main.game.Pieces;


public class Major extends Piece 
{
	public Major() 
	{	
		NAME = "Major";
		RANK = 7;
		NUMBER = 3;
		WEAKNESS = 0;	
		MOVE = 1;	
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		ref =6;
	}

	public Major construct()
	{
		return new Major();
	}
	
}
