package main.game;

public class Position
{
	public static void main(String[] args)
	{
	}
	
	int positionX;
	int positionY;	
	
	public Position(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY;	
	}
	
	public String toString(){
		String a = "("+positionX+", "+positionY+")";
		return a;
	}
}
	



	
