package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.services.CommonService;

public class StudentRegistrationFormSetupAction extends ActionSupport{// implements ModelDriven<ClassDetails>{

	List<ClassDetails> classList;
	
	public List<ClassDetails> getClassList() {
		return classList;
	}
	public void setClassList(List<ClassDetails> classList) {
		this.classList = classList;
	}
	
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		classList=service.getAllClassList();
			
		if(classList!=null)
			return SUCCESS;
		else
			return INPUT;
		
	}
	

}
