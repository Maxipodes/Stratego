package main.game;

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
	}

	public Flag construct()
	{
		return new Flag();
	}
	
}
