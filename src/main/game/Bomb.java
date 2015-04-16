package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Bomb extends Piece 
{
	public Bomb() 
	{	
		NAME = "Bomb";
		RANK = 11;
		NUMBER = 6;
		WEAKNESS = 3;	
		MOVE = 0;		
		currentNumber = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Méchant_mage.png";
		IMAGE = new ImageIcon(image);
	}
	
	public Bomb construct()
	{
		return new Bomb();
	}

}
