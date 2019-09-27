package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentFee;
import taekwondo.services.CommonService;

public class ViewAllFeeAction extends ActionSupport {
	
	List<StudentFee> list;
	
	
	public List<StudentFee> getList() {
		return list;
	}
	public void setList(List<StudentFee> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		list = service.getAllFeeList();
		for (StudentFee s : list) {
			
			StudentDetails sd = service.getStudentDetails(s.getStudentID());
			s.setStudentName(sd.getFirstName()+" "+sd.getLastName());
			ClassDetails cd = service.getClass(s.getClassID());
			s.setClassName(cd.getClassDescription());
		}
		if(list!=null)
			return SUCCESS;
		else
			return INPUT;
	}
}
