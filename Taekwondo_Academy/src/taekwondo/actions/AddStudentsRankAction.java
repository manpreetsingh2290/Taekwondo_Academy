package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ClassAvailabilityDetails;
import taekwondo.models.ClassTakenDetails;
import taekwondo.models.StudentRank;
import taekwondo.services.CommonService;

public class AddStudentsRankAction extends ActionSupport implements ModelDriven<StudentRank>{

	StudentRank obj = new StudentRank();

	int selectedBeltRank;
	
	public int getSelectedBeltRank() {
		return selectedBeltRank;
	}
	public void setSelectedBeltRank(int selectedBeltRank) {
		this.selectedBeltRank = selectedBeltRank;
	}
	
	int tempStudentID;
		
	public int getTempStudentID() {
		return tempStudentID;
	}
	public void setTempStudentID(int tempStudentID) {
		this.tempStudentID = tempStudentID;
	}
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {		
		if(selectedBeltRank>0)
		{
			CommonService service = new CommonService();
			obj.setStudentID(tempStudentID);
			obj.setRankID(selectedBeltRank);
			if(service.addStudentRank(obj))
				return SUCCESS;
		}
		return INPUT;
	}
	@Override
	public StudentRank getModel() {
		return obj;
	}

}

