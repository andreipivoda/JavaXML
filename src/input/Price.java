package input;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Price
{
	@XmlAttribute(name="currency")
    private String currency;
	@XmlValue
    private String price;
	@Override
	public String toString() {
		return "Price [currency=" + currency + ", price=" + price + "]";
	}
	
	
	

}
