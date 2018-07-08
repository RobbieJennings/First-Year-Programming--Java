abstract class Connect4Player
{
	char playerPiece;
	
	Connect4Player( char playerPiece )
	{
		this.playerPiece = playerPiece;
	}
	
	char getPlayerPiece()
	{
		return this.playerPiece;
	}
	
	abstract void makeMove( Connect4Grid grid );
}