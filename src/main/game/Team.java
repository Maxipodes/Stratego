package main.game;

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

public class Team {

	public final static int RED= 0;
	public final static int BLUE = 1;
	public Piece[] charachter = {new Spy(),new Scout(),new Miner(),new Sergeant(),new Lieutenant(),new Captain(),new Major(),new Colonel(),new General(),new Marshal(),new Flag(),new Bomb()};
	
	public Team(int team){
		for(Piece p:charachter){
			p.setTeam(team);
		}
	}
}
