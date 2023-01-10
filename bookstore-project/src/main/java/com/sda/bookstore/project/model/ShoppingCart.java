package com.sda.bookstore.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal GrandTotal;
	
	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<CartItem> cartItemList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	
	

	public ShoppingCart() {
	}

	public ShoppingCart(BigDecimal grandTotal, List<CartItem> cartItemList, User user) {
		GrandTotal = grandTotal;
		this.cartItemList = cartItemList;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		GrandTotal = grandTotal;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
