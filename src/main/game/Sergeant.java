package main.game;

import java.io.File;

import javax.swing.ImageIcon;

public class Sergeant extends Piece 
{
	public Sergeant() 
	{	
		NAME = "Sergeant";
		RANK = 4;
		NUMBER = 4;
		WEAKNESS = 0;	
		MOVE = 1;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"sergeant.png";
		IMAGE = new ImageIcon(image);
		
	}

	public Sergeant construct()
	{
		return new Sergeant();
	}

}
