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
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;

@Entity
@Table(name = "PARENT_DETAILS")
@SequenceGenerator(name= "PARENT_ID_SEQ", sequenceName = "PARENT_ID_SEQ", initialValue=1, allocationSize = 1)
public class ParentDetails  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARENT_ID_SEQ")
	@Column(name="PARENT_ID")
	private int parentID;
	
	@Column(name="Parent_FirstName")
	private String firstName;
	
	@Column(name="Parent_LastName")
	private String lastName;
	
	@Column(name="Parent_DOB")
	private Date dateOfBirth;
	
	@Column(name="Email_ID")
	private String emailID;
	
	@Column(name="Phone_No")
	private String phoneNo;
	
	@Column(name="Addrs_HouseNumber")
	private String houseNumber;
	
	@Column(name="Addrs_Street")
	private String street;
	
	@Column(name="Addrs_City")
	private String city;
	
	@Column(name="Addrs_State")
	private String state;
	
	@Column(name="Addrs_PostalCode")
	private String postalCode;
	
	//@Column(name="STATUS")
	//private String status;
	
	@Column(name="Gender")
	private String gender;
	
	@Transient
	private String relation;
	
	@Transient
	String trimmedParentDOB;
	
	public String getTrimmedParentDOB() {
		return trimmedParentDOB;
	}
	public void setTrimmedParentDOB(String trimmedParentDOB) {
		this.trimmedParentDOB = trimmedParentDOB;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
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

	public String getDateOfBirth() {
		//return dateOfBirth.toString();
		return dateOfBirth!=null?dateOfBirth.toString():null;
	}

	public void setDateOfBirth(String dateOfBirth) throws ParseException {
		this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/*public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}*/

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ParentDetails [parentID=" + parentID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailID=" + emailID + ", phoneNo=" + phoneNo + ", houseNumber="
				+ houseNumber + ", street=" + street + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", gender=" + gender + ", relation=" + relation + "]";
	}

	
	
	
	
	
	
}
