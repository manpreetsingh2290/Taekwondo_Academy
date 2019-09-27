package taekwondo.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.StudentAttendance;
import taekwondo.models.StudentDetails;
import taekwondo.services.CommonService;

public class ViewClassAttendanceAction extends ActionSupport {

	
	int classID;
	String attendanceDate;
	
	String trimmedAttendanceDate;
	
	
			
	public String getTrimmedAttendanceDate() {
		return trimmedAttendanceDate;
	}
	public void setTrimmedAttendanceDate(String trimmedAttendanceDate) {
		this.trimmedAttendanceDate = trimmedAttendanceDate;
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	
	List<StudentAttendance> list;
	
	public List<StudentAttendance> getList() {
        return list;
    }
    public void setList(List<StudentAttendance> list) {
        this.list = list;
    }
	
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		Date tempDate=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(attendanceDate == null || "".equalsIgnoreCase(attendanceDate))
		{
			Date currentDate= new Date();			
			attendanceDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
		}
		
		if(attendanceDate!=null)
		{
			tempDate=new SimpleDateFormat("yyyy-MM-dd").parse(attendanceDate);
			attendanceDate= format.format(tempDate);
		}
		
		list= service.getStudentAttendanceList(classID,tempDate);
		trimmedAttendanceDate=attendanceDate.substring(0,10);
		
		if(list!=null)
		{
			for (StudentAttendance studentAttendance : list)
			{
				StudentDetails student=service.getStudentDetails(studentAttendance.getStudentID());
				studentAttendance.setStudentFirstName(student.getFirstName());
				studentAttendance.setStudentLastName(student.getLastName());
			}
			
			return SUCCESS;
		}
			
		else
			return INPUT;
	}
	
	
}
