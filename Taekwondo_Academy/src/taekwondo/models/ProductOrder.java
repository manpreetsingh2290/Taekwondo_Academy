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
@Table(name = "PRODUCT_ORDER")
@SequenceGenerator(name= "ORDER_ID_SEQ", sequenceName = "ORDER_ID_SEQ", initialValue=1, allocationSize = 1)
public class ProductOrder  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_ID_SEQ")
	@Column(name="Order_ID")
	private int orderID;
	
	@Column(name="Student_ID")
	private int studentID;
	
	@Column(name="Purchase_Date")
	private Date purchaseDate;
	
	@Transient
	private String studentName;
		

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getPurchaseDate() {
		//return purchaseDate.toString();
		return purchaseDate!=null?purchaseDate.toString():null;
	}

	public void setPurchaseDate(String purchaseDate) throws ParseException {
		this.purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(purchaseDate);
	}

	@Override
	public String toString() {
		return "ProductOrder [orderID=" + orderID + ", studentID=" + studentID + ", purchaseDate=" + purchaseDate
				+ ", studentName=" + studentName + "]";
	}
	
	
	
	
}
