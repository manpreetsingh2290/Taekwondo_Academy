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
@Table(name = "CLASS_TAKEN")
public class ClassTakenDetails implements Serializable {

	@Id 
	@Column(name="Class_ID")
	private int classID;
	
	@Id 
	@Column(name="Student_ID")
	private int studentID;
	
	@Column(name="Begin_Date")
	private Date beginDate;
	
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
	public String getBeginDate() {
		//return beginDate.toString();
		return beginDate!=null?beginDate.toString():null;
	}
	public void setBeginDate(String beginDate) throws ParseException {
		this.beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(beginDate);
	}
	
	public void setBeginDateInDateFormat(Date beginDate) throws ParseException {
		this.beginDate = beginDate;
	}
	
	@Override
	public String toString() {
		return "ClassTakenDetails [classID=" + classID + ", studentID=" + studentID + ", beginDate=" + beginDate + "]";
	}
	
	
	
}
