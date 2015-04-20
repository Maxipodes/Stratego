package main.game.Pieces;

public class Bomb extends Piece 
{
	public Bomb() 
	{	
		NAME = "Bomb";
		RANK = 11;
		NUMBER = 6;
		WEAKNESS = 3;	
		MOVE = 0;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
	}
	
	public Bomb construct()
	{
		return new Bomb();
	}

}
