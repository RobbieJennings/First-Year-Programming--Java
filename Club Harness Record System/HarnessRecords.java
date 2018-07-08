import java.util.ArrayList;

public class HarnessRecords
{
	ArrayList< Harness > harnessArray;
	int numberOfHarnesses;
	
	HarnessRecords()
	{
		harnessArray = new ArrayList< Harness >();
		numberOfHarnesses = 0;
	}
	
	HarnessRecords( In inputStream )
	{
		harnessArray = new ArrayList< Harness >();
		String input = inputStream.readAll();
		String[] inputArray = input.split( "\r" + "\n" );
		this.numberOfHarnesses = Integer.parseInt( inputArray[0] );
		for( int index = 1; index < inputArray.length; index++ )
		{
			Harness currentHarness;
			String[] harnessData = inputArray[ index ].split( ", " );
			String make = harnessData[ 0 ];
			String modelNumber = harnessData[ 1 ];
			String lastInstructor = harnessData[ 2 ];
			if( harnessData.length > 3 )
			{
				int timesUsed = Integer.parseInt( harnessData[ 3 ] );
				boolean onLoan;
				if( harnessData[ 4 ].equals( "on loan" ) )
				{
					onLoan = true;
					String borrowingMember = harnessData[ 5 ];
					currentHarness = new Harness( make, modelNumber, timesUsed, lastInstructor, onLoan, borrowingMember );
				}
				else
				{
					onLoan = false;
					currentHarness = new Harness( make, modelNumber, timesUsed, lastInstructor, onLoan, "" );
				}
			}
			else
			{
				currentHarness = new Harness( make, modelNumber, lastInstructor );
			}
			harnessArray.add( currentHarness );
		}
	}
	
	public boolean isEmpty()
	{
		return( harnessArray.size() == 0 );
	}
	
	public void addHarness( Harness myHarness )
	{
		harnessArray.add( myHarness );
		numberOfHarnesses++;
	}
	
	public Harness findHarness( String make, String modelNumber )
	{
		for( int index = 0; index < harnessArray.size(); index++)
		{
			Harness currentHarness = harnessArray.get( index );
			if( currentHarness != null && currentHarness.getMake().equals( make ) && currentHarness.getModelNumber().equals( modelNumber ) )
			{
				return currentHarness;
			}
		}
		return null;
	}
	
	public Harness checkHarness( String make, String modelNumber, String instructor )
	{
		Harness myHarness = findHarness( make, modelNumber );
		if( myHarness != null && !myHarness.isHarnessOnLoan() )
		{
			myHarness.checkHarness( instructor );
			return myHarness;
		}
		return myHarness;
	}
	
	public Harness loanHarness( String clubMember )
	{
		for( int index = 0; index < harnessArray.size(); index++ )
		{
			if( harnessArray.get( index ).canHarnessBeLoaned() )
			{
				harnessArray.get( index ).loanHarness( clubMember );
				return harnessArray.get( index );
			}
		}
		return null;
	}
	
	public Harness returnHarness( String make, String modelNumber )
	{
		Harness myHarness = findHarness( make, modelNumber );
		if( myHarness != null && myHarness.isHarnessOnLoan() )
		{
			myHarness.returnHarness();
			return myHarness;
		}
		return null;
	}
	
	public Harness removeHarness( String make, String modelNumber )
	{
		Harness myHarness = findHarness( make, modelNumber );
		if( myHarness != null && !myHarness.isHarnessOnLoan() )
		{
			harnessArray.remove( myHarness );
			this.numberOfHarnesses--;
			return myHarness;
		}
		return null;
	}
	
	public Harness getHarness( int index )
	{
		return harnessArray.get( index );
	}
	
	public int getNumberOfHarnesses()
	{
		return harnessArray.size();
	}
}