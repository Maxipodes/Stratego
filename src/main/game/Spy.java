package main.game;

public class Spy extends Piece 
{
	public Spy() 
	{	
		NAME = "Spy";
		RANK = 1;
		NUMBER = 1;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
	}
	
	public Spy construct()
	{
		return new Spy();
	}
}