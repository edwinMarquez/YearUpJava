package com.example.yearupSpring.models;


import javax.persistence.*;

@Entity(name="account_inf")
public class Account {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id",table = "userId")
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
