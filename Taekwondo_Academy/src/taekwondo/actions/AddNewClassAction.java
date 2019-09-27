package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ClassDetails;
import taekwondo.models.StudentDetails;
import taekwondo.services.CommonService;
import taekwondo.services.StudentInfoService;

public class AddNewClassAction extends ActionSupport implements ModelDriven<ClassDetails>{

	ClassDetails obj = new ClassDetails();
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		if(service.addClass(obj))
			return SUCCESS;
		else
			return INPUT;
	}
	@Override
	public ClassDetails getModel() {
		return obj;
	}

}
