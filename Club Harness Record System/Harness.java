public class Harness
{
	final private String make;
	final private String modelNumber;
	private int timesBorrowed;
	private String lastInstructor;
	private boolean onLoan;
	private String borrowingMember;
	final private int useLimit = 25;
	
	Harness( String make, String modelNumber, int timesUsed, String lastInstructor, boolean onLoan, String borrowingMember )
	{
		this.make = make;
		this.modelNumber = modelNumber;
		this.timesBorrowed = timesUsed;
		this.lastInstructor = lastInstructor;
		this.onLoan = onLoan;
		if( onLoan )
		{
			this.borrowingMember = borrowingMember;
		}
	}
	
	Harness( String make, String modelNumber, String lastInstructor )
	{
		this.make = make;
		this.modelNumber = modelNumber;
		this.lastInstructor = lastInstructor;
		timesBorrowed = 0;
		onLoan = false;
	}
	
	public void checkHarness( String instructor )
	{
		if( !onLoan )
		{
			lastInstructor = instructor;
			timesBorrowed = 0;
		}
	}

	public boolean isHarnessOnLoan()
	{
		return onLoan;
	}
	
	public boolean canHarnessBeLoaned()
	{
		if( !onLoan && timesBorrowed < useLimit )
		{
			return true;
		}
		return false;
	}
	
	public void loanHarness( String clubMember )
	{
		if( canHarnessBeLoaned() )
		{
			borrowingMember = clubMember;
			timesBorrowed++;
			onLoan = true;
		}
	}
	
	public void returnHarness()
	{
		if( onLoan )
		{
			borrowingMember = null;
			onLoan = false;
		}
	}
	
	public String toString()
	{
		if( onLoan )
		{
			return( make + "\n" + modelNumber + "\nused " + timesBorrowed + " times" + "\nLast checked by " + lastInstructor + "\nOn loan to " + borrowingMember );
		}
		return( make + "\n" + modelNumber + "\nused " + timesBorrowed + " times" + "\nLast checked by " + lastInstructor + "\nNot on loan");
	}
	
	public String getMake()
	{
		return make;
	}
	
	public String getModelNumber()
	{
		return modelNumber;
	}
}