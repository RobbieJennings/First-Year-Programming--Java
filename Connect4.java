import java.util.Scanner;

public class Connect4 
{
	
	public static final char BLANK = ' ';
	public static final char PLAYER1_PIECE = '+';
	public static final char PLAYER2_PIECE = 'O';
	public static final int BOARD_WIDTH = 7;
	public static final int BOARD_HEIGHT = 6;
	public static final int PIECES_IN_A_ROW_TO_WIN = 4;
	
	public static void main(String[] args) {
		char[][] board = new char[BOARD_HEIGHT][BOARD_WIDTH];
		clearBoard( board );
		char currentPlayerPiece = PLAYER1_PIECE;
		Scanner input = new Scanner(System.in);
		while ((!isBoardFull(board)) && (winner(board) == BLANK))
		{
			printBoard(board);
			int column=-1;
			do
			{
				System.out.print("Enter move for " + currentPlayerPiece + ": ");
				char[] inputCharacters = input.next().toCharArray();
				if ((inputCharacters.length >= 1) &&
					(inputCharacters[0] >= '1') && (inputCharacters[0] <= '0'+BOARD_WIDTH))
				{
					column = (int) (inputCharacters[0]-'1');
					if (!canMakeMove(board,column))
						System.out.println(" Invalid entry.  This column is already full.");
				}
				else System.out.println(" Invalid entry.  You must enter a column number between 1 and " + BOARD_WIDTH + ".");
			} while ((column == -1) || (!canMakeMove(board,column)));
			makeMove(board,currentPlayerPiece,column);
			currentPlayerPiece = (currentPlayerPiece==PLAYER1_PIECE)? PLAYER2_PIECE : PLAYER1_PIECE;
		}
		printBoard(board);
		if (winner(board) == BLANK)
			System.out.println("It was a draw.");
		else System.out.println("The winner was " + winner(board));
		input.close();
	}
	
	public static void clearBoard( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			for( int column = 0; column < board[ row ].length; column++ )
			{
				board[ row ][ column ] = BLANK;
			}
		}
	}
	
	public static void printBoard( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			for( int column = 0; column < board[ row ].length; column++ )
			{
				System.out.print( "| " + board[ row ][ column ] + " " );
				if( column >= board[ row ].length - 1 )
				{
					System.out.print( "|" );
				}
			}
			System.out.println( "" );
		}
		System.out.print( "-" );
		for( int index = 0; index < BOARD_WIDTH; index++ )
		{
			System.out.print( "----" );
		}		
		System.out.println( "" );
		for( int index = 1; index <= BOARD_WIDTH; index++ )
		{
			System.out.print( "  " + index + " ");
		}
		System.out.println( "" );
	}
	
	public static boolean canMakeMove( char[][] board, int column )
	{
		for( int row = board.length - 1; row >= 0; row-- )
		{
			if( board[ row ][ column ] == BLANK )
			{
				return true;
			}
		}
		return false;
	}
	
	public static void makeMove( char[][] board, char playerPiece, int column )
	{
		for( int row = board.length - 1; row >= 0; row-- )
		{
			if( board[ row ][ column ] == BLANK )
			{
				board[ row ][ column ] = playerPiece;
				break;
			}
		}
	}
	
	public static boolean isBoardFull( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			for( int column = 0; column < board[ row ].length; column++ )
			{
				if( board[ row ][ column ] == BLANK )
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static char winner( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			if( board[ row ][ 0 ] == board[ row ][ 1 ] && board[ row ][ 1 ] == board[ row ][ 2 ] && board[ row ][ 2 ] == board[ row ][ 3 ] && board[ row ][ 3 ] == board[ row ][ 4 ]
					|| board[ row ][ 1 ] == board[ row ][ 2 ] && board[ row ][ 2 ] == board[ row ][ 3 ] && board[ row ][ 3 ] == board[ row ][ 4 ] && board[ row ][ 4 ] == board[ row ][ 5 ]
					|| board[ row ][ 2 ] == board[ row ][ 3 ] && board[ row ][ 3 ] == board[ row ][ 4 ] && board[ row ][ 4 ] == board[ row ][ 5 ] && board[ row ][ 5 ] == board[ row ][ 6 ]
					|| board[ row ][ 3 ] == board[ row ][ 4 ] && board[ row ][ 4 ] == board[ row ][ 5 ] && board[ row ][ 5 ] == board[ row ][ 6 ] && board[ row ][ 6 ] == board[ row ][ 7 ] )
			{
				return board[ row ][ 4 ];
			}
		}
		for( int column = 0; column < board[ 1 ].length; column++ )
		{
			if( board[ 0 ] [ column ] == board[ 1 ][ column ] && board[ 1 ][ column ] == board[ 2 ][ column ] &&  board[ 2 ][ column ] == board[ 3 ][ column ] && board[ 3 ][ column ] == board[ 4 ][ column ]
					|| board[ 1 ][ column ] == board[ 2 ][ column ] && board[ 2 ][ column ] == board[ 3 ][ column ] && board[ 3 ][ column ] == board[ 4 ][ column ] && board[ 4 ][ column ] == board[ 5 ][ column ] 
					|| board[ 2 ][ column ] == board[ 3 ][ column ] && board[ 3 ][ column ] == board[ 4 ][ column ] && board[ 4 ][ column ] == board[ 5 ][ column ] && board[ 5 ][ column ] == board[ 6 ][ column ] )
			{
				return board[ 4 ][ column ];
			}
		}
		return BLANK;
	}
	
}