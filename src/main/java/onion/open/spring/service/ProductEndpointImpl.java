package onion.open.spring.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import onion.open.spring.service.vo.ProductInfoRequest;
import onion.open.spring.service.vo.ProductInfoResponse;

@Path("/product")
public class ProductEndpointImpl implements ProductEndpoint
{
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/info")
	public ProductInfoResponse getProductInformation(ProductInfoRequest productInfoReq)
	{
		ProductInfoResponse response = new ProductInfoResponse();
		response.setProductName("test");
		response.setProductdesc("test ah test");
		System.out.println("111");
		
		return response;
	}
}
