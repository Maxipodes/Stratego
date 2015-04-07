package main.game;

public class BoardGame
{
	public static void main(String[] args)
	{
		BoardGame boardGame = getBoardGame();
		boardGame.randFillInBoardGame(charachter);
		//System.out.println(boardGame[0][0].NAME);
		boardGame.printTab();
		BoardGame bob = getBoardGame();
		System.out.println("\n");
		bob.printTab();
		bob.setMoveCharacter(bob.BOARD[3][0].position,4,0);		
		System.out.println("\n");
		bob.printTab();
		//setMoveCharachter(boardGame,boardGame[3][0].position,4,0);
		//System.out.println("\n");
		//printTab(boardGame);
		
	}
	
	static int LENGTHX;
	int LENGTHY;
	public Piece[][] BOARD;
	
	
	
	private static BoardGame instance = null;
	
	public static BoardGame getBoardGame()
	{
		if (instance == null)
			instance =  new BoardGame();
		return instance;
		
	}
	
	
	public BoardGame()
	{
		LENGTHX = 10;
		LENGTHY = 10;
		BOARD = createBoardGame(LENGTHX,LENGTHY);
	}
	
	
	
	
	public static Piece[][] createBoardGame(int lengthX, int lengthY)
	{
		Piece[][] list = new Piece[lengthX][lengthY];
		list[4][2] = new Lake(4,2);
		list[4][3] = new Lake(4,3);
		list[5][2] = new Lake(5,2);
		list[5][3] = new Lake(5,3);
		list[4][7] = new Lake(4,7);
		list[5][7] = new Lake(5,7);
		list[5][6] = new Lake(5,6);
		list[4][6] = new Lake(4,6);
		
		return list;
	}
	public void printTab()
	{ 
		for(int i=0; i < BOARD.length; i++)
		{
			for(int j=0; j < BOARD[0].length;j ++)
			{
				if (isEmpty(i, j) == false)
					System.out.print(" "+BOARD[i][j].NAME +" | "+ i + ","+ j+" || ");	
				else 
					System.out.print(" X"+" | "+i+","+j+" || ");
			}
			System.out.println();
		}
	}

	public static BoardGame boardGame = getBoardGame();
	
	public static Piece[] charachter = {new Spy(),new Scout(),new Miner(),new Sergeant(),new Lieutenant(),new Captain(),new Major(),new Colonel(),new General(),new Marshal(),new Flag(),new Bomb()};
	
	public void fillIn(Piece p, int x, int y)
	{
			Piece piece = p.construct();
			piece.setPosition(x, y);
			BOARD[x][y] = piece;
	}
	
	public boolean isEmpty(int x, int y)
	{
		if (BOARD[x][y] == null)
			return true;
		return false;		
	}
	
	
	public void setMoveCharacter(Position p, int x , int y)
	{
		Piece move = BOARD[p.positionX][p.positionY];
		BOARD[p.positionX][p.positionY] = null;
		BOARD[x][y] = move;
		move.setPosition(x,y);
	}
	

	public static int countNumber(Piece[] list)
	{
		int count = 0;
		for(int i = 0; i<list.length; i++)
		{
			count += list[i].NUMBER;
		}
		return count;
	}
			
	public void swap(Position p, Position d)
	{
		Piece swap = BOARD[p.positionX][p.positionY];
		Position A = p;
		Position B = d;
		BOARD[p.positionX][p.positionY] = BOARD[d.positionX][d.positionY];
		BOARD[d.positionX][d.positionY] = swap;
		BOARD[p.positionX][p.positionY].setPosition(A.positionX,A.positionY);
		BOARD[d.positionX][d.positionY].setPosition(B.positionX,B.positionY);	
	}
	
	
	
	public void fillInBoardGame(Piece[] list)
	{
		
		int x=0;
		int numberPiece = 0;
		for(int k = 0; k < 4; k++)
		{
			for(int i = 0; i < 10; i++)
			{
				Piece currentPiece =list[x];
				if(numberPiece<currentPiece.NUMBER)
				{
					fillIn(currentPiece, k, i);
					numberPiece++;
				}
				if(numberPiece==currentPiece.NUMBER)
				{
					x++;
					numberPiece=0;
				}
			}
		}
				
				
	}			 
	public  void randFillInBoardGame(Piece[] list)
	{
		fillInBoardGame(list);
		for(int k = 0; k < 4; k++)
		{
			for(int i = 0; i < 10; i++)
			{
				int randX = (int)(Math.random()*4);
				int randY = (int)(Math.random()*10);
				Piece p = BOARD[k][i];
				Piece l = BOARD[randX][randY];
				swap(p.position,l.position);
			}
		}
	}
			
	
}
























	
