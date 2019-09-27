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
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT_ATTENDANCE")
public class StudentAttendance  implements Serializable{

	@Id 
	@Column(name="Class_ID")
	private int classID;
	
	@Id 
	@Column(name="Student_ID")
	private int studentID;
	
	@Id 
	@Column(name="Class_Date")
	private Date classDate;
	
	@Column(name="STATUS")
	private String status;
	
	@Transient
	private String studentFirstName;
	
	@Transient
	private String studentLastName;
	
	

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getClassDate() {
		//return classDate;
		return classDate.toString();
	}

	public void setClassDate(String classDate) throws ParseException {
		//this.classDate = classDate;
		this.classDate = new SimpleDateFormat("yyyy-MM-dd").parse(classDate);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentAttendance [classID=" + classID + ", studentID=" + studentID + ", classDate=" + classDate
				+ ", status=" + status + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + "]";
	}

	
	
	
}
