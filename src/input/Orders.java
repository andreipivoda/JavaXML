package input;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orders")
public class Orders
{
	private Order[] order;

	public Order[] getOrder ()
	{
		return order;
	}

	public void setOrder (Order[] order)
	{
		this.order = order;
	}

	public int getOrderSize() {
		return this.order.length;
	}
	@Override
	public String toString() {
		return "Orders [order=" + Arrays.toString(order) + "]";
	}


}