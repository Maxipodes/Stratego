package main.game;

public class Marshal extends Piece 
{
	public static void main(String[] args)
	{
		Piece bob = new Marshal();
		System.out.println(bob.NAME);
		bob.setPosition(3,1);
		System.out.println(bob.position);
		bob.setTeam(1);
		System.out.println(bob.TEAM);
	}
	public Marshal() 
	{	
		NAME = "Marshal";
		RANK = 10;
		NUMBER = 1;
		WEAKNESS = 1;	
		MOVE = 1;		
		currentNumber = 0;
	}

	public Marshal construct()
	{
		return new Marshal();
	}
	
}
