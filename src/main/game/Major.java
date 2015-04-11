package main.game;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Major extends Piece 
{
	public Major() 
	{	
		NAME = "Major";
		RANK = 7;
		NUMBER = 3;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Méchant_mage.png";
		IMAGE = new ImageIcon(image);
	}

	public Major construct()
	{
		return new Major();
	}
	
}
