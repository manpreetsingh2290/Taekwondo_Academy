package taekwondo.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ParentDetails;
import taekwondo.models.StudentDetails;
import taekwondo.services.StudentInfoService;

public class StudentDetailsViewAction extends ActionSupport {

	
	private int studentID;
	
	StudentDetails student= new StudentDetails();
	List<ParentDetails> parentsList = new ArrayList<ParentDetails>();
		
	
	public StudentDetails getStudent() {
		return student;
	}
	public void setStudent(StudentDetails student) {
		this.student = student;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		
		StudentInfoService service = new StudentInfoService();
		student= service.getStudentDetails(studentID);
		parentsList=service.getParentList(studentID);
		if(parentsList==null)
		{
			parentsList= new ArrayList<ParentDetails>();
		}
		System.out.println("Inside: StudentDetailsViewAction");
		System.out.println(student);
		if(student!=null)
			return SUCCESS;
		else
			return INPUT;
	}
	
	
}
