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
		SEEN = false;
		hasMove = false;
		currentNumber = 0;
		
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"spy.png";
		IMAGE = new ImageIcon(image);
	}
	
	public Spy construct()
	{
		return new Spy();
	}
}