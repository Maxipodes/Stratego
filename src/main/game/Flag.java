package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Flag extends Piece 
{
	public Flag() 
	{	
		NAME = "Flag";
		RANK = 0;
		NUMBER = 1;
		WEAKNESS = 0;	
		MOVE = 0;	
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"flag.png";
		IMAGE = new ImageIcon(image);
	}

	public Flag construct()
	{
		return new Flag();
	}
	
}
