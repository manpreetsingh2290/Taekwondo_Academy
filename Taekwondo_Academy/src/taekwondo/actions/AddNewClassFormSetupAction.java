package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.InstructorDetails;
import taekwondo.services.CommonService;

public class AddNewClassFormSetupAction extends ActionSupport  {

	
	List<InstructorDetails> allInstructorList= null;
	
	
	
	public List<InstructorDetails> getAllInstructorList() {
		return allInstructorList;
	}

	public void setAllInstructorList(List<InstructorDetails> allInstructorList) {
		this.allInstructorList = allInstructorList;
	}

	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	
	@Override
	public String execute(){
		
		CommonService service = new CommonService();
		allInstructorList =service.getAllInstructorDetails();
		if(allInstructorList!=null)
		return SUCCESS;
		
		return INPUT;
	}
}
