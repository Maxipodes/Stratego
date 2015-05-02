package main.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import main.game.Pieces.Bomb;
import main.game.Pieces.Captain;
import main.game.Pieces.Colonel;
import main.game.Pieces.Flag;
import main.game.Pieces.General;
import main.game.Pieces.Lieutenant;
import main.game.Pieces.Major;
import main.game.Pieces.Marshal;
import main.game.Pieces.Miner;
import main.game.Pieces.Piece;
import main.game.Pieces.Scout;
import main.game.Pieces.Sergeant;
import main.game.Pieces.Spy;

public class Team implements Serializable{

	public final static int RED= 0;
	public final static int BLUE = 1;
	public Piece[] charachter = {new Spy(),new Scout(),new Miner(),new Sergeant(),new Lieutenant(),new Captain(),new Major(),new Colonel(),new General(),new Marshal(),new Flag(),new Bomb()};
	
	public Team(int team){
		for(Piece p:charachter){
			p.setTeam(team);
		}
	}
	
	private void readObject(ObjectInputStream ois)throws IOException
	, ClassNotFoundException{
		charachter = new Piece[12];
		for(int i=0; i<12; i++){
			Piece p=(Piece) ois.readObject();
			charachter[p.ref]=p;
		}
	}
	private void writeObject(ObjectOutputStream oos)throws IOException
	, ClassNotFoundException{
		for(Piece p:charachter){
			oos.writeObject(p);
		}
	}
}
