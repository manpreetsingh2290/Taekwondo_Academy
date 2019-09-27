package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ProductDetails;
import taekwondo.models.ProductOrder;
import taekwondo.models.ProductOrderDetails;
import taekwondo.services.CommonService;

public class AddFinalProductInOrderAction extends ActionSupport{// implements ModelDriven<ProductOrderDetails>{

	//ProductOrderDetails obj = new ProductOrderDetails();
	List<ProductDetails> allProductsList= null;
	
	List<ProductOrderDetails> purchaseProductsList= null;
	ProductOrder orderDetails=null;
	
	int tempOrderID;
	int selectedProductID;	
	int selectedProductQuantity;
	double totalInvoiceAmount;
		
		
	public ProductOrder getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(ProductOrder orderDetails) {
		this.orderDetails = orderDetails;
	}
	public double getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}
	public void setTotalInvoiceAmount(double totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}
	public List<ProductDetails> getAllProductsList() {
		return allProductsList;
	}
	public void setAllProductsList(List<ProductDetails> allProductsList) {
		this.allProductsList = allProductsList;
	}
	public int getTempOrderID() {
		return tempOrderID;
	}
	public void setTempOrderID(int tempOrderID) {
		this.tempOrderID = tempOrderID;
	}
	public int getSelectedProductID() {
		return selectedProductID;
	}
	public void setSelectedProductID(int selectedProductID) {
		this.selectedProductID = selectedProductID;
	}
	public int getSelectedProductQuantity() {
		return selectedProductQuantity;
	}
	public void setSelectedProductQuantity(int selectedProductQuantity) {
		this.selectedProductQuantity = selectedProductQuantity;
	}
	
	public List<ProductOrderDetails> getPurchaseProductsList() {
		return purchaseProductsList;
	}
	public void setPurchaseProductsList(List<ProductOrderDetails> purchaseProductsList) {
		this.purchaseProductsList = purchaseProductsList;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		
		allProductsList=service.getAllProducts();
	
		boolean flag=false;
		if(selectedProductID > 0 && selectedProductQuantity>0)
		{
			ProductOrderDetails obj= new ProductOrderDetails();
			ProductDetails selectedProduct=service.getProductDetails(selectedProductID);
						
			obj.setProductID(selectedProduct.getProductID());
			obj.setTotalAmount(selectedProduct.getSellingPrice()*selectedProductQuantity);
			obj.setUnitPrice(selectedProduct.getSellingPrice());
			obj.setOrderID(tempOrderID);
			obj.setProductQuantity(selectedProductQuantity);
			
			flag=service.addProductOrderDetails(obj);
			
			purchaseProductsList = service.getAllProductsOfOrder(tempOrderID);
			
			ProductDetails pDetails=null;
			for(ProductOrderDetails tempObj:purchaseProductsList)
			{
				pDetails= service.getProductDetails(tempObj.getProductID());
				tempObj.setProductName(pDetails.getProductName());
			}
			System.out.println("Final List:"+purchaseProductsList);
			
			//purchaseProductsList = service.getAllProductsOfOrder(tempOrderID);	
			totalInvoiceAmount=0;
			for(ProductOrderDetails productLine: purchaseProductsList)
			{
				totalInvoiceAmount += productLine.getTotalAmount();
			}
			
			orderDetails=service.getOrderDetails(tempOrderID);
		}
		else
		{
			purchaseProductsList = service.getAllProductsOfOrder(tempOrderID);	
			totalInvoiceAmount=0;
			for(ProductOrderDetails productLine: purchaseProductsList)
			{
				totalInvoiceAmount += productLine.getTotalAmount();
			}
			orderDetails=service.getOrderDetails(tempOrderID);
			
			ProductDetails pDetails=null;
			for(ProductOrderDetails tempObj:purchaseProductsList)
			{
				pDetails= service.getProductDetails(tempObj.getProductID());
				tempObj.setProductName(pDetails.getProductName());
			}
			System.out.println(purchaseProductsList);
			flag=true;
		}
		
		
		//tempOrderID=obj.getOrderID();
		if(flag)
			return SUCCESS;
		else
			return INPUT;
	}
	/*@Override
	public ProductOrderDetails getModel() {
		return obj;
	}*/

}
