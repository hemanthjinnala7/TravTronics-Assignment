package com.assignment.travtronics.model;

import com.assignment.travtronics.repository.UserRepository;
import jakarta.persistence.*;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    private List<ProductModel> cart = new ArrayList<>();

    // Getters and setters
    public List<ProductModel> getCart() {
        return cart;
    }

    public void setCart(List<ProductModel> cart) {
        this.cart = cart;
    }


    @ManyToMany
    private List<ProductModel> Orders = new ArrayList<>();

    public List<ProductModel> getOrders() {
        return Orders;
    }

    public void setOrders(List<ProductModel> orders) {
        this.Orders = orders;
    }


}
