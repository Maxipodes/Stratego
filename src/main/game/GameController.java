package main.game;

import main.AffGraph.Panel.GamePanel;
import main.game.Pieces.Piece;

public class GameController {

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
		Piece pieceAtt = boardGame.BOARD[att.positionX][att.positionY];
		Position winner =ai.attack(pieceAtt, defend);
		if(winner==null){
			gamePanel.refresh(att);
			gamePanel.refresh(defend);
			boardGame.BOARD[att.positionX][att.positionY]=null;
			boardGame.BOARD[defend.positionX][defend.positionY]=null;
		}
		else if(winner.equals(defend)){
			gamePanel.refresh(att);
			boardGame.BOARD[att.positionX][att.positionY]=null;
		}
		else{
			gamePanel.refresh(att, defend);
			boardGame.setMoveCharacter(att, defend);
		}
		gamePanel.upDateBoardGame();
	}
}
