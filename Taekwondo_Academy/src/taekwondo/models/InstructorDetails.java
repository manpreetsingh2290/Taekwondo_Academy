package taekwondo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INSTRUCTOR_DETAILS")
@SequenceGenerator(name= "INSTRUCTOR_ID_SEQ", sequenceName = "INSTRUCTOR_ID_SEQ", initialValue=1, allocationSize = 1)
public class InstructorDetails  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTOR_ID_SEQ")
	@Column(name="Instructor_ID")
	private int   instructorID;
	
	@Column (name="Instructor_FirstName")
	private String firstName;
	
	@Column (name="Instructor_LastName")
	private String lastName;
	
	/*@Column (name="Instructor_UserID")
	private String userID ;
	
	@Column (name="Instructor_Password")
	private String password;
	
	@Column (name="User_Role")
	private String userRole;*/
	
	
	public int getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}*/
	
	
}
