package main.game;

public class Captain extends Piece 
{

	public Captain() 
	{	
		NAME = "Captain";
		RANK = 6;
		NUMBER = 4;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
	}

	public Captain construct()
	{
		return new Captain();
	}

}


