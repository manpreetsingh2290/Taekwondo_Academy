package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ParentDetails;
import taekwondo.services.StudentInfoService;

public class ParentAddAction_ignore extends ActionSupport implements ModelDriven<ParentDetails>{

	ParentDetails parent = new ParentDetails();
	private String studentID;
		
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		StudentInfoService service = new StudentInfoService();
		//if(service.addParent(parent))
			return SUCCESS;
		//else
			//return INPUT;
	}
	@Override
	public ParentDetails getModel() {
		return parent;
	}

}
