package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ViewClassAttendanceFormSetupAction extends ActionSupport {

	
	int classID;
		
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		if(classID>0)
		{
			return SUCCESS;
		}
		
		return INPUT;
	}
	
	
}
