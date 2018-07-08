import java.util.ArrayList;

public class BookStoreManager
{
	final static ArrayList< Book > booksCollection = new ArrayList< Book >();
	
	BookStoreManager( In books )
	{
		int numberOfBooks = books.readInt();
		for( int index = 0; index < numberOfBooks; index++ )
		{
			String isbn = books.readLine();
			String title = books.readLine();
			String author = books.readLine();
			int quantity = books.readInt();
			Book thisBook = new Book( isbn, title, author, quantity );
			booksCollection.add( thisBook );
		}
	}
	
	void printBooks()
	{
		for( int index = 0; index < booksCollection.size(); index++ )
		{
			Book thisBook = booksCollection.get( index );
			System.out.println( thisBook.toString() );
		}
	}
	
	public static void main( String args[] )
	{
		In books = new In( "books.txt" );
		BookStoreManager manager = new BookStoreManager( books );
		booksCollection.sort( null );
		manager.printBooks();
	}
}
