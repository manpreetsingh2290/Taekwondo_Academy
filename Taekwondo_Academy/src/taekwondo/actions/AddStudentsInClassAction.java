package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ClassTakenDetails;
import taekwondo.services.CommonService;

public class AddStudentsInClassAction extends ActionSupport implements ModelDriven<ClassTakenDetails>{

	ClassTakenDetails obj = new ClassTakenDetails();

	int selectedStudentID;
	
	public int getSelectedStudentID() {
		return selectedStudentID;
	}
	public void setSelectedStudentID(int selectedStudentID) {
		this.selectedStudentID = selectedStudentID;
	}
	/*int classID;
	
	
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}*/
	int tempClassID;
	
	
	public int getTempClassID() {
		return tempClassID;
	}
	public void setTempClassID(int tempClassID) {
		this.tempClassID = tempClassID;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		obj.setClassID(tempClassID);
		obj.setStudentID(selectedStudentID);
		if(service.addClassTakenDetails(obj))
			return SUCCESS;
		else
			return INPUT;
	}
	@Override
	public ClassTakenDetails getModel() {
		return obj;
	}

}

