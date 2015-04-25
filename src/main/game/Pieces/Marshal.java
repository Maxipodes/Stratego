package main.game.Pieces;

public class Marshal extends Piece 
{
	public Marshal() 
	{	
		NAME = "Marshal";
		RANK = 10;
		NUMBER = 1;
		WEAKNESS = 1;	
		MOVE = 1;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		ref =9;
	}

	public Marshal construct()
	{
		return new Marshal();
	}
	
	
}
