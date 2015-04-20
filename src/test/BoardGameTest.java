package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import main.game.BoardGame;
import main.game.Position;
import main.game.Team;
import main.game.Pieces.Bomb;
import main.game.Pieces.Marshal;
import main.game.Pieces.Miner;
import main.game.Pieces.Piece;
import main.game.Pieces.Scout;
import main.game.Pieces.Spy;

import org.junit.Before;
import org.junit.Test;

public class BoardGameTest {
	
	BoardGame bg;
	Piece[][] board;
	Piece scout;
	Piece bomb;
	Piece miner;
	Piece marshal;
	Piece spy;
	
	@Before public void init(){
		bg =  BoardGame.getBoardGame();
		board =bg.BOARD;
		
		scout = new Scout();
		scout.setPosition(0, 0);
		board[0][0]=scout;
		scout.setTeam(Team.BLUE);
		
		bomb = new Bomb();
		bomb.setPosition(1, 0);
		board[1][0]=bomb;
		bomb.setTeam(Team.BLUE);
		
		miner = new Miner();
		miner.setPosition(2, 0);
		board[2][0]=miner;
		miner.setTeam(Team.RED);
		
		marshal = new Marshal();
		marshal.setPosition(0, 1);
		board[0][1]=marshal;
		marshal.setTeam(Team.RED);
		
		spy = new Spy();
		spy.setPosition(1, 1);
		board[2][0]=spy;
		spy.setTeam(Team.RED);
	}
	
	@Test
	public void SetMoveCharcterTest1() {
		bg.setMoveCharacter(scout.position,new Position(0, 9));
		Assert.assertTrue(bg.BOARD[0][0]==null);
		Assert.assertTrue(scout.position.positionX==0);
		Assert.assertTrue(scout.position.positionY==9);
		Assert.assertTrue(bg.BOARD[0][9].equals(scout));
	}
	
	@Test
	public void canMoveTest(){
		Assert.assertTrue(bg.canMove(marshal.position, spy.position));//sur un ennemie
		Assert.assertFalse(bg.canMove(scout.position, bomb.position));//sur un allié
		Assert.assertTrue(bg.canMove(marshal.position, new Position(0, 2)));//devant lui
		Assert.assertFalse(bg.canMove(marshal.position, new Position(0, 3)));//2 cases devant
		Assert.assertFalse(bg.canMove(bomb.position,new Position(1, 1) ));//D'un pion qui ne peut pas bouger
		Assert.assertFalse(bg.canMove(scout.position, new Position(0,9)));//passer au dessus d un autre pion
		Assert.assertFalse(bg.canMove(marshal.position, new Position(1,2)));//en diagonale
	}

}
