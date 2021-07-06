package com.Gangof5.ecommerce.model;


import com.Gangof5.ecommerce.enums.Gender;
import com.Gangof5.ecommerce.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    private Review review;

    public User(Integer id, Review review, String firstName, String lastName, String email, Role role, String password,
			List<Order> orders, List<Claim> claims, List<BookUser> books, Book bookAdded) {
		super();
		this.id = id;
		this.review = review;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.password = password;
		this.orders = orders;
		this.claims = claims;
		this.books = books;
		this.bookAdded = bookAdded;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public List<BookUser> getBooks() {
		return books;
	}

	public void setBooks(List<BookUser> books) {
		this.books = books;
	}
	@Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Lob
	private byte[] avatar;
    

    private String address;
    

    private Gender gender;
    
    private String country;
    
    private Date birthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

   

    @JsonIgnore
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Order> orders;
    
    @JsonIgnore
    @OneToMany(mappedBy = "userclaim",
            fetch = FetchType.LAZY)
    private List<Claim> claims;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public User(String firstName, String lastName, String email, Role role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }
    

    public User(String firstName, String lastName, String email, String password, String address, Gender gender,
			String country, Date birthday, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.gender = gender;
		this.country = country;
		this.birthday = birthday;
		this.role = role;
	}

	public User() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	@OneToMany(
	        mappedBy = "user",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	    private List<BookUser> books = new ArrayList<>();
	
	@OneToOne
	private Book bookAdded;

	public Book getBookAdded() {
		return bookAdded;
	}

	public void setBookAdded(Book bookAdded) {
		this.bookAdded = bookAdded;
	}
    
}
