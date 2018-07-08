public interface Connect4Grid
{
	static final char BLANK = ' ';
	static final int NUMBER_OF_COLUMNS = 7;
	static final int NUMBER_OF_ROWS = 6;
	static final int PIECES_IN_A_ROW_TO_WIN = 4;
	static final char[][] grid = new char[ NUMBER_OF_ROWS ][ NUMBER_OF_COLUMNS ];
	
	void emptyGrid();
	String toString();
	boolean isValidColumn( int column );
	boolean isColumnFull( int column );
	void dropPiece( Connect4Player player, int column );
	boolean didLastPieceConnect4();
	boolean isGridFull();
}