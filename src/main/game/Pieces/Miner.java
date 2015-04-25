package main.game.Pieces;

public class Miner extends Piece 
{	
	public Miner() 
	{	
		NAME = "Miner";
		RANK = 3;
		NUMBER = 5;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		ref =2;
	}

	public Miner construct()
	{
		return new Miner();
	}
	
}
