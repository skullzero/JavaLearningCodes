package onion.open.spring.service.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductInfoRequest extends BaseVO 
{
	private static final long serialVersionUID = -434693765052740481L;
	private String productId;
	private String productType;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
}
