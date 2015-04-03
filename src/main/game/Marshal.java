package main.game;

public class Marshal extends Piece 
{
	public static void main(String[] args)
	{
	}
	public Marshal() 
	{	
		NAME = "Marshal";
		RANK = 10;
		NUMBER = 1;
		WEAKNESS = 1;	
		MOVE = 1;		
		currentNumber = 0;
	}

	public Marshal construct()
	{
		return new Marshal();
	}
	
}
