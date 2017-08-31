package input;

public class Product
{

//	@XmlElement(name="description")
	private String description;
//	@XmlElement(name="gtin")
	private String gtin;
//	@XmlElement(name="supplier")
	 String supplier;

	private Price price;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Price getPrice ()
	{
		return price;
	}

	public void setPrice (Price price)
	{
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [description=" + description + ", gtin=" + gtin + ", supplier=" + supplier + ", price=" + price
				+ "]";
	}


}