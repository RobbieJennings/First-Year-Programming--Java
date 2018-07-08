/*
 * Write a program which takes a date in day/month/year format (e.g. 25/11/2015)
 * and, if the date is valid, then it presents the date in, for example, “Wednesday, 25th November 2015” format.
 * 
 * You must write and make use of at least the following functions:
 * numberEnding() which takes a day number returns “th”, “st”, “nd” or “rd”.
 * monthName() which takes a month number (1-12) and return “January”, or “February”, …
 * dayOfTheWeek() which takes a day, month and year and returns “Monday”, or “Tuesday”, …
 * 
 * The day of the week function should use the Gaussian algorithm…
 * w = (day + floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + floor(y/4) + floor(c/4) - 2c) mod 7
 * 
 * where:
 * Y: year-1 for January or February,
 * 	  year for the rest of the year
 * y: last 2 digits of Y
 * c: first 2 digits of Y
 * w: day of week (0=Sunday,..6=Saturday)
 * 
 * mod 7 needs to return a positive number (even if the passed value is negative).
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class DayOfTheWeek
{
	public static final int NUMBER_OF_MONTHS = 12;
	public static final int DAYS_IN_JANUARY_MARCH_MAY_JULY_AUGUST_OCTOBER_DECEMBER = 31;
	public static final int DAYS_IN_NORMAL_FEBRUARY = 28;
	public static final int DAYS_IN_lEAP_YEAR_FEBRUARY = 29;
	public static final int DAYS_IN_APRIL_JUNE_SEPTEMBER_NOVEMBER = 30;
	
	public static void main( String args[] )
	{
		boolean finished = false;
		while( !finished )
		{
			try
			{
				String Input = JOptionPane.showInputDialog( null, "Enter a date in day/month/year format"
						+ " (e.g. 25/11/2015)" );
				Scanner inputScanner = new Scanner( Input );
				inputScanner.useDelimiter( "/" );
				int day = inputScanner.nextInt();
				int month = inputScanner.nextInt();
				int year = inputScanner.nextInt();
				inputScanner.close();
			
				if( isValidDate( day, month, year ) )
				{
					JOptionPane.showMessageDialog( null, "The date is " + dayOfTheWeek( day, month, year )
						+ ", " + day + numberEnding( day ) + " " + monthName( month ) + " " + year );
				}
				else
				{
					JOptionPane.showMessageDialog( null, "Invalid Date." );
				}
			}
			catch( java.util.NoSuchElementException exception )
			{
				JOptionPane.showMessageDialog( null, "Invalid Input" );
			}
			catch (NullPointerException exception)
			{
				finished = true;
			}
		}
	}
	
	public static String numberEnding( int day )
	{
		String numberEnding;
		if( ( day % 100 ) / 10 == 1 )
			numberEnding = "th";
		else
		{
			switch( day % 10 )
			{
				case 1:
					numberEnding = "st";
					break;
				case 2:
					numberEnding = "nd";
					break;
				case 3:
					numberEnding = "rd";
					break;
				default:
					numberEnding = "th";
					break;
			}
		}
		return numberEnding;
	}
	
	public static String monthName( int month )
	{
		String monthName;
		switch( month )
		{
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "February";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			default:
				monthName = "";
				break;
		}
		return monthName;
	}
	
	public static String dayOfTheWeek( int day, int month, int year )
	{
		int formulaYear;
		if( month == 1 || month == 2 )
			formulaYear = year - 1;
		else
			formulaYear = year;
		
		int lastTwoDigitsOfYear = formulaYear % 100;
		
		int firstTwoDigitsOfYear = formulaYear / 100;
		
		int dayNumber = Math.floorMod( (int) ( day 
				+ Math.floor( 2.6 * ( ( ( month + 9 ) % 12 ) + 1 ) - 0.2 )
				+ lastTwoDigitsOfYear
				+ Math.floor(lastTwoDigitsOfYear / 4)
				+ Math.floor( firstTwoDigitsOfYear / 4 )
				- 2 * (firstTwoDigitsOfYear ) ), 7);
		
		String dayOfTheWeek;
		switch( dayNumber )
		{
			case 0:
				dayOfTheWeek = "Sunday";
				break;
			case 1:
				dayOfTheWeek = "Monday";
				break;
			case 2:
				dayOfTheWeek = "Tuesday";
				break;
			case 3:
				dayOfTheWeek = "Wednesday";
				break;
			case 4:
				dayOfTheWeek = "Thursday";
				break;
			case 5:
				dayOfTheWeek = "Friday";
				break;
			case 6:
				dayOfTheWeek = "Saturday";
				break;
			default:
				dayOfTheWeek = "";
				break;
		}
		return dayOfTheWeek;
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
		return( year >= 0 && month <= NUMBER_OF_MONTHS && month >=0 && day >=1 && day <= daysInMonth( month, year ) );
	}

}