package taekwondo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PRODUCT_ORDER_DETAILS")
public class ProductOrderDetails  implements Serializable{

	@Id 
	@Column(name="Order_ID")
	private int orderID;
	
	@Id
	@Column(name="Product_ID")
	private int productID;
	
	@Column(name="Product_Quantity")
	private int productQuantity;
	
	@Column(name="Unit_Price")
	private double unitPrice;
	
	@Column(name="Total_Amount")
	private double totalAmount;
	
	
	@Transient
	private String productName;
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "ProductOrderDetails [orderID=" + orderID + ", productID=" + productID + ", productQuantity="
				+ productQuantity + ", unitPrice=" + unitPrice + ", totalAmount=" + totalAmount + ", productName="
				+ productName + "]";
	}

	
	
	
	
	
}
