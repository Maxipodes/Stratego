package main.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Position implements Serializable
{
	
	public int positionX;
	public int positionY;	
	
	
	public Position(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY;	
	}
	public String toString()
	{
		return ("("+positionX+","+positionY+")");
	}
	
	private void readObject(ObjectInputStream ois)throws IOException
	, ClassNotFoundException{
		this.positionX=ois.readInt();
		this.positionY=ois.readInt();
	}

	private void writeObject(ObjectOutputStream oos)throws IOException
	, ClassNotFoundException{
		oos.writeInt(positionX);
		oos.writeInt(positionY);
	}
}
	



	
