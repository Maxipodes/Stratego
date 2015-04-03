package main.game;

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
	
	public abstract Piece construct();

	public static boolean isEquals(Piece piece1, Piece piece2)
	{
		if (piece1.RANK == piece2.RANK)
			return true;
		return false;
	}
	public static boolean isStronger(Piece piece1, Piece piece2) 
	{
		if (piece1.WEAKNESS != 0)
		{
			if (piece1.WEAKNESS == piece2.RANK)
				return true;
		}
		else if (piece2.WEAKNESS != 0)
		{
			if (piece1.RANK == piece2.WEAKNESS)
				return true;
		}
		else if (piece1.RANK > piece2.RANK)
			return true;
		return false;
	}
	public static boolean hasWon(Piece p1, Piece p2)
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
	public int getCurrentNumber()
	{
		return currentNumber;
	}
	public void setTeam(int t)
	{
		TEAM = t;
	}
	public void setPosition(int x, int y)
	{
		 position = new Position(x,y);
	}
	public static boolean sameTeam(Piece p1, Piece p2)
	{
		if( p1 instanceof Lake)
			return true;
		else if (p2 instanceof Lake)
			return true;
		else;
			return p1.TEAM == p2.TEAM;
	}
	
}
