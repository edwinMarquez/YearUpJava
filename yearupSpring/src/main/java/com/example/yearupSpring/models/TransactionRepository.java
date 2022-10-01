package com.example.yearupSpring.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM transaction_inf t WHERE t.fromUser.id=?1 or t.toUser.id=?1")
    Collection<Transaction> getActivity(int userid);

}
