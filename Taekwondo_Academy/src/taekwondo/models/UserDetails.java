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
@Table(name = "USER_DETAILS")
@SequenceGenerator(name= "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", initialValue=1, allocationSize = 1)
public class UserDetails  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ID_SEQ")
	@Column(name="User_ID")
	private int   userID;
	
	@Column (name="User_FirstName")
	private String firstName;
	
	@Column (name="User_LastName")
	private String lastName;
	
	@Column (name="User_UserName")
	private String userName ;
	
	@Column (name="User_Password")
	private String password;
	
	@Column (name="User_Role")
	private String userRole;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	}

	@Override
	public String toString() {
		return "UserDetails [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
}
