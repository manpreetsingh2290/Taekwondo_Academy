package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ProductDetails;
import taekwondo.models.ProductOrder;
import taekwondo.models.ProductOrderDetails;
import taekwondo.services.CommonService;

public class ViewOrderDetailsAction extends ActionSupport {

	List<ProductDetails> allProductsList= null;
	
	List<ProductOrderDetails> purchaseProductsList= null;
	ProductOrder orderDetails=null;
	int orderID;
	double totalInvoiceAmount;
	
	
	public List<ProductDetails> getAllProductsList() {
		return allProductsList;
	}
	public void setAllProductsList(List<ProductDetails> allProductsList) {
		this.allProductsList = allProductsList;
	}
	public List<ProductOrderDetails> getPurchaseProductsList() {
		return purchaseProductsList;
	}
	public void setPurchaseProductsList(List<ProductOrderDetails> purchaseProductsList) {
		this.purchaseProductsList = purchaseProductsList;
	}
	public ProductOrder getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(ProductOrder orderDetails) {
		this.orderDetails = orderDetails;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public double getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}
	public void setTotalInvoiceAmount(double totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		
		allProductsList=service.getAllProducts();
		orderDetails=service.getOrderDetails(orderID);
		purchaseProductsList = service.getAllProductsOfOrder(orderID);	
		for(ProductOrderDetails productLine: purchaseProductsList)
			{
				totalInvoiceAmount += productLine.getTotalAmount();
			}
			
		ProductDetails pDetails=null;
		for(ProductOrderDetails tempObj:purchaseProductsList)
			{
				pDetails= service.getProductDetails(tempObj.getProductID());
				tempObj.setProductName(pDetails.getProductName());
			}
		System.out.println(purchaseProductsList);
		
		if(orderDetails!=null)
			return SUCCESS;
		else
			return INPUT;
	}
	
	
}
