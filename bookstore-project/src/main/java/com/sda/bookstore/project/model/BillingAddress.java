package com.sda.bookstore.project.model;

//import jakarta.persistence.*;

import javax.persistence.*;


@Entity
@Table(name="billing_address")
public class BillingAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String BillingAddressName;
	private String BillingAddressStreet1;
	private String BillingAddressCity;
	private String BillingAddressCounty;
	private String BillingAddressZipcode;
	
	@OneToOne
	private Order order;
	
	
	

	public BillingAddress() {
	}

	public BillingAddress(String billingAddressName, String billingAddressStreet,
                          String billingAddressCity, String billingAddressCounty,
                          String billingAddressZipcode,Order order) {
		BillingAddressName = billingAddressName;
		BillingAddressStreet1 = billingAddressStreet;
		BillingAddressCity = billingAddressCity;
		BillingAddressCounty = billingAddressCounty;
		BillingAddressZipcode = billingAddressZipcode;
		this.order = order;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillingAddressName() {
		return BillingAddressName;
	}

	public void setBillingAddressName(String billingAddressName) {
		BillingAddressName = billingAddressName;
	}

	public String getBillingAddressStreet1() {
		return BillingAddressStreet1;
	}

	public void setBillingAddressStreet1(String billingAddressStreet1) {
		BillingAddressStreet1 = billingAddressStreet1;
	}


	public String getBillingAddressCity() {
		return BillingAddressCity;
	}

	public void setBillingAddressCity(String billingAddressCity) {
		BillingAddressCity = billingAddressCity;
	}

	public String getBillingAddressCounty() {
		return BillingAddressCounty;
	}

	public void setBillingAddressCounty(String billingAddressCounty) {
		BillingAddressCounty = billingAddressCounty;
	}

	public String getBillingAddressZipcode() {
		return BillingAddressZipcode;
	}

	public void setBillingAddressZipcode(String billingAddressZipcode) {
		BillingAddressZipcode = billingAddressZipcode;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
