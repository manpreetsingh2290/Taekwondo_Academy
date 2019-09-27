package taekwondo.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import taekwondo.models.StudentAttendance;
import taekwondo.services.CommonService;

public class MarkAttendanceAction extends ActionSupport{

	String attendanceDate;
	String studentIDs[];
	//boolean attendanceStatus[];
	int classID;
	

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	private Map<Integer, Boolean> checkboxes;
	  public Map<Integer, Boolean> getCheckboxes() {
	    return checkboxes;
	  }

	  public void setCheckboxes(Map<Integer, Boolean> checkboxes) {
	    this.checkboxes = checkboxes;
	  }
	
	public String[] getStudentIDs() {
		return studentIDs;
	}

	public void setStudentIDs(String[] studentIDs) {
		this.studentIDs = studentIDs;
	}

	/*public boolean[] getAttendanceStatus() {
		return attendanceStatus;
	}
	public void setAttendanceStatus(boolean[] attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}*/
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	@Override
	public void validate() {
		//addFieldError("hh", "Must not be empty");
	}
	@Override
	public String execute() throws Exception {
		
		CommonService service = new CommonService();
		StudentAttendance obj= null;
		if(attendanceDate == null || "".equalsIgnoreCase(attendanceDate))
		{
			Date currentDate= new Date();			
			attendanceDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
		}
			for(int i=0;i<studentIDs.length;i++)
			{
				System.out.println("Markig Attendance for Student:"+studentIDs[i]+"("+checkboxes.get(i)+")");
				obj= new StudentAttendance();
				obj.setClassID(classID);
				obj.setClassDate(attendanceDate);
				obj.setStudentID(Integer.parseInt(studentIDs[i]));
				if(checkboxes.get(i))
				{
					obj.setStatus("P");
				}
				else
				{
					obj.setStatus("A");
				}
				System.out.println(obj);
				service.addStudentAttendance(obj);
			}
				
		   return SUCCESS;
		/*}
		return INPUT;*/
	}
	
}


