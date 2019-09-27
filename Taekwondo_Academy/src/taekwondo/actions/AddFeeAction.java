package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.BeltRank;
import taekwondo.models.ProductDetails;
import taekwondo.models.StudentFee;
import taekwondo.services.CommonService;

public class AddFeeAction extends ActionSupport implements ModelDriven<StudentFee>{

	StudentFee obj = new StudentFee();
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		if(service.addFee(obj))
			return SUCCESS;
		else
			return INPUT;
	}
	@Override
	public StudentFee getModel() {
		return obj;
	}

}

