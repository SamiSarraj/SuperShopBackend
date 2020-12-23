package com.sami.supershop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class WalletTransactions extends BaseEntity{
    private Float amount;
    private Date transactionsDate;
    private String paymentMethod;
    @ManyToOne
    private Wallet wallet;
}
