package com.Gangof5.ecommerce.model;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "wishlist")
public class WishList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Book book;

    public WishList() {
    }


    public WishList(User user, Book book) {
        this.user = user;
        this.book = book;
        this.createdDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
