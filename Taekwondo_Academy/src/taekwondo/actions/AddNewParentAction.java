package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ClassTakenDetails;
import taekwondo.models.ParentDetails;
import taekwondo.models.StudentParentDetails;
import taekwondo.services.CommonService;
import taekwondo.services.StudentInfoService;

public class AddNewParentAction extends ActionSupport implements ModelDriven<ParentDetails>{

	ParentDetails parent = new ParentDetails();
	int tempStudentID;
	ClassTakenDetails classTaken= new ClassTakenDetails();
	
	
	
	
	public ClassTakenDetails getClassTaken() {
		return classTaken;
	}
	public void setClassTaken(ClassTakenDetails classTaken) {
		this.classTaken = classTaken;
	}
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
		
		StudentInfoService service = new StudentInfoService();
		CommonService commonService = new CommonService();		
		System.out.println(parent);
		int parentID=service.addParent(parent);
		
		if(parentID>0)
		{
			StudentParentDetails obj= new StudentParentDetails();
			obj.setStudentID(tempStudentID);
			obj.setParentID(parentID);
			obj.setRelation(parent.getRelation());			
			service.addStudentParentDetails(obj);
			
			
			classTaken=commonService.getClassForStudent(tempStudentID);
			System.out.println(classTaken);
			if(classTaken ==null)
				classTaken=new ClassTakenDetails();
			
			//studentID = tempStudentID;
			return SUCCESS;
		}
			
		else
			return INPUT;
	}
	@Override
	public ParentDetails getModel() {
		return parent;
	}

}
