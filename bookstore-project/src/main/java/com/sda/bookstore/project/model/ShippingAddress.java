package com.sda.bookstore.project.model;

//import jakarta.persistence.*;
import javax.persistence.*;
@Entity
@Table(name="shipping_address")
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ShippingAddressName;
	private String ShippingAddressStreet1;
	private String ShippingAddressCity;
	private String ShippingAddressCounty;
	private String ShippingAddressZipcode;
	
	
	@OneToOne
	private Order order;
	
	


	public ShippingAddress() {
	}


	public ShippingAddress(String shippingAddressName, String shippingAddressStreet1,
                           String shippingAddressCity, String shippingAddressCounty, String shippingAddressCountry,
                           String shippingAddressZipcode, Order order) {
		ShippingAddressName = shippingAddressName;
		ShippingAddressStreet1 = shippingAddressStreet1;
		ShippingAddressCity = shippingAddressCity;
		ShippingAddressCounty = shippingAddressCounty;
		ShippingAddressZipcode = shippingAddressZipcode;
		this.order = order;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getShippingAddressName() {
		return ShippingAddressName;
	}


	public void setShippingAddressName(String shippingAddressName) {
		ShippingAddressName = shippingAddressName;
	}


	public String getShippingAddressStreet1() {
		return ShippingAddressStreet1;
	}


	public void setShippingAddressStreet1(String shippingAddressStreet1) {
		ShippingAddressStreet1 = shippingAddressStreet1;
	}

	public String getShippingAddressCity() {
		return ShippingAddressCity;
	}


	public void setShippingAddressCity(String shippingAddressCity) {
		ShippingAddressCity = shippingAddressCity;
	}


	public String getShippingAddressCounty() {
		return ShippingAddressCounty;
	}


	public void setShippingAddressCounty(String shippingAddressCounty) {
		ShippingAddressCounty = shippingAddressCounty;
	}

	public String getShippingAddressZipcode() {
		return ShippingAddressZipcode;
	}


	public void setShippingAddressZipcode(String shippingAddressZipcode) {
		ShippingAddressZipcode = shippingAddressZipcode;
	}

	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}

}
