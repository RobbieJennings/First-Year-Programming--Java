import java.util.Arrays;
import java.util.Scanner;

public class LewisCarrollsWordLinksPuzzleGame 
{

	public static void main( String args[] )
	{
		In words = new In( "words" );
		String[] dictionary = readDictionary( words );
		Scanner inputScanner = new Scanner( System.in );
		boolean finished = false;
		while( !finished )
		{
			System.out.print( "Enter a comma separated list of words (or an empty list to quit): " );
			String input = inputScanner.nextLine();
			if( !input.equals( "" ) )
			{
				String[] wordList = readWordList( input );
				if( isWordChain( dictionary, wordList ) )
				{
					System.out.println( "Valid chain of words from Lewis Carroll's word-links game." );
				}
				else
				{
					System.out.println( "Not a valid chain of words from Lewis Carroll's word-links game." );
				}
			}
			else
			{
				inputScanner.close();
				finished = true;
			}
		}
	}
	
	public static String[] readDictionary( In words )
	{
		String dictionary = words.readAll();
		return dictionary.split( "\r" + "\n" );
	}
	
	public static String[] readWordList( String wordList )
	{
		return wordList.split( "," );
	}
	
	public static boolean isUniqueList( String[] wordList )
	{
		for( int count = 0; count < wordList.length; count++ )
		{
			for( int index = count + 1; index < wordList.length; index++ )
			{
				if( wordList[ count ].equals( wordList[ index] ) )
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isEnglishWord( String[] dictionary, String word )
	{
		return ( Arrays.binarySearch( dictionary, word ) >= 0 );
	}
	
	public static boolean isDifferentByOne( String word1, String word2 )
	{
		if( word1.length() != word2.length() )
		{
			return false;
		}
		int count = 0;
		for( int index = 0; index < word1.length(); index++ )
		{
			if( word1.charAt( index ) != word2.charAt( index ) )
			{
				count++;
			}
		}
		if( count != 1 )
		{
			return false;
		}
		return true;
	}
	
	public static boolean isWordChain( String[] dictionary, String[] wordList )
	{
		if( !isUniqueList( wordList ) )
		{
			return false;
		}
		for( int index = 0; index < wordList.length; index++ )
		{
			if( !isEnglishWord( dictionary, wordList[ index ] ) )
			{
				return false;
			}
		}
		for( int index = 1; index < wordList.length; index++ )
		{
			if( !isDifferentByOne( wordList[ index - 1 ], wordList[ index ] ) )
			{
				return false;
			}
		}
		return true;
	}
	
}