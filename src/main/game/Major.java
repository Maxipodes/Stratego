package main.game;

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
	}

	public Major construct()
	{
		return new Major();
	}
}
