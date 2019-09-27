package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ProductDetails;
import taekwondo.models.ProductOrder;
import taekwondo.models.ProductOrderDetails;
import taekwondo.models.StudentDetails;
import taekwondo.services.CommonService;

public class AddOrderSetupAction extends ActionSupport{// implements ModelDriven<ProductOrderDetails>{

	//ProductOrderDetails obj = new ProductOrderDetails();
	List<StudentDetails> allStudentsList= null;
			
	public List<StudentDetails> getAllStudentsList() {
		return allStudentsList;
	}
	public void setAllStudentsList(List<StudentDetails> allStudentsList) {
		this.allStudentsList = allStudentsList;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		
		allStudentsList=service.getAllStudentList();
	
		boolean flag=true;
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
