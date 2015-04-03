package main.game;

public class Lake extends Piece
{

	public Lake() 
	{	
		NAME = "Lake";
		RANK = 18000000;
		NUMBER = 8;
		WEAKNESS = 0;	
		MOVE = 0;		
		currentNumber = 0;
	}

	public Lake construct()
	{
		return new Lake();
	}

	public Lake(int x, int y)
	{
		NAME = "Lake";
		RANK = 18000000;
		NUMBER = 8;
		WEAKNESS = 0;	
		MOVE = 0;		
		currentNumber = 0;
		position = new Position(x, y);
	}

	
}
