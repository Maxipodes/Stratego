package main.game.Pieces;

import java.io.File;

import javax.swing.ImageIcon;

import main.game.Position;



public class Lake extends Piece
{

	public Lake() 
	{	
		NAME = "Lake";
		RANK = 18000000;
		NUMBER = 8;
		WEAKNESS = 0;	
		MOVE = 0;		
		SEEN = true;
		hasMove = false;
		
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
		position = new Position(x, y);
		IMAGE = null;
	}

}
