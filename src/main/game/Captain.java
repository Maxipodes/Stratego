package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Captain extends Piece 
{
	public Captain() 
	{	
		NAME = "Captain";
		RANK = 6;
		NUMBER = 4;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"M�chant_mage.png";
		IMAGE = new ImageIcon(image);
	}

	public Captain construct()
	{
		return new Captain();
	}

}


