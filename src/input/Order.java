package input;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
public class Order
{
	private Product[] product;
	@XmlAttribute(name="created")
    private String created;
	@XmlAttribute(name="ID")
    public String ID;

    public Product[] getProduct ()
    {
        return product;
    }

    public void setProduct (Product[] product)
    {
        this.product = product;
    }

	@Override
	public String toString() {
		return "Order [product=" + Arrays.toString(product) + ", created=" + created + ", ID=" + ID + "]";
	}

  


}