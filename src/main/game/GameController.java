package main.game;

import java.util.Timer;
import java.util.TimerTask;

import main.AffGraph.Panel.GamePanel;
import main.game.Pieces.Piece;

public class GameController {

	public class ShowTimer extends TimerTask{
		private Position winner;
		private Piece p;
		private Position att;
		private Position defend;
		
		public ShowTimer(Position winner, Position att, Piece pieceDef){
			this.winner=winner;
			p = pieceDef;
			this.att = att;
			defend = p.position;
			
		}
		
		public ShowTimer(Position winner, Piece pieceAtt, Position defend) {
			this.winner=winner;
			p = pieceAtt;
			att = p.position;
			this.defend = defend;
		}

		public void run() {
			gamePanel.hidePiece(p);
			showWinner(winner, att, defend);
		}
	}
	
	
	AI ai;
	BoardGame boardGame;
	GamePanel gamePanel;
	static GameController instance = null;
	
	private GameController(GamePanel gp){
		ai = AI.getAI();
		boardGame = BoardGame.getBoardGame();
		gamePanel = gp;
	}
	
	public static GameController getGameController(GamePanel gp){
		if(instance==null)
			instance =  new GameController(gp);
		return instance;
	}
	
	public void move(Position previous, Position next){
		if(boardGame.canMove(previous, next)){
			gamePanel.refresh(previous, next);
			boardGame.setMoveCharacter(previous, next);
			gamePanel.upDateBoardGame();
		}
	}
	
	public void attack(Position att, Position defend){
		
		if(Math.abs(att.positionX-defend.positionX)>1 ||
				Math.abs(att.positionY-defend.positionY)>1){
			att=bringCloser(att, defend);
		}
		
		Piece pieceAtt = boardGame.BOARD[att.positionX][att.positionY];
		Piece pieceDef = boardGame.BOARD[defend.positionX][defend.positionY];
		Position winner =ai.attack(pieceAtt, defend);
		Timer t = new Timer();

		if(pieceDef.TEAM!=Team.BLUE){
			gamePanel.showPiece(pieceDef);
			t.schedule(new ShowTimer(winner, att, pieceDef),2000);
		}
		else{
			gamePanel.showPiece(pieceAtt);
			t.schedule(new ShowTimer(winner, pieceAtt, defend),2000);
		}
	}
	
	private void showWinner(Position winner, Position att, Position defend) {
		if(winner==null){
			gamePanel.refresh(att);
			gamePanel.refresh(defend);
			boardGame.BOARD[att.positionX][att.positionY]=null;
			boardGame.BOARD[defend.positionX][defend.positionY]=null;
		}
		else if(winner.positionX==defend.positionX && 
				winner.positionY==defend.positionY){
			gamePanel.refresh(att);
			boardGame.BOARD[att.positionX][att.positionY]=null;
		}
		else{
			gamePanel.refresh(att, defend);
			boardGame.setMoveCharacter(att, defend);
		}
		gamePanel.upDateBoardGame();
	}
	
	private Position bringCloser(Position prev, Position next){
		int closerPosX = 0;
		int closerPosY = 0;
		if(prev.positionX==next.positionX){
			if(prev.positionY<next.positionY){
				closerPosX = next.positionX;
				closerPosY=next.positionY-1;
			}
			else if(prev.positionY>next.positionY){
				closerPosX = next.positionX;
				closerPosY=next.positionY+1;
			}
		}
		else if(prev.positionY==next.positionY){
			if(prev.positionX<next.positionX){
				closerPosY = next.positionX;
				closerPosX=next.positionY-1;
			}
			else if(prev.positionY>next.positionY){
				closerPosX = next.positionX;
				closerPosY=next.positionY+1;
			}
		}
		Position closerPos = new Position(closerPosX, closerPosY);
		move(prev, closerPos );
		return closerPos;
	}
}
