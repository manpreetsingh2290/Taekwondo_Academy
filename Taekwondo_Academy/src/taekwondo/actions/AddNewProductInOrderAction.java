package taekwondo.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ProductDetails;
import taekwondo.models.ProductOrderDetails;
import taekwondo.services.CommonService;

public class AddNewProductInOrderAction extends ActionSupport{// implements ModelDriven<ProductOrderDetails>{

	//ProductOrderDetails obj = new ProductOrderDetails();
	List<ProductDetails> allProductsList= null;
	
	List<ProductOrderDetails> purchaseProductsList= null;
	
	
	int tempOrderID;
	int selectedProductID;	
	int selectedProductQuantity;
		
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
			obj.setTotalAmount(selectedProductQuantity * selectedProduct.getSellingPrice());
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
			System.out.println(purchaseProductsList);
			
			List<ProductDetails> tempProductsList=service.getAllProducts();;
			allProductsList=new	ArrayList<ProductDetails>();
					
			for(ProductDetails prod:tempProductsList)
			{
				if(!isProductAlreadyAdded(purchaseProductsList,prod.getProductID()))
				{
					allProductsList.add(prod);
				}
			}
			
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

	public boolean isProductAlreadyAdded(List<ProductOrderDetails> purchaseProductsList, int productID)
	{
		for(ProductOrderDetails tempObj:purchaseProductsList)
		{
			 if(tempObj.getProductID()==productID)
			 {
				 return true;
			 }
		}
		return false;
	}
}
