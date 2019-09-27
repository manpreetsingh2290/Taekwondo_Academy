package taekwondo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CLASS_DETAILS")
@SequenceGenerator(name= "CLASS_ID_SEQ", sequenceName = "CLASS_ID_SEQ", initialValue=1, allocationSize = 1)
public class ClassDetails  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASS_ID_SEQ")
	@Column(name="Class_ID")
	private int classID;
	
	@Column(name="Class_Description")
	private String classDescription;
	
	@Column(name="Class_Fee")
	private int classFee;
		
	@Column(name="Instructor_ID")
	private int instructorID;
	
	@Transient
	private String instructorName;
	
	
	

	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public String getClassDescription() {
		return classDescription;
	}
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	public int getClassFee() {
		return classFee;
	}
	public void setClassFee(int classFee) {
		this.classFee = classFee;
	}
	public int getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}
	@Override
	public String toString() {
		return "ClassDetails [classID=" + classID + ", classDescription=" + classDescription + ", classFee=" + classFee
				+ ", instructorID=" + instructorID + ", instructorName=" + instructorName + "]";
	}
	
	
	
}
