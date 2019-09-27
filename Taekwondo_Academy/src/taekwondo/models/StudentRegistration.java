package taekwondo.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_REGISTRATION")
public class StudentRegistration  implements Serializable{

	@Id 
	@Column(name="Student_ID")
	private int studentID;
	
	@Id 
	@Column(name="Joining_Date")
	private Date joiningDate;
	
	@Column(name="Exit_Date")
	private Date exitDate;

	public int getStudentID() {
		return studentID;
	}

	
	public void setJoiningDateInDateFormat(Date joiningDate){
		this.joiningDate = joiningDate;
	}
	
	public void setExitDateInDateFormat(Date exitDate){
		this.exitDate = exitDate;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getJoiningDate() {
		return joiningDate.toString();
	}

	public void setJoiningDate(String joiningDate) throws ParseException {
		this.joiningDate = new SimpleDateFormat("yyyy-MM-dd").parse(joiningDate);
	}

	public String getExitDate() {
		return exitDate.toString();
	}

	public void setExitDate(String exitDate) throws ParseException {
		this.exitDate = new SimpleDateFormat("yyyy-MM-dd").parse(exitDate);
	}

	@Override
	public String toString() {
		return "StudentRegistration [studentID=" + studentID + ", joiningDate=" + joiningDate + ", exitDate=" + exitDate
				+ "]";
	}
	
	
}
