package main.game.Pieces;


public class Flag extends Piece 
{
	public Flag() 
	{	
		NAME = "Flag";
		RANK = 0;
		NUMBER = 1;
		WEAKNESS = 0;	
		MOVE = 0;	
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		ref =10;
	}

	public Flag construct()
	{
		return new Flag();
	}
	
}
