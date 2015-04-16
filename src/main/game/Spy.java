package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Spy extends Piece 
{
	public Spy() 
	{	
		NAME = "Spy";
		RANK = 1;
		NUMBER = 1;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Méchant_mage.png";
		IMAGE = new ImageIcon(image);
	}
	
	public Spy construct()
	{
		return new Spy();
	}
}