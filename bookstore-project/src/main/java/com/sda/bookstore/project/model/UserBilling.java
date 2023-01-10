package com.sda.bookstore.project.model;

//import jakarta.persistence.*;
import javax.persistence.*;
@Entity
@Table(name="user_billing")
public class UserBilling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userBillingName;
	private String userBillingStreet1;
	private String userBillingCity;
	private String userBillingCounty;
	private String userBillingZipcode;

	@OneToOne(cascade=CascadeType.ALL)
	private UserPayment userPayment;



	public UserBilling() {
	}

	public UserBilling(String userBillingName, String userBillingStreet1,
                       String userBillingCity, String userBillingCounty, String userBillingCountry,
					   String userBillingZipcode,UserPayment userPayment
                       ) {
		this.userBillingName = userBillingName;
		this.userBillingStreet1 = userBillingStreet1;
		this.userBillingCity = userBillingCity;
		this.userBillingCounty = userBillingCounty;
		this.userBillingZipcode = userBillingZipcode;
		this.userPayment = userPayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserBillingName() {
		return userBillingName;
	}

	public void setUserBillingName(String userBillingName) {
		this.userBillingName = userBillingName;
	}

	public String getUserBillingStreet1() {
		return userBillingStreet1;
	}

	public void setUserBillingStreet1(String userBillingStreet1) {
		this.userBillingStreet1 = userBillingStreet1;
	}

	public String getUserBillingCity() {
		return userBillingCity;
	}

	public void setUserBillingCity(String userBillingCity) {
		this.userBillingCity = userBillingCity;
	}

	public String getUserBillingCounty() {
		return userBillingCounty;
	}

	public void setUserBillingCounty(String userBillingCounty) {
		this.userBillingCounty = userBillingCounty;
	}
	public String getUserBillingZipcode() {
		return userBillingZipcode;
	}

	public void setUserBillingZipcode(String userBillingZipcode) {
		this.userBillingZipcode = userBillingZipcode;
	}

	public UserPayment getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}

}
