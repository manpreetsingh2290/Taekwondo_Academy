package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.StudentDetails;
import taekwondo.services.StudentInfoService;

public class ViewClassStudentsForAttendanceAction extends ActionSupport {

	
	int classID;
		
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	
	List<StudentDetails> list;
	
	public List<StudentDetails> getList() {
        return list;
    }
    public void setList(List<StudentDetails> list) {
        this.list = list;
    }
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		StudentInfoService service = new StudentInfoService();
		list= service.getStudentListForAttendance(classID);
		if(list!=null)
			return SUCCESS;
		else
			return INPUT;
	}
	
	
}
