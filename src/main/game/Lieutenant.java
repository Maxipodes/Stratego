package main.game;

public class Lieutenant extends Piece 
{
	public Lieutenant() 
	{	
		NAME = "Lieutenant";
		RANK = 5;
		NUMBER = 4;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
	}

	public Lieutenant construct()
	{
		return new Lieutenant();
	}
}
