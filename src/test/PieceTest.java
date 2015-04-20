package test;

import static org.junit.Assert.*;
import main.game.BoardGame;
import main.game.Team;
import main.game.Pieces.Bomb;
import main.game.Pieces.Marshal;
import main.game.Pieces.Miner;
import main.game.Pieces.Piece;
import main.game.Pieces.Scout;
import main.game.Pieces.Spy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PieceTest {
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
	public final void testIsStronger() {
		System.out.println(bomb.RANK+"  "+marshal.RANK);
		Assert.assertTrue(bomb.isStronger(marshal));
		Assert.assertFalse(marshal.isStronger(bomb));
		Assert.assertTrue(miner.isStronger(bomb));
		Assert.assertTrue(spy.isStronger(marshal));
		Assert.assertTrue(marshal.isStronger(spy));
		Assert.assertTrue(miner.isStronger(scout));
	}

}
