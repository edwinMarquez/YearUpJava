package com.example.yearupSpring.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="account_inf")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "userid")
    private User user;
    @Column
    private Integer balance;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("acc id:%d , belongs to:%s, with balance: %.2f",id, user.getName(), (balance/100f));
    }
}
