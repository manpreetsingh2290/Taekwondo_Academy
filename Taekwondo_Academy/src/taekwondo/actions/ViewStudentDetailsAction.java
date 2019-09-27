package taekwondo.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.ClassTakenDetails;
import taekwondo.models.ParentDetails;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentParentDetails;
import taekwondo.models.StudentRegistration;
import taekwondo.services.CommonService;
import taekwondo.services.StudentInfoService;

public class ViewStudentDetailsAction extends ActionSupport {

	
	private int studentID;
	
	StudentDetails student= new StudentDetails();
	List<ParentDetails> parentsList = new ArrayList<ParentDetails>();
	ClassTakenDetails classTaken = new ClassTakenDetails();
	ClassDetails classDetails = new ClassDetails();
	
	String trimmedDOB;
	String trimmedDOJ;
	
	public String getTrimmedDOJ() {
		return trimmedDOJ;
	}
	public void setTrimmedDOJ(String trimmedDOJ) {
		this.trimmedDOJ = trimmedDOJ;
	}
	public String getTrimmedDOB() {
		return trimmedDOB;
	}
	public void setTrimmedDOB(String trimmedDOB) {
		this.trimmedDOB = trimmedDOB;
	}
	public ClassDetails getClassDetails() {
		return classDetails;
	}
	public void setClassDetails(ClassDetails classDetails) {
		this.classDetails = classDetails;
	}
	public ClassTakenDetails getClassTaken() {
		return classTaken;
	}
	public void setClassTaken(ClassTakenDetails classTaken) {
		this.classTaken = classTaken;
	}
	public List<ParentDetails> getParentsList() {
		return parentsList;
	}
	public void setParentsList(List<ParentDetails> parentsList) {
		this.parentsList = parentsList;
	}
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
		CommonService commonService = new CommonService();
		
		student= service.getStudentDetails(studentID);
		
		if(student!=null)
		{
			if(student.getDateOfBirth()!=null)
			{
				String trimmedDate=student.getDateOfBirth();
				trimmedDOB=trimmedDate.substring(0, 10);
				
			}
			if(student.getDateOfJoining()!=null)
			{
				String trimmedDate=student.getDateOfJoining();
				trimmedDOJ=trimmedDate.substring(0, 10);
				
			}
			
			classTaken=commonService.getClassForStudent(studentID);
			System.out.println(classTaken);
			if(classTaken!=null && classTaken.getClassID()>0)
			{
				classDetails=commonService.getClassDetails(classTaken.getClassID());				
			}
			System.out.println(classDetails);
			
			parentsList=service.getParentList(studentID);
			if(parentsList==null)
			{
				parentsList= new ArrayList<ParentDetails>();
			}
			StudentParentDetails spObj=null;
			for(ParentDetails parent: parentsList)
			{
				spObj= commonService.getStudentParentDetails(parent.getParentID());
				
				if(spObj!=null)
				{
					parent.setRelation(spObj.getRelation());
				}
				
				if(parent.getDateOfBirth()!=null)
				{
					String trimmedDate=parent.getDateOfBirth();
					parent.setTrimmedParentDOB(trimmedDate.substring(0, 10));
					
				}
			}
			
			StudentRegistration reg=commonService.getStudentRegistrationDetails(studentID);
			
			if(reg!=null && reg.getJoiningDate()!=null)
			student.setDateOfJoining(reg.getJoiningDate());
			
			if(reg!=null && reg.getJoiningDate()!=null)
			trimmedDOJ=reg.getJoiningDate().substring(0,10);
			
			System.out.println("Inside: StudentDetailsViewAction");
			System.out.println(student);
			//if(student!=null)
				return SUCCESS;
		}
		else
			return INPUT;
	}
	
	
}
