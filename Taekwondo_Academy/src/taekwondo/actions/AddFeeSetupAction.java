package taekwondo.actions;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.ClassDetails;
import taekwondo.models.ClassTakenDetails;
import taekwondo.models.StudentDetails;
import taekwondo.services.CommonService;

public class AddFeeSetupAction extends ActionSupport  {
	
	int	studentID;
	int classID;
	int classFee;
	String className;
	String studentName;
	
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	
	
	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getClassFee() {
		return classFee;
	}

	public void setClassFee(int classFee) {
		this.classFee = classFee;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	@Override
	public String execute(){
		
		CommonService cs = new CommonService();
		
		StudentDetails sd = cs.getStudentDetails(studentID);
		if(sd != null) {
			
			studentName=sd.getFirstName()+" "+sd.getLastName();
			
			ClassTakenDetails ct = cs.getClassForStudent(studentID);
			if(ct != null) {
			ClassDetails cd = cs.getClass(ct.getClassID());
			
				if(cd != null) {
					classFee =  cd.getClassFee();
					classID = cd.getClassID();
					className = cd.getClassDescription();
					return SUCCESS;
				}
				else {
					return INPUT;
				}
				
			}
			else {
				return INPUT;
			}
		
	}
		else {
			return INPUT;
		}
	}
}
