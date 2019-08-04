package onion.basic.thread.threadlocal;

public class Customer 
{
	private String customerName;
	private String status;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", status=" + status + "]";
	}	
}