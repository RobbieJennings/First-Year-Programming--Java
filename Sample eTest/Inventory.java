import java.util.ArrayList;

public class Inventory
{
	public final ArrayList< Item > itemsCollection = new ArrayList< Item >();
	public final ArrayList< Order > ordersCollection = new ArrayList< Order >();
	
	public void addItem( String itemName, double itemPrice, int itemQuantity )
	{
		boolean itemAlreadyExists = false;
		for( int index = 0; index < itemsCollection.size(); index++ )
		{
			Item thisItem = itemsCollection.get( index );
			if( thisItem.getName() == itemName
					&& thisItem.getPrice() == itemPrice )
			{
				itemAlreadyExists = true;
				thisItem.setQuantity( thisItem.getQuantity() + itemQuantity );
				createOrder( thisItem );
			}
		}
		if( !itemAlreadyExists )
		{
			Item thisItem = new Item( itemsCollection.size() + 1, itemName, itemPrice, itemQuantity );
			itemsCollection.add( thisItem );
			createOrder( thisItem );
		}
	}
	
	public void createOrder( Item item )
	{
		Order thisOrder = new Order( item );
		thisOrder.setOrderID( ordersCollection.size() + 1 );
		ordersCollection.add( thisOrder );
	}
}