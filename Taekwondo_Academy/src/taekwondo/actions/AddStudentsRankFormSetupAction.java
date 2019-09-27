package taekwondo.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.BeltRank;
import taekwondo.services.CommonService;

public class AddStudentsRankFormSetupAction extends ActionSupport{// implements ModelDriven<ClassDetails>{

	int studentID;
	
	List<BeltRank> list;
		
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public List<BeltRank> getList() {
		return list;
	}
	public void setList(List<BeltRank> list) {
		this.list = list;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		if(studentID>0)
		{
			CommonService service = new CommonService();
			list= service.getAllBeltRankList();
			if(list!=null)
				return SUCCESS;
			else
				return INPUT;
		}	  
		else
			 return INPUT;

	}
	

}
