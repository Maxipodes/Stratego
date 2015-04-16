package main.game;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Piece 
{
	public static void main(String[] args) 
	{
	}
	
	public String NAME;
	public int RANK;
	public int WEAKNESS;
	public Position position;
	public int NUMBER;
	public int MOVE;
	public int currentNumber;
	public int TEAM;
	ImageIcon IMAGE;

	
	public abstract Piece construct();

	public boolean isEquals(Piece piece2)
	{
		if (RANK == piece2.RANK)
			return true;
		return false;
	}
	public boolean isStronger(Piece piece2) 
	{
		if (WEAKNESS != 0)
		{
			if (WEAKNESS == piece2.RANK)
				return true;
		}
		else if (piece2.WEAKNESS != 0)
		{
			if (RANK == piece2.WEAKNESS)
				return true;
		}
		else if (RANK > piece2.RANK)
			return true;
		return false;
	}
	public boolean hasWon(Piece p2)
	{
		if (p2.RANK == 0)
			return true;
		return false;
	}		
	
	public void addCurrentNumber()
	{
			currentNumber ++;
	}
	public void discreaseCurrentNumber()
	{
			currentNumber --;
	}
	
	public void setTeam(int t)
	{
		TEAM = t;
		this.addCurrentNumber();
	}
	public void setPosition(int x, int y)
	{
		 position = new Position(x,y);
	}
	public boolean sameTeam(Piece p2)
	{
		 if (p2 instanceof Lake)
			return true;
		 if(p2 == null)
			 return false;
		 else;
			return TEAM == p2.TEAM;
	}
	
	public Image getImage(){
		return IMAGE.getImage();
	}
	
}
