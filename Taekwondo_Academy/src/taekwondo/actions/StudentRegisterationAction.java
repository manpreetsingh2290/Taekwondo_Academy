package taekwondo.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import taekwondo.models.ClassTakenDetails;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentRegistration;
import taekwondo.services.CommonService;
import taekwondo.services.StudentInfoService;

public class StudentRegisterationAction extends ActionSupport implements ModelDriven<StudentDetails>{

	StudentDetails student = new StudentDetails();
	int tempStudentID;
	int selectedClassID;
	
	
	public int getSelectedClassID() {
		return selectedClassID;
	}
	public void setSelectedClassID(int selectedClassID) {
		this.selectedClassID = selectedClassID;
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
		System.out.println(student);
		if(selectedClassID>0)
		{
			tempStudentID=service.addStudent(student);
			if(tempStudentID>0)
			{
				ClassTakenDetails obj= new ClassTakenDetails();
				obj.setClassID(selectedClassID);
				obj.setStudentID(tempStudentID);
				if(student.getDateOfJoiningInDate()!=null)
				{
					obj.setBeginDateInDateFormat(student.getDateOfJoiningInDate());
				}
				
				commonService.addClassTakenDetails(obj);
				
				StudentRegistration reg= new StudentRegistration();
				reg.setStudentID(tempStudentID);
				reg.setJoiningDateInDateFormat(student.getDateOfJoiningInDate());
				
				commonService.addStudentRegistration(reg);
				
				
				return SUCCESS;
			}
			return INPUT;
		}	
			
		else
			return INPUT;
	}
	@Override
	public StudentDetails getModel() {
		return student;
	}

}
