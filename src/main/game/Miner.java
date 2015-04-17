package main.game;

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
		SEEN = false;
		hasMove = false;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"miner.png";
		IMAGE = new ImageIcon(image);
		
	}

	public Miner construct()
	{
		return new Miner();
	}
	
}
