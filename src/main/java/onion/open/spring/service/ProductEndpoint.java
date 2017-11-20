package onion.open.spring.service;

import onion.open.spring.service.vo.ProductInfoRequest;
import onion.open.spring.service.vo.ProductInfoResponse;

public interface ProductEndpoint 
{
	public ProductInfoResponse getProductInformation(ProductInfoRequest productInfoReq);
}
