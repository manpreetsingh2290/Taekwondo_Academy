package taekwondo.actions;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.InstructorDetails;
import taekwondo.models.ParentDetails;
import taekwondo.models.StudentDetails;
import taekwondo.services.CommonService;
import taekwondo.services.StudentInfoService;

public class ViewClassesForAttendanceAction extends ActionSupport {

		
	List<ClassDetails> list;
		
	
	
	public List<ClassDetails> getList() {
		return list;
	}
	public void setList(List<ClassDetails> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		list = service.getAllClassList();
		InstructorDetails instructor=null;
		for(ClassDetails classDetail:list)
		{
			instructor=service.getInstructorDetails(classDetail.getInstructorID());
			if(instructor!=null)
			{
				classDetail.setInstructorName(instructor.getFirstName()+" "+instructor.getLastName());
			}
			
		}
		
		if(list!=null)
			return SUCCESS;
		else
			return INPUT;
	}
	
	
}
