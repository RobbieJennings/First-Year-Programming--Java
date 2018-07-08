/*
 * Write a program to determine what class (amphibian, reptile, fish, mammal, or bird)
 * 
 * Class      Blood  Covering     Fins?
 * -----      -----  --------     -----
 * Amphibian  Cold   Moist skin	  No fins
 * Reptile    Cold   Scales       No fins
 * Fish       Cold   Scales       Fins
 * Mammal     Warm   Hair or fur  No fins
 * Bird       Warm   Feathers     No fins
 */

import javax.swing.JOptionPane;

public class Vertebrates

{

	public static void main( String args[] )
	
	{
		
		int coldBloodedQuestion = JOptionPane.showConfirmDialog( null, "Is it cold blooded?" );
		boolean coldBlooded = ( coldBloodedQuestion == JOptionPane.YES_OPTION );
		
		if ( coldBlooded )
		{
			int scalesQuestion = JOptionPane.showConfirmDialog( null, "Does it have scales?" );
			boolean scales = ( scalesQuestion == JOptionPane.YES_OPTION );
			
			if ( !scales )
			{
				JOptionPane.showMessageDialog( null, "It is an amphibian" );
			}
			else
			{
				int finsQuestion = JOptionPane.showConfirmDialog( null, "Does it have fins?" );
				boolean fins = ( finsQuestion == JOptionPane.YES_OPTION );
				
				if ( fins )
				{
					JOptionPane.showMessageDialog( null, "It is a fish" );
				}	
				else
				{
					JOptionPane.showMessageDialog( null, "It is a reptile" );
				}
			}
		}
		
		else
		{
			int feathersQuestion = JOptionPane.showConfirmDialog( null, "Does it have feathers?" );
			boolean feathers = ( feathersQuestion == JOptionPane.YES_OPTION );
			
			if ( feathers )
			{
				JOptionPane.showMessageDialog( null, "It is a bird" );
			}
			else
			{
				JOptionPane.showMessageDialog( null, "It is a mammal" );
			}
		}
		
	}
	
}