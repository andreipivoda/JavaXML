package output;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products
{
    private List<Product> product;
   
    public List<Product> getProduct ()
    {
        return product;
    }

    public void setProduct (List<Product> product)
    {
        this.product = product;
    }

	@Override
	public String toString() {
		return "Products [product=" + product + "]" + "\nfilename = ";
	}

	
 
}