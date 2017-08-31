package output;

import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"description","gtin","price","orderid"})
public class Product
{
   

    private String description;

    private String gtin;

    private String orderid;
    private input.Price price;


    public input.Price getPrice ()
    {
        return price;
    }

    public void setPrice (input.Price price)
    {
        this.price = price;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getGtin ()
    {
        return gtin;
    }

    public void setGtin (String gtin)
    {
        this.gtin = gtin;
    }

    public String getOrderid ()
    {
        return orderid;
    }

    public void setOrderid (String orderid)
    {
        this.orderid = orderid;
    }

	@Override
	public String toString() {
		return "\nProduct [price=" + price + ", description=" + description + ", gtin=" + gtin + ", orderid=" + orderid
				+ "]";
	}



  
}
