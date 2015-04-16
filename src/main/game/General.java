package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class General extends Piece 
{
	public General() 
	{	
		NAME = "General";
		RANK = 9;
		NUMBER = 1;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Méchant_mage.png";
		IMAGE = new ImageIcon(image);
	}

	public General construct()
	{
		return new General();
	}
	
}
