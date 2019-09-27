package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.StudentDetails;
import taekwondo.services.StudentInfoService;

public class AddStudentsInClassFormSetupAction extends ActionSupport{// implements ModelDriven<ClassDetails>{

	int classID;
	
	List<StudentDetails> list;
	
	public List<StudentDetails> getList() {
        return list;
    }
    public void setList(List<StudentDetails> list) {
        this.list = list;
    }
		
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
			StudentInfoService service = new StudentInfoService();
			list= service.getAllStudentList();
			if(list!=null)
				return SUCCESS;
			else
				return INPUT;
		}	  
		else
			 return INPUT;

	}
	

}
