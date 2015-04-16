package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Colonel extends Piece 
{
	public Colonel() 
	{	
		NAME = "Colonel";
		RANK = 8;
		NUMBER = 2;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Méchant_mage.png";
		IMAGE = new ImageIcon(image);
	}

	public Colonel construct()
	{
		return new Colonel();
	}
}
	
