package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassAvailabilityDetails;
import taekwondo.models.ClassDetails;
import taekwondo.services.CommonService;

public class ViewClassScheduleAction extends ActionSupport {
	
	List<ClassAvailabilityDetails> list;
	int tempClassID;
	String classDescription;
	
	
	
	
	public String getClassDescription() {
		return classDescription;
	}
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	
	public int getTempClassID() {
		return tempClassID;
	}
	public void setTempClassID(int tempClassID) {
		this.tempClassID = tempClassID;
	}
	public List<ClassAvailabilityDetails> getList() {
		return list;
	}
	public void setList(List<ClassAvailabilityDetails> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		list = service.getClassAvailabilityDetails(tempClassID);
		if(list!=null)
		{
			ClassDetails obj = service.getClassDetails(tempClassID);
			if(obj!=null)
			classDescription=obj.getClassDescription();
			
			return SUCCESS;
		}
		else
			return INPUT;
	}
}
