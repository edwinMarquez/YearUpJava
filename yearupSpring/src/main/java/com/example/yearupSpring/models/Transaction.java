package com.example.yearupSpring.models;


import javax.persistence.*;

@Entity(name = "transaction_inf")
public class Transaction {


    @Id
    @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "fromuser", nullable = false)
    private User fromUser;

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "touser", nullable = false)
    private User toUser;


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

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
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
        return String.format("Transaction id:%d fromUser:%s toUser:%s amount:%d, timeStamp:%d",id, fromUser.getName(), toUser.getName(), amount, transactionTime);
    }
}
