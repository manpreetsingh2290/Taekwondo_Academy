package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.ProductDetails;
import taekwondo.services.CommonService;

public class ViewAllProductsAction extends ActionSupport {

		
	List<ProductDetails> list;
		
	public List<ProductDetails> getList() {
		return list;
	}
	public void setList(List<ProductDetails> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		list = service.getAllProductList();
		
		if(list!=null)
			return SUCCESS;
		else
			return INPUT;
	}
	
	
}
