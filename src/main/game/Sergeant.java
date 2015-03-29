package main.game;

public class Sergeant extends Piece 
{
	public Sergeant() 
	{	
		NAME = "Sergeant";
		RANK = 4;
		NUMBER = 4;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
	}

	public Sergeant construct()
	{
		return new Sergeant();
	}

}
