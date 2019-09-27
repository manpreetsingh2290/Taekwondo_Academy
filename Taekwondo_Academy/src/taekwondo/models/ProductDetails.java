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
@Table(name = "PRODUCT_DETAILS")
@SequenceGenerator(name= "PRODUCT_ID_SEQ", sequenceName = "PRODUCT_ID_SEQ", initialValue=1, allocationSize = 1)
public class ProductDetails  implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_ID_SEQ")
	@Column(name="Product_ID")
	private int productID;
	
	@Column(name="Product_Name")
	private String productName;
	
	@Column(name="Product_Description")
	private String productDescription;
	
	@Column(name="Cost_Price")
	private double costPrice;
	
	@Column(name="Selling_Price")
	private double sellingPrice;
	
	@Column(name="Creation_Time")
	private String creationTime;
	
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	@Override
	public String toString() {
		return "ProductDetails [productID=" + productID + ", productName=" + productName + ", productDescription="
				+ productDescription + ", costPrice=" + costPrice + ", sellingPrice=" + sellingPrice + ", creationTime="
				+ creationTime + "]";
	}
	
	
	
}
