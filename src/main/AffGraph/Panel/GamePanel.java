package main.AffGraph.Panel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.game.AI.AI;
import main.game.BoardGame;
import main.game.GameController;
import main.game.Position;
import main.game.Team;
import main.game.Pieces.Piece;

public class GamePanel extends JPanel{
	
	public class ControlListener implements MouseListener{
		
		Position piecePos;
		Position destPos;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(gameController.getGameTurn()+ " GameTurn");
			if(gameController.getGameTurn()==0){
				int posX = e.getX();
				int posY = e.getY();
				Position pos = new Position(posX, posY);
				Position coord = pixToCoord(pos);
			
				if(piecePos==null){
					if(boardGame.BOARD[coord.positionX][coord.positionY]!=null){
						if(boardGame.BOARD[coord.positionX][coord.positionY].TEAM==Team.BLUE){
							piecePos = coord;
							System.out.println(piecePos+"   "+"piecePos");
						}
					}
				}

				else if(piecePos!=null){
					destPos=coord;
					System.out.println(destPos+"   "+"destPos");
					if(boardGame.canMove(piecePos, destPos)){
						if(boardGame.BOARD[destPos.positionX][destPos.positionY]==null){
							gameController.move(piecePos, destPos);
						}
						else if(boardGame.BOARD[destPos.positionX][destPos.positionY].TEAM!=Team.BLUE){
							gameController.attack(piecePos, destPos);
						}
					}
					else
						System.out.println("Can t move");
					piecePos = null;
				
				}
			
			}
		}


		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	int height;
	int width;
	ImageIcon background;
	BoardGame boardGame;
	GameController gameController;
	int caseWidth;
	int caseHeight;
	public MainPanel mainPanel ;
	
	public GamePanel(MainPanel mp){
		super();
		super.addMouseListener(new ControlListener());
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Logo.jpg";
		
		background = new ImageIcon(image);
		boardGame =BoardGame.getBoardGame();
		boardGame.randFillInBoardGame();
		gameController = GameController.getGameController(this);
		mainPanel=mp;

	}
	
	public void setBoardGame(Piece[][] tab){
		boardGame.setBoardGame(tab);
	}
	
	public void setAI(AI ai){
		gameController.setAI(ai);
	}
	
	public void setPlacement(Piece[][] pieceTab){
		for(int y=0; y < pieceTab[0].length; y++){
			for(int x=0; x<pieceTab.length; x++){
				boardGame.BOARD[x][y+6] = pieceTab[x][y]; 
				boardGame.BOARD[x][y+6].setPosition(x, y+6);
			}
		}
	}
	
	private Position coordToPix(Position p){
		int caseHeight = height/10;
		int caseWidth = width/10;
		int newWidth = p.positionX*caseWidth;
		int newHeight = p.positionY*caseHeight;
		
		
		return new Position(newWidth, newHeight);
		
	}
	
	private Position pixToCoord(Position position) {
		int caseHeight = height/10;
		int caseWidth = width/10;
		
		int coordX = position.positionX/caseWidth;
		int coordY = position.positionY/caseHeight;
		return new Position(coordX, coordY);
	}
	
	private Rectangle getRect(Position p){
		int caseHeight = height/10;
		int caseWidth = width/10;
		int lowerRigthCornerX = p.positionX+caseWidth;
		int lowerRigthCornerY = p.positionY+caseHeight;
		
		return new Rectangle(p.positionX, p.positionY, lowerRigthCornerX , lowerRigthCornerY);
	}
	
	public void refresh(Position pos, Position movedPos){
		Piece p = boardGame.BOARD[pos.positionX][pos.positionY];
		
		
		Position newPos = coordToPix(pos);
		Rectangle rect = getRect(newPos);
		repaint(rect);
		
		Position newMovedPos =coordToPix(movedPos);
		getGraphics().drawImage(p.getImage(), newMovedPos.positionX, newMovedPos.positionY, caseWidth, caseHeight, null);
	}
	
	public void refresh(Position pos){
		Position newPos = coordToPix(pos);
		Rectangle rect = getRect(newPos);
		repaint(rect);
	}
	
	public void showPiece(Piece p){
		Position coord = p.position;
		Position pos = coordToPix(coord);
		getGraphics().drawImage(p.getShownImage(), pos.positionX, pos.positionY,caseWidth, caseHeight, this);
	}
	
	public void hidePiece(Piece p){
		Position coord = p.position;
		Position pos = coordToPix(coord);
		getGraphics().drawImage(p.getImage(), pos.positionX, pos.positionY,caseWidth, caseHeight, this);
	}
	
	public void upDateBoardGame(){
		boardGame=BoardGame.getBoardGame();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		height = super.getHeight();
		width = super.getWidth();
		
		caseWidth = width/10;
		caseHeight = height/10;
	
		
		g.drawImage( background.getImage(), 0, 0, null);
		
		for(Piece[] line:this.boardGame.BOARD){
			for(Piece character:line){
				if(character != null){
					Position newPos = coordToPix(character.position);
					g.drawImage(character.getImage(), newPos.positionX, 
							newPos.positionY,caseWidth, caseHeight,null);
				}
			}
		}
			
	}

}
