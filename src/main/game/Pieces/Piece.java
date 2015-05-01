package main.game.Pieces;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;

import main.game.Position;
import main.game.Team;

public abstract class Piece implements Serializable
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
	ImageIcon SHOWN_IMAGE;
	public boolean SEEN;
	public boolean hasMove;
	public int ref;

	
	public abstract Piece construct();

	public boolean isEquals(Piece piece2)
	{
		if (RANK == piece2.RANK)
			return true;
		return false;
	}
	public boolean isStronger(Piece piece2) 
	{
		if (RANK == piece2.WEAKNESS){
			return true;
		}
		else if (RANK > piece2.RANK){
			return true;
		}
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
		
		String image;
		
		if(TEAM==Team.BLUE){
			image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"BlueTeam"+File.separator+NAME+".png";
		}
		else{
			image ="."+File.separator+"src"+File.separator+
					"Image"+File.separator+"RedTeam"+File.separator+"S.png";
			
			String shownImage = "."+File.separator+"src"+File.separator+
					"Image"+File.separator+"RedTeam"+File.separator+NAME+".png";
			
			SHOWN_IMAGE = new ImageIcon(shownImage);
		}
		
		IMAGE = new ImageIcon(image);
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
	
	public Image getShownImage(){
		return SHOWN_IMAGE.getImage();
	}
	
	/**
	 * This method is use to recover Pieces object
	 * 
	 * @param ois
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream ois)throws IOException
	, ClassNotFoundException{
		this.NAME=ois.readUTF();
		this.RANK=ois.readInt();
		this.WEAKNESS=ois.readInt();
		this.position=(Position) ois.readObject();
		this.NUMBER=ois.readInt();
		this.MOVE=ois.readInt();
		this.currentNumber=ois.readInt();
		this.TEAM=ois.readInt();
		this.IMAGE=(ImageIcon) ois.readObject();
		this.SHOWN_IMAGE=(ImageIcon) ois.readObject();
		this.SEEN=ois.readBoolean();
		this.hasMove=ois.readBoolean();
		this.ref=ois.readInt();
	}
	/**
	 * this method is use to save Pieces object
	 * 
	 * @param oos
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void writeObject(ObjectOutputStream oos)throws IOException
	, ClassNotFoundException{
		oos.writeUTF(NAME);
		oos.writeInt(RANK);
		oos.writeInt(WEAKNESS);
		oos.writeObject(position);
		oos.writeInt(NUMBER);
		oos.writeInt(MOVE);
		oos.writeInt(currentNumber);
		oos.writeInt(TEAM);
		oos.writeObject(IMAGE);
		oos.writeObject(SHOWN_IMAGE);
		oos.writeBoolean(SEEN);
		oos.writeBoolean(hasMove);
		oos.writeInt(ref);
	}
}
