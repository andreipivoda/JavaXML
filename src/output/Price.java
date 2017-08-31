package output;

public class Price
{
    private String content;

    private String currency;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

	public Price(Price price) {
		super();
		this.content = price.content;
		this.currency = price.currency;
	}

	@Override
	public String toString() {
		return "Price [content=" + content + ", currency=" + currency + "]";
	}

   
}