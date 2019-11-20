package com.niit.Ecommerce_Bd_ILT.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductModel")
public class ProductModel implements Serializable
{
private static final long serialVersionUID=1L;
@Id
@Column(name="Productid")
private int productid;
@Column(name="productname")
private String productname;
@Column(name="productprice")
private int productprice;
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getProductprice() {
	return productprice;
}
public void setProductprice(int productprice) {
	this.productprice = productprice;
}
}
