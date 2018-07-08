/* Write a program which determines if the user should bring an umbrella
 * when they go out
 * (if it looks like it might rain or is raining)
 * and if so whether they should put it up (if it is raining).
 */

import javax.swing.JOptionPane;

public class Umbrella

{
	
	public static void main( String[] args )
	
	{
		
		int raining = JOptionPane.showConfirmDialog( null, "Is it raining?", null, JOptionPane.YES_NO_OPTION );
		
		if ( raining == JOptionPane.CLOSED_OPTION )
		{
			JOptionPane.showMessageDialog( null, "Cancelled" );
		}
		else if ( raining == JOptionPane.YES_OPTION )
		{
			JOptionPane.showMessageDialog( null, "Bring an umbrella and put it up" );
		}
		else
		{
			int mightRain = JOptionPane.showConfirmDialog( null, "Does it look like it might rain?", null, JOptionPane.YES_NO_OPTION );
			if ( mightRain == JOptionPane.CLOSED_OPTION )
			{
				JOptionPane.showMessageDialog( null, "Cancelled" );
			}
			else if ( mightRain == JOptionPane.YES_OPTION )
			{
				JOptionPane.showMessageDialog( null, "Bring an umbrella just in case" );
			}
			else
			{
				JOptionPane.showMessageDialog( null, "Don't bother bringing an umbrella" );
			}			
		}
		
	}

}