package onion.open.spring.service.vo;

public class ProductInfoResponse extends BaseVO
{
	private static final long serialVersionUID = 5838704234266398292L;
	private String productName;
	private String productdesc;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
}
