package main.game.Pieces;

public class Spy extends Piece 
{
	public Spy() 
	{	
		NAME = "Spy";
		RANK = 1;
		NUMBER = 1;
		WEAKNESS = 0;	
		MOVE = 1;		
		SEEN = false;
		hasMove = false;
		currentNumber = 0;
	}
	
	public Spy construct()
	{
		return new Spy();
	}
}