public class TwelveDaysOfChristmas
{
	public static void main ( String args[] )	
	{		
		String day = "";
		String gifts = "";
		for( int verse = 1; verse <= 12; verse++ )
		{									
			switch( verse )
			{
			case 1:
				day = "first";
				gifts = "a Partridge in a Pear Tree.";
				break;
			case 2:
				day = "second";
				gifts = "Two Turtle Doves\nand " + gifts;
				break;
			case 3:
				day = "third";
				gifts = "Three French Hens,\n" + gifts;
				break;
			case 4:
				day = "fourth";
				gifts = "Four Calling Birds,\n" + gifts;
				break;
			case 5:
				day = "fifth";
				gifts = "Five Golden Rings,\n" + gifts;
				break;
			case 6:
				day = "sixth";
				gifts = "Six Geese a Laying,\n" + gifts;
				break;
			case 7:
				day = "seventh";
				gifts = "Seven Swans a Swimming,\n" + gifts;
				break;
			case 8:
				day = "eighth";
				gifts = "Eight Maids a Milking,\n" + gifts;
				break;
			case 9:
				day = "ninth";
				gifts = "Nine Ladies Dancing,\n" + gifts;
				break;
			case 10:
				day = "tenth";
				gifts = "Ten Lords a Leaping,\n" + gifts;
				break;
			case 11:
				day = "eleventh";
				gifts = "Eleven Pipers Piping,\n" + gifts;
				break;
			case 12:
				day = "twelfth";
				gifts = "Twelve Drummers Drumming,\n" + gifts;
				break;
			default:
				day = "";
				gifts = "";
				break;
			}
			System.out.println( "On the " + day + " day of Christmas\nMy true love sent to me:\n" + gifts + "\n" );
		}
	}
}