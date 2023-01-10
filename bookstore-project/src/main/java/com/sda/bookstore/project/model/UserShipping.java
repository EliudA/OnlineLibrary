package com.sda.bookstore.project.model;

//import jakarta.persistence.*;
import javax.persistence.*;
@Entity
@Table(name="user_shipping")
public class UserShipping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userShippingName;
	private String userShippingStreet1;
	private String userShippingCity;
	private String userShippingCounty;
	private String userShippingZipcode;
	private boolean userShippingDefault;
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	public UserShipping() {
	}


	public UserShipping(String userShippingName, String userShippingStreet1,
                        String userShippingCity, String userShippingCounty, String userShippingZipcode,
                        boolean userShippingDefault, User user) {
		this.userShippingName = userShippingName;
		this.userShippingStreet1 = userShippingStreet1;
		this.userShippingCity = userShippingCity;
		this.userShippingCounty = userShippingCounty;
		this.userShippingZipcode = userShippingZipcode;
		this.userShippingDefault = userShippingDefault;
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserShippingName() {
		return userShippingName;
	}


	public void setUserShippingName(String userShippingName) {
		this.userShippingName = userShippingName;
	}


	public String getUserShippingStreet1() {
		return userShippingStreet1;
	}


	public void setUserShippingStreet1(String userShippingStreet1) {
		this.userShippingStreet1 = userShippingStreet1;
	}

	public String getUserShippingCity() {
		return userShippingCity;
	}


	public void setUserShippingCity(String userShippingCity) {
		this.userShippingCity = userShippingCity;
	}

	public String getUserShippingCounty() {
		return userShippingCounty;
	}


	public void setUserShippingCounty(String userShippingCounty) {
		this.userShippingCounty = userShippingCounty;
	}


	public String getUserShippingZipcode() {
		return userShippingZipcode;
	}


	public void setUserShippingZipcode(String userShippingZipcode) {
		this.userShippingZipcode = userShippingZipcode;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public boolean isUserShippingDefault() {
		return userShippingDefault;
	}


	public void setUserShippingDefault(boolean userShippingDefault) {
		this.userShippingDefault = userShippingDefault;
	}
	
	
}
