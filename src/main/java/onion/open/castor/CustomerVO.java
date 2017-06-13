package onion.open.castor;

import java.util.List;

public class CustomerVO 
{
	private String customerID;
	private String customerName;
	private String birthDate;
	//XML中不应该有addressList节点，而应该都是并列的几个<Address>节点 
	private List<Address> addressList;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
}
