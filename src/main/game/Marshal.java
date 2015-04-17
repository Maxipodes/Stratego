package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Marshal extends Piece 
{
	public Marshal() 
	{	
		NAME = "Marshal";
		RANK = 10;
		NUMBER = 1;
		WEAKNESS = 1;	
		MOVE = 1;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"marshal.png";
		IMAGE = new ImageIcon(image);
	}

	public Marshal construct()
	{
		return new Marshal();
	}
	
	
}
