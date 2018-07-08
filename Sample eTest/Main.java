import java.util.Scanner;

public class Main
{
	static Inventory thisInventory = new Inventory();
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner( System.in );
		System.out.print( "How many items do you wish to create?: " );
		int numberOfItems = inputScanner.nextInt();
		for( int index = 1; index <= numberOfItems; index++ )
		{
			inputScanner.nextLine();
			System.out.print( "Enter the name of item " + index + ": " );
			String name = inputScanner.nextLine();
			System.out.print( "Enter the price of item " + index + ": " );
			int price = inputScanner.nextInt();
			inputScanner.nextLine();
			System.out.print( "Enter the quantity of item " + index + ": " );
			int quantity = inputScanner.nextInt();
			thisInventory.addItem( name, price, quantity );
		}
	}
}