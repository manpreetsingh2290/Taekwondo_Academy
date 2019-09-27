package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ClassDetails;
import taekwondo.models.ProductOrder;
import taekwondo.services.CommonService;

public class AddNewOrderAction extends ActionSupport implements ModelDriven<ProductOrder>{

	ProductOrder obj = new ProductOrder();
    int tempOrderID;
	
	public int getTempOrderID() {
		return tempOrderID;
	}
	public void setTempOrderID(int tempOrderID) {
		this.tempOrderID = tempOrderID;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		tempOrderID=service.addProductOrder(obj);
		if(tempOrderID > 0 )
			return SUCCESS;
		else
			return INPUT;
	}
	@Override
	public ProductOrder getModel() {
		return obj;
	}

}
