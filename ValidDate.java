import java.util.Scanner;
import javax.swing.JOptionPane;

public class ValidDate
{
	public static final int NUMBER_OF_MONTHS = 12;
	public static final int DAYS_IN_JANUARY_MARCH_MAY_JULY_AUGUST_OCTOBER_DECEMBER = 31;
	public static final int DAYS_IN_NORMAL_FEBRUARY = 28;
	public static final int DAYS_IN_lEAP_YEAR_FEBRUARY = 29;
	public static final int DAYS_IN_APRIL_JUNE_SEPTEMBER_NOVEMBER = 31;
	
	public static void main( String args[] )
	{
		String Input = JOptionPane.showInputDialog( null, "Enter the date in day/month/year format (e.g. 25/11/2015)" );
		Scanner inputScanner = new Scanner( Input );
		inputScanner.useDelimiter( "/" );
		int day = inputScanner.nextInt();
		int month = inputScanner.nextInt();
		int year = inputScanner.nextInt();
		inputScanner.close();
		
		if( isValidDate( day, month, year) )
			JOptionPane.showMessageDialog( null, day + "/" + month + "/" + year + " is a valid date.");
		else
			JOptionPane.showMessageDialog( null, "Invalid Date" );
	}
	
	public static boolean isLeapYear( int year )
	{
		return( ( year % 400 == 0 ) || ( ( year % 4 == 0 ) && ( year % 100 != 0 ) ) );	
	}
	
	public static int daysInMonth( int month, int year )
	{
		int daysInMonth;
		switch( month )
		{
			case 2:
				if( isLeapYear( year ) )
					daysInMonth = DAYS_IN_lEAP_YEAR_FEBRUARY;
				else
					daysInMonth = DAYS_IN_NORMAL_FEBRUARY;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysInMonth = DAYS_IN_APRIL_JUNE_SEPTEMBER_NOVEMBER;
				break;
			default:
				daysInMonth = DAYS_IN_JANUARY_MARCH_MAY_JULY_AUGUST_OCTOBER_DECEMBER;
				break;
		}
		return daysInMonth;
	}
	
	public static boolean isValidDate( int day, int month, int year )
	{
		return( year >= 0 && month <= NUMBER_OF_MONTHS && day >=1 && day <= daysInMonth( month, year ) );
	}
}