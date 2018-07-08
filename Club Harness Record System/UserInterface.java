import java.util.Scanner;

public class UserInterface
{
	public static void main( String args[] )
	{
		In harnessRecords = new In( "Data.txt" );
		HarnessRecords myRecords = new HarnessRecords( harnessRecords );
		boolean finished = false;
		while( !finished )
		{
			Scanner inputScanner = new Scanner( System.in );
			System.out.print( "What would you like to do?: " );
			String input = inputScanner.nextLine();
			if( input.equals( "add" ) )
			{
				System.out.print( "Enter the details of the newly purchased harness separated by commas: " );
				input = inputScanner.nextLine();
				String[] details = input.split( ", " );
				String make = details[ 0 ];
				String modelNumber = details[ 1 ];
				String lastInstructor = details[ 2 ];
				myRecords.addHarness( new Harness( make, modelNumber, lastInstructor ) );
			}
			else if( input.equals( "remove" ) )
			{
				System.out.print( "Enter the make and model number of the harness you wish to remove separated by a comma: ");
				input = inputScanner.nextLine();
				String[] details = input.split( ", " );
				String make = details[ 0 ];
				String modelNumber = details[ 1 ];
				myRecords.removeHarness( make, modelNumber );
			}
			else if( input.equals( "check" ) )
			{
				System.out.print( "Enter the make and model number of the harness you wish to check and the name of the instructor who checked it separated by commas: ");
				input = inputScanner.nextLine();
				String[] details = input.split( ", " );
				String make = details[ 0 ];
				String modelNumber = details[ 1 ];
				String instructor = details[ 2 ];
				myRecords.checkHarness( make, modelNumber, instructor );
			}
			else if( input.equals( "loan" ) )
			{
				System.out.println( "Enter the name of the club member who wishes to borrow a harness: " );
				input = inputScanner.nextLine();
				myRecords.loanHarness( input );
			}
			else if( input.equals( "return" ) )
			{
				System.out.print( "Enter the make and model number of the harness which is being returned separated by a comma: " );
				input = inputScanner.nextLine();
				String[] details = input.split( ", " );
				String make = details[ 0 ];
				String modelNumber = details[ 1 ];
				myRecords.returnHarness( make, modelNumber );
			}
			else if( input.equals( "print" ) )
			{
				for( int index = 0; index < myRecords.getNumberOfHarnesses(); index++ )
				{
					System.out.print( myRecords.getHarness( index ) );
					System.out.println( "" );
					System.out.println( "" );
				}
			}
			else if( input.equals( "quit" ) )
			{
				inputScanner.close();
				finished = true;
			}
		}
	}
}