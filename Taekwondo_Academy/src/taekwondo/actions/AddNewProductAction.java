package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ProductDetails;
import taekwondo.services.CommonService;

public class AddNewProductAction extends ActionSupport implements ModelDriven<ProductDetails>{

	ProductDetails obj = new ProductDetails();
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		if(service.addProduct(obj))
			return SUCCESS;
		else
			return INPUT;
	}
	@Override
	public ProductDetails getModel() {
		return obj;
	}

}
