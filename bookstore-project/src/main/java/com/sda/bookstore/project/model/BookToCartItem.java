package com.sda.bookstore.project.model;

//import jakarta.persistence.*;


import javax.persistence.*;

@Entity
@Table(name="book_to_cart_item")
public class BookToCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="cart_item_id")
	private CartItem cartItem;
	
	
	

	public BookToCartItem() {
	}

	public BookToCartItem(Book book, CartItem cartItem) {
		this.book = book;
		this.cartItem = cartItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

}
