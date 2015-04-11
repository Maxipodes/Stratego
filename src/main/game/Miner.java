package main.game;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Miner extends Piece 
{	
	public Miner() 
	{	
		NAME = "Miner";
		RANK = 3;
		NUMBER = 5;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		TEAM = 0;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Méchant_mage.png";
		IMAGE = new ImageIcon(image);
		
	}

	public Miner construct()
	{
		return new Miner();
	}
	
}
