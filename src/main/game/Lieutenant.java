package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Lieutenant extends Piece 
{
	public Lieutenant() 
	{	
		NAME = "Lieutenant";
		RANK = 5;
		NUMBER = 4;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Méchant_mage.png";
		IMAGE = new ImageIcon(image);
	}

	public Lieutenant construct()
	{
		return new Lieutenant();
	}
	
}
