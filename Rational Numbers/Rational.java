public class Rational
{
	int numerator;
	int denominator;
	
	Rational( int numerator, int denominator )
	{
		this.numerator = numerator;
		this.denominator = denominator;
		this.simplify();
	}
	
	Rational( int numerator )
	{
		this.numerator = numerator;
		this.denominator = 1;
	}
	
	public Rational add( Rational newRational )
	{
		int numerator1 = this.numerator;
		int numerator2 = newRational.numerator;
		int denominator1 = this.denominator;
		int denominator2 = newRational.denominator;
		int newDenominator = denominator1 * denominator2;
		int newNumerator = ( numerator1 * ( newDenominator / denominator1 ) ) + ( numerator2 * ( newDenominator / denominator2 ) );
		return( new Rational( newNumerator, newDenominator ).simplify() );
	}
	
	public Rational subtract( Rational newRational )
	{
		int numerator1 = this.numerator;
		int numerator2 = newRational.numerator;
		int denominator1 = this.denominator;
		int denominator2 = newRational.denominator;
		int newDenominator = denominator1 * denominator2;
		int newNumerator = ( numerator1 * ( newDenominator / denominator1 ) ) - ( numerator2 * ( newDenominator / denominator2 ) );
		return( new Rational( newNumerator, newDenominator ).simplify() );
	}
	
	public Rational multiply( Rational newRational )
	{
		int numerator1 = this.numerator;
		int numerator2 = newRational.numerator;
		int denominator1 = this.denominator;
		int denominator2 = newRational.denominator;
		int newNumerator = numerator1 * numerator2;
		int newDenominator = denominator1 * denominator2;
		return( new Rational( newNumerator, newDenominator ).simplify() );
	}
	
	public Rational divide( Rational newRational )
	{
		int numerator1 = this.numerator;
		int numerator2 = newRational.numerator;
		int denominator1 = this.denominator;
		int denominator2 = newRational.denominator;
		int newNumerator = numerator1 * denominator2;
		int newDenominator = denominator1 * numerator2;
		return( new Rational( newNumerator, newDenominator ).simplify() );
	}
	
	public boolean equals( Rational newRational )
	{
		Rational remainder = subtract( newRational );
		int numerator = remainder.numerator;
		return( numerator == 0 );
	}
	
	public boolean isLessThan( Rational newRational )
	{
		Rational remainder = subtract( newRational );
		int numerator = remainder.numerator;
		int denominator = remainder.denominator;
		return( ( numerator < 0 && denominator > 0 ) || ( numerator > 0 && denominator < 0 ) );
	}
	
	public Rational simplify()
	{
		if( this.numerator == 0 )
		{
			this.numerator = 0;
			this.denominator = 1;
			return this;
		}
		boolean finished = false;
		int greatestCommonDivisor = Math.abs( this.denominator );
		if( Math.abs( this.numerator ) < Math.abs( this.denominator ) )
		{
			greatestCommonDivisor = Math.abs( this.numerator );
		}
		while( !finished )
		{
			if( ( this.numerator % greatestCommonDivisor == 0 ) && ( this.denominator % greatestCommonDivisor == 0 ) )
			{
				finished = true;
			}
			else
			{
				greatestCommonDivisor--;
			}
		}
		this.numerator = numerator / greatestCommonDivisor;
		this.denominator = denominator / greatestCommonDivisor;
		if( this.denominator < 0 )
		{
			if( this.numerator < 0 )
			{
				this.numerator = Math.abs( this.numerator );
				this.denominator = Math.abs( this.denominator );
			}
			else
			{
				this.numerator = -this.numerator;
				this.denominator = Math.abs( this.denominator );
			}
		}
		return this;
	}

	public String toString()
	{
		if( this.denominator != 1 )
		{
			return new String( this.numerator + "/" + this.denominator );
		}
		else
		{
			return new String( "" + this.numerator );
		}
	}
	
}