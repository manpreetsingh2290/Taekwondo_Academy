package taekwondo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_PARENT")
public class StudentParentDetails implements Serializable{

	@Id
	@Column(name="Parent_ID")
	private int parentID;
	
	@Id
	@Column(name="Student_ID")
	private int studentID;
	
	@Column(name="Relation")
	private String relation;

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "StudentParent [parentID=" + parentID + ", studentID=" + studentID + ", relation=" + relation + "]";
	}
	
	
}
