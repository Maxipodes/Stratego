package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Scout extends Piece 
{
	public Scout() 
	{	
		NAME = "Scout";
		RANK = 2;
		NUMBER = 8;
		WEAKNESS = 0;	
		MOVE = BoardGame.LENGTHX;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"scout.png";
		IMAGE = new ImageIcon(image);
	}

	public Scout construct()
	{
		return new Scout();
	}	
	
	
}
