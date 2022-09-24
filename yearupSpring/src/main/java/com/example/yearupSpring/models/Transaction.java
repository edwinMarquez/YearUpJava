package com.example.yearupSpring.models;


import javax.persistence.*;

@Entity(name = "transaction_inf")
public class Transaction {


    @Id
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column
    private Integer amount;

    @Column(name = "transactiontime")
    private Long transactionTime;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Long transactionTime) {
        this.transactionTime = transactionTime;
    }


    @Override
    public String toString() {
        return String.format("Transaction id:%d user:%s amount:%d, timeStamp:%d",id, user.getName(), amount, transactionTime);
    }
}
