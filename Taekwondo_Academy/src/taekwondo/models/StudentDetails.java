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
@Table(name = "STUDENT_DETAILS")
@SequenceGenerator(name= "STUDENT_ID_SEQ", sequenceName = "STUDENT_ID_SEQ", initialValue=1, allocationSize = 1)
public class StudentDetails  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDENT_ID_SEQ")
	@Column(name="Student_ID")
	private int studentID;
	
	@Column(name="Student_FirstName")
	private String firstName;
	
	@Column(name="Student_LastName")
	private String lastName;
	
	@Column(name="Student_DOB")
	
	//@Temporal(TemporalType.DATE)
	//@Temporal(javax.persistence.TemporalType.DATE)
    //@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	private Date dateOfBirth;
	
	@Transient
	private Date dateOfJoining;
	
	
	@Column(name="Email_ID")
	private String emailID;
	
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
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Phone_No")
	private String phoneNo;
	
	@Column(name="Emrgency_Contact_No")
	private String emergencyContact;
	
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
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
		return dateOfBirth!=null?dateOfBirth.toString():null;
	}
	public void setDateOfBirth(String dateOfBirth) throws ParseException {
		this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
	}
	
	public String getDateOfJoining() {
		return dateOfJoining!=null?dateOfJoining.toString():null;
	}
	public void setDateOfJoining(String dateOfJoining) throws ParseException {
		this.dateOfJoining = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfJoining);
	}
	
	public Date getDateOfJoiningInDate() {
		return dateOfJoining;
	}
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	@Override
	public String toString() {
		return "StudentDetails [studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfJoining=" + dateOfJoining + ", emailID=" + emailID
				+ ", houseNumber=" + houseNumber + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", status=" + status + ", gender=" + gender + ", phoneNo=" + phoneNo
				+ ", emergencyContact=" + emergencyContact + "]";
	}
	
	
	
	
	
	
	
	
	
}
