package taekwondo.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT_FEE")
public class StudentFee implements Serializable{

	@Id
	@Column(name="Student_ID")
	private int studentID;
	
	@Id 
	@Column(name="Class_ID")
	private int classID;
	
	@Id
	@Column(name="PAYMENT_DATE")
	private Date paymentDate;

	
	@Column(name="FEE_AMOUNT")
	private int feeAmount;

	@Transient
	private String studentName;
	
	@Transient
	
	private String className;
	
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public int getClassID() {
		return classID;
	}


	public void setClassID(int classID) {
		this.classID = classID;
	}


	public String getPaymentDate() {
		return paymentDate.toString();
	}


	public void setPaymentDate(String paymentDate) throws ParseException {
		this.paymentDate = new SimpleDateFormat("yyyy-MM-dd").parse(paymentDate);
	}


	public int getFeeAmount() {
		return feeAmount;
	}


	public void setFeeAmount(int feeAmount) {
		this.feeAmount = feeAmount;
	}
	
	@Override
	public String toString() {
		return "StudentFee [studentID=" + studentID + ", classID=" + classID + ", paymentDate=" + paymentDate
				+ ", feeAmount=" + feeAmount + "]";
	}
	
}
