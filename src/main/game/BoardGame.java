package main.game;


public class BoardGame
{
	public static void main(String[] args)
	{
		Piece[][] board=fullInBoardGame();
		Boolean a= AI.canMove(board, new Position(1,2) , new Position(1, 3));
		System.out.println(a);
	}
	
	public static Piece[][] createBoardGame(int lengthX, int lengthY)
	{
		Lake lake = new Lake();
		Piece[][] list = createBoard(lengthX,lengthY);
		list[2][4] = lake.construct();
		list[3][4] = lake.construct();
		list[2][5] = lake.construct();
		list[3][5] = lake.construct();
		list[7][4] = lake.construct();
		list[7][5] = lake.construct();
		list[6][5] = lake.construct();
		list[6][4] = lake.construct();
		
		return list;
	}
	
	
	public static Piece[][] boardGame = createBoardGame(10,10);
	
	public static Piece[] character = {new Spy(),new Scout(),new Miner(),new Sergeant(),new Lieutenant(),new Captain(),new Major(),new Colonel(),new General(),new Marshal(),new Flag(),new Bomb()};
	
	public static Piece[][] createBoard(int dimensionX, int dimensionY)
	{
		Piece[][] list = new Piece[dimensionX][dimensionY];
		return list;
	}
	
	
	public static Piece[][] fullInBoardGame()
	{
		Piece[][] board= new Piece[10][4];
		for(Piece p:character){
			for(int i=0; i<p.NUMBER; i++){
				for(int x=0; x<10; x++){
					for(int y=0; y<4; y++){
						board[x][y] = p.construct();
					}
				}
			}
		}
		return board;
	}
	
	public static boolean isEmpty(Piece[][] board, Position p)
	{
		if (board[p.positionX][p.positionY] == null)
			return true;
		return false;		
	}
	
	
	public static void setMoveCharacter(Piece[][] board, Position p, Position d)
	{
		
		Position intermediatePosition;
		intermediatePosition = p;
		board[p.positionX][p.positionY] = null;
		board[d.positionX][d.positionY] = board[intermediatePosition.positionX][intermediatePosition.positionY];
	}
	
	static int randomNum = 0 + (int)(Math.random()*4);

	public static int countNumber(Piece[] list)
	{
		int count = 0;
		for(int i = 0; i<list.length; i++)
		{
			count += list[i].NUMBER;
		}
		return count;
	}
			
	public static void swap(Piece[][] board, Position p, Position d)
	{
		Position intermediatePosition;
		intermediatePosition = p;
		board[p.positionX][p.positionY] = null;
		board[d.positionX][d.positionY] = board[intermediatePosition.positionX][intermediatePosition.positionY];
	}
	
}
























	
