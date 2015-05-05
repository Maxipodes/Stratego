package main.game.Pieces;

public class PieceTest extends Piece
{
	int unkowned = (int)((Math.random())*10);

	public PieceTest() 
	{	
		NAME = "PieceTest";
		RANK = unkowned;
		NUMBER = 1;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		TEAM = 0;
		SEEN = false;
		hasMove = false;
	}

	public PieceTest construct()
	{
		return new PieceTest();
	}	
	
}
